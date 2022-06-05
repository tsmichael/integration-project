package os.consumer.com.application;

import os.consumer.rabbitmq.Receiver;

public class Main {

    public static void main(String[] args){
        Receiver.receiveFromQ();
    }
}
