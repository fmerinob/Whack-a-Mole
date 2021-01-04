package server;


import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import interfaces.Compute;

public class ComputeServer implements Compute {
//Primero se debe implementar la interfaz, luego se debe de crear el registry,
//luego se genera el engine (se llama a la misma clase), y se genera el stub
//usando la interfaz y el engine, por último se agrega al registry el stub.

    public ComputeServer() throws RemoteException{
        super();
    }

    @Override
    public double square(int number) throws RemoteException {
        return (number*number);
    }

    @Override
    public double power(int num1, int num2) throws RemoteException {
        return (java.lang.Math.pow(num1, num2));
    }    
    
    public static void main(String[] args) {
        System.setProperty("java.security.policy","D:/Universidad/Sistemas Distribuidos/JavaRMI/src/server/server.policy");
        if (System.getSecurityManager() == null) {
           System.setSecurityManager(new SecurityManager());
        }
        
        try {
            // start the rmiregistry 
            LocateRegistry.createRegistry(1099);   /// default port
            //Se despliega servidor 
            String name = "Compute";
            ComputeServer engine = new ComputeServer();
            Compute stub = (Compute) UnicastRemoteObject.exportObject(engine, 0);
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind(name, stub);

        } catch (Exception e) {
            System.err.println("ComputeEngine exception:");
            e.printStackTrace();
        }
    }


}