package examendist;


import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import interfaces.ProcesoRMI;

public class ProcesoD {
    
    public static void main(String[] args) {
        System.setProperty("java.security.policy","D:\\Universidad\\Sistemas Distribuidos\\ExamenDist\\src\\examendist\\client.policy");
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            String name = "ProcesoRMI";
            Registry registry = LocateRegistry.getRegistry("localhost");
            ProcesoRMI PRMI = (ProcesoRMI) registry.lookup(name);
             System.out.println(PRMI.print());
            
        } catch (Exception e) {
            System.err.println("exception");
            e.printStackTrace();
        }
       
    }


}