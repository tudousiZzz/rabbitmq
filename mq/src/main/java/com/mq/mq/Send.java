package com.mq.mq;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;


/**
 * @ClassName Send
 * @Description TODO
 * @Author Nanxing Tang
 * @Date 2022--01--03--22:32
 **/
public class Send {
    private final static String QUEUE_NAME = "hello";

    public static void main(String[] args) throws Exception{
        ConnectionFactory factory = new ConnectionFactory();
        try {
            Connection connection = factory.newConnection("120.24.43.68");
            Channel channel = connection.createChannel();
            channel.queueDeclare(1, QUEUE_NAME, false, false, false, false, null);
            String message = "Hello World!";
            channel.basicPublish(1, "", QUEUE_NAME, null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");
        } finally {

        }

    }
}
