/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import interfaces.*;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sdist
 */

//En MasterNode se hacen los hilos, pero estos se ejecutan siguiendo las
//reglas de aquí, por eso el sleep esta aquí. 
//Los 3 hilos corren a la vez y entre si no se esperan.
public class SlaveNode implements Bioinformatics, DataMining, ImageProcessing, Serializable {

    public SlaveNode() throws RemoteException {
        super();
    }

    @Override
    public String excecuteBioTask(Task aTask) throws RemoteException {
        try {
            TimeUnit.SECONDS.sleep(aTask.getLength());
        } catch (InterruptedException ex) {
            Logger.getLogger(SlaveNode.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Bio: " + aTask.getTaskId() + " Completado";
    }

    @Override
    public String excecuteDataTask(Task aTask) throws RemoteException {
        try {
            TimeUnit.SECONDS.sleep(aTask.getLength());
        } catch (InterruptedException ex) {
            Logger.getLogger(SlaveNode.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Data: " + aTask.getTaskId() + " Completado";
    }

    @Override
    public String excecuteImageTask(Task aTask) throws RemoteException {
        try {
            TimeUnit.SECONDS.sleep(aTask.getLength());
        } catch (InterruptedException ex) {
            Logger.getLogger(SlaveNode.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Image: " + aTask.getTaskId() + " Completado";
    }

    public static void main(String[] args) {
        try {
            System.setProperty("java.security.policy", "file:/D:\\Universidad\\Sistemas Distribuidos\\JavaBoTs\\src\\server\\server.policy");
            if (System.getSecurityManager() == null) {
                System.setSecurityManager(new SecurityManager());
            }

            LocateRegistry.createRegistry(1099);

            String name = "Bioinformatics";
            SlaveNode engine = new SlaveNode();
            Bioinformatics stubBio = (Bioinformatics) UnicastRemoteObject.exportObject(engine, 0);
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind(name, stubBio);
            
            name = "DataMining";
            engine = new SlaveNode();
            DataMining stubData = (DataMining) UnicastRemoteObject.exportObject(engine, 0);
            registry = LocateRegistry.getRegistry();
            registry.rebind(name, stubData);
            
            
            name = "ImageProcessing";
            engine = new SlaveNode();
            ImageProcessing stubImage = (ImageProcessing) UnicastRemoteObject.exportObject(engine, 0);
            registry = LocateRegistry.getRegistry();
            registry.rebind(name, stubImage);

        } catch (RemoteException ex) {
            Logger.getLogger(SlaveNode.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
