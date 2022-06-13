package os.consumer.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import os.consumer.jdbc.QueryDB;
import os.model.Article;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.util.concurrent.TimeoutException;


public class Receiver {

    private final static String QUEUE_NAME = "qtosql";

    public static void receiveFromQ() {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = null;
        try {
            connection = factory.newConnection();
            Channel channel = connection.createChannel();
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                Article article = fromBytes(delivery.getBody());

                System.out.println(" [x] Received '" + article.toString() + "'");
                QueryDB.insertIntoArticleTable(article);
                System.out.println("INSERTED 0 1");
            };
            channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> { });

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }


    }

    public static Article fromBytes(byte[] bytes) {
        Article article = null;
        try {
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
            ObjectInput in = null;
            in = new ObjectInputStream(bais);
            article = (Article) in.readObject();
            in.close();
            bais.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (Exception eee) {
            eee.printStackTrace();
        }
        return article;
    }


}
