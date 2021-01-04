/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jmspapaamq;

/**
 *
 * @author JGUTIERRGARC
 */
import javax.jms.*;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Papa {
    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
    private static String subject1 = "b";
    private static String subject2 = "a";

    public void produceMessages() {
        MessageProducer messageProducer;
        TextMessage textMessage;
        try {
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
            Connection connection = connectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(false /*Transacter*/, Session.AUTO_ACKNOWLEDGE);
            
            Destination destination1 = session.createQueue(subject1);
            messageProducer = session.createProducer(destination1);
            textMessage = session.createTextMessage();
            textMessage.setText("PapaEnvio");
            System.out.println("Sending the following message: " + textMessage.getText());
            messageProducer.send(textMessage);
            messageProducer.close();
            session.close();
            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
    
    public void getMessages() {
        boolean goodByeReceived = false;
        try {
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
            Connection connection = connectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(false /*Transacter*/, Session.AUTO_ACKNOWLEDGE);
            
            Destination destination2 = session.createQueue(subject2);
            MessageConsumer messageConsumer = session.createConsumer(destination2);
            while (!goodByeReceived) {
                System.out.println("Waiting for messages...");
                TextMessage textMessage2 = (TextMessage) messageConsumer.receive();
                if (textMessage2 != null) {
                    System.out.print("Recibí: ");
                    System.out.println(textMessage2.getText());
                    System.out.println();
                }
                if (textMessage2.getText() != null && textMessage2.getText().equals("PapaEnvio")) {
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
        new Papa().produceMessages();
        new Papa().getMessages();
    }
}
