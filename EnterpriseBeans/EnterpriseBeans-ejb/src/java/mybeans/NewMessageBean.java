/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybeans;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author Polupero
 */
@JMSDestinationDefinition(name = "java:app/queue1", interfaceName = "javax.jms.Queue", resourceAdapter = "jmsra", destinationName = "queue1")
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:app/queue1")
    ,
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class NewMessageBean implements MessageListener {
    
    public NewMessageBean() {
    }
    
    @Override
    public void onMessage(Message message) {
        
        try {
            System.out.println("Mi mensaje: "+((TextMessage)message).getText());
        } catch (JMSException ex) {
            Logger.getLogger(NewMessageBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
