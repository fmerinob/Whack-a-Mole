package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.math.BigDecimal;
import interfaces.Compute;

public class ComputeClient {
    public static void main(String args[]) {
        System.setProperty("java.security.policy","D:/Universidad/Sistemas Distribuidos/JavaRMI/src/client/client.policy");
        
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            String name = "Compute";
            Registry registry = LocateRegistry.getRegistry("localhost"); // server's ip address args[0]
            Compute comp = (Compute) registry.lookup(name); //Los métodos los 
//pide de la interfaz
             System.out.println("3^2 = "+comp.square(3));
             System.out.println("3^3 = "+comp.power(3, 3));
            
        } catch (Exception e) {
            System.err.println("exception");
            e.printStackTrace();
        }
    }    
}
