package org.anzo;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.Message;

import javax.jms.*;
import javax.xml.soap.Text;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MsgSend {

    public static void main(String[] args) throws Exception {

        BufferedReader set = new BufferedReader(new InputStreamReader(System.in));

        String s  = set.readLine();

        ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory("tcp://localhost:61616");

        Connection connection = cf.createConnection();

        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue("Test");

        MessageProducer sender = session.createProducer(queue);

        TextMessage msg = session.createTextMessage(s);
        sender.send(msg);
        System.out.println("Message sent");


    }


}
