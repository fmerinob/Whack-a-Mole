/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jmstopicamq;

/**
 *
 * @author JGUTIERRGARC
 */
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class MessageSender {
    
    /*
    d:
    cd descargas
    cd apache-activemq-5.15.11-bin
    cd apache-activemq-5.15.11
    bin\activemq start
    http://localhost:8161/index.html
    user and password: admin admin
    Recordar que en topic, si la persona no esta escuchando, todo lo que mande
    se va a perder, pero si estoy escuchando entonces si lo recibo, aunque sean
    varios los que lo estan escuchando; es por esto que puedo dequear el mismo
    mensaje varias veces
    */

    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;

    // default broker URL is : tcp://localhost:61616"
    private static String subject = "JOGG_QUEUE"; // Topic Name. You can create any/many topic names as per your requirement. 

    public void produceMessages() {
        MessageProducer messageProducer;
        TextMessage textMessage;
        try {
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
            Connection connection = connectionFactory.createConnection();
            connection.start();

            Session session = connection.createSession(false /*Transacter*/, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createTopic(subject);

            messageProducer = session.createProducer(destination);
            textMessage = session.createTextMessage();

            textMessage.setText("Testing, 1, 2, 3. Can you hear me?");
            System.out.println("Sending the following message: " + textMessage.getText());
            messageProducer.send(textMessage);

            textMessage.setText("Do you copy?");
            System.out.println("Sending the following message: " + textMessage.getText());
            messageProducer.send(textMessage);

            textMessage.setText("Good bye!");
            System.out.println("Sending the following message: " + textMessage.getText());
            messageProducer.send(textMessage);

            messageProducer.close();
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
