package os.consumer.com.application;

import os.consumer.jdbc.JdbcUtils;
import os.consumer.rabbitmq.Receiver;

public class Main {

    public static void main(String[] args) {
        JdbcUtils.initPostgreConnection();

        Receiver.receiveFromQ();
    }
}
