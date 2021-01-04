/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jmstopicsfinancialsystems;

/**
 *
 * @author JGUTIERRGARC
 */
import javax.jms.*;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import java.util.*;

public class MessageSender {

    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;

    // default broker URL is : tcp://localhost:61616"
    private static String s1 = "Telecomunications";
    private static String s2 = "Banks";
    private static String s3 = "Transportation";
    private static String s4 = "FoodSupply";
    private static String s5 = "Education";

    public void produceMessages() {
        MessageProducer messageProducer;
        TextMessage textMessage;
        Random r = new Random();
        try {
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
            Connection connection = connectionFactory.createConnection();
            connection.start();

            Session session = connection.createSession(false /*Transacter*/, Session.AUTO_ACKNOWLEDGE);
            Destination d1 = session.createTopic(s1);
            Destination d2 = session.createTopic(s2);
            Destination d3 = session.createTopic(s3);
            Destination d4 = session.createTopic(s4);
            Destination d5 = session.createTopic(s5);
            
            Destination[ ]   message ={d1,d2,d3,d4,d5};
            for (int i = 0; i < 10; i++) {                  
            messageProducer = session.createProducer(message[(r.nextInt(5))]);
            
            
            textMessage = session.createTextMessage();
            int imp =(1+r.nextInt(10));
            
            textMessage.setText(""+imp);
            System.out.println("Mensaje: " + textMessage.getText());
            messageProducer.send(textMessage);
            
            messageProducer.close();
            textMessage.setText("Goodbyeeeee");
            }
            for (int i = 0; i < 5; i++) {                  
            messageProducer = session.createProducer(message[i]);
            textMessage = session.createTextMessage();

            textMessage.setText("Goodbyeeeee");
            System.out.println("Mensaje: " + textMessage.getText());
            messageProducer.send(textMessage);
            messageProducer.close();

            }
            
            session.close();
            connection.close();
            
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MessageSender().produceMessages();
    }
}
