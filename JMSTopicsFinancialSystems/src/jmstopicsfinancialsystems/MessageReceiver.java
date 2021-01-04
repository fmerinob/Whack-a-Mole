/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jmstopicsfinancialsystems;

/**
 *
 * @author JGUTIERRGARC
 */
import java.util.Random;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class MessageReceiver {

    // URL of the JMS server
    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
    // default broker URL is : tcp://localhost:61616"

    // Name of the topic we will receive messages from
    private static String s1 = "Telecomunications";
    private static String s2 = "Banks";
    private static String s3 = "Transportation";
    private static String s4 = "FoodSupply";
    private static String s5 = "Education";
    Random r = new Random();

    public void getMessages() {

        boolean goodByeReceived = false;

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
            MessageConsumer messageConsumer= session.createConsumer(message[(r.nextInt(5))]);

            while (!goodByeReceived) {
                System.out.println("Waiting for messages...");
                TextMessage textMessage = (TextMessage) messageConsumer.receive();
                if (textMessage != null) {
                    System.out.print("La noticia es de importancia: ");
                    System.out.println(textMessage.getText());
                    System.out.println();
                }
                if (textMessage.getText() != null && textMessage.getText().equals("Good bye!")) {
                    goodByeReceived = true;
                }
            }

            messageConsumer.close();
            session.close();
            connection.close();

        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MessageReceiver().getMessages();
    }

}
