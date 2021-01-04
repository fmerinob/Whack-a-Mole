/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import interfaces.*;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sdist
 */
public class HioMaster extends Thread {
    private Task[] tareas;
    public HioMaster(Task[] tareas){
        this.tareas=tareas;
    }

    @Override
    public void run() {
        try {
            String name = "ImageProcessing";
            Registry registry = LocateRegistry.getRegistry("localhost"); // server's ip address
            ImageProcessing img = (ImageProcessing) registry.lookup(name);
            
            name = "DataMining";
            registry = LocateRegistry.getRegistry("localhost"); // server's ip address
            DataMining data = (DataMining) registry.lookup(name);
            
            name = "Bioinformatics";
            registry = LocateRegistry.getRegistry("localhost"); // server's ip address
            Bioinformatics bio = (Bioinformatics) registry.lookup(name);

            //LLAMADA A SERVIDOR
            for (int i = 0; i < tareas.length; i++) {
                if (tareas[i].getRequirementId() == "ImageProcessing") {
                    System.out.println(img.excecuteImageTask(tareas[i]));
                } else if (tareas[i].getRequirementId() == "DataMining") {
                    System.out.println(data.excecuteDataTask(tareas[i]));
                } else {
                    System.out.println(bio.excecuteBioTask(tareas[i]));
                }
            }
        } catch (RemoteException ex) {
            Logger.getLogger(MasterNode.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(MasterNode.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
