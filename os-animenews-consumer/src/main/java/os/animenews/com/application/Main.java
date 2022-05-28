package os.animenews.com.application;

import os.animenews.rabbitmq.Receiver;

public class Main {

    public static void main(String[] args){
        Receiver.receiveFromQ();
    }
}
