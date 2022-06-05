package os.producer.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import os.producer.model.Article;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeoutException;

public class Sender {
    private final static String QUEUE_NAME = "qtosql";

    public static void sendToQ(List<Article> articleList) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {

            channel.queueDeclare(QUEUE_NAME, false, false, false, null);

            for(Article article : articleList){
                channel.basicPublish("", QUEUE_NAME,null, article.toBytes());
            }

            //System.out.println(" [x] Sent '" + message + "'");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

    }
}
