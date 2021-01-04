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

public class PapaObjeto {
    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
    private static String subject1 = "a";
    private static String subject2 = "b";

    public void produceMessages() {
        MessageProducer messageProducer;
        ObjectMessage objectMessage;
        try {
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
            Connection connection = connectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(false /*Transacter*/, Session.AUTO_ACKNOWLEDGE);
            
            Destination destination1 = session.createQueue(subject1);
            messageProducer = session.createProducer(destination1);
            objectMessage = session.createObjectMessage();
            objectMessage.setObject(url);
            System.out.println("Sending the following message: " + objectMessage.getObject());
            messageProducer.send(objectMessage);
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
                ObjectMessage objectMessage2 = (ObjectMessage) messageConsumer.receive();
                if (objectMessage2 != null) {
                    System.out.print("Recibí: ");
                    System.out.println(objectMessage2.getObject());
                    System.out.println();
                }
//                if (objectMessage2.getText() != null && objectMessage2.getText().equals("PapaEnvio")) {
//                    goodByeReceived = true;
//                }
            }
            messageConsumer.close();
            session.close();
            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new PapaObjeto().produceMessages();
        new PapaObjeto().getMessages();
    }
}
