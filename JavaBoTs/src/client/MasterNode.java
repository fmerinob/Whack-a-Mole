package client;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import interfaces.*;

/**
 *
 * @author sdist
 */
public class MasterNode extends Thread {

    public static void main(String[] args) {
        Task[] image1 = {new Task(1, "ImageProcessing", 5), new Task(2, "ImageProcessing", 10), new Task(3, "ImageProcessing", 15), new Task(4, "ImageProcessing", 20),
        new Task(5, "ImageProcessing", 30), new Task(6, "ImageProcessing", 5), new Task(7, "ImageProcessing", 10), new Task(8, "ImageProcessing", 15),
        new Task(9, "ImageProcessing", 20), new Task(10, "ImageProcessing", 30)}; 
        Task[] data1 = { new Task(11, "DataMining", 5), new Task(12, "DataMining", 10), new Task(13, "DataMining", 15), new Task(14, "DataMining", 20),
        new Task(15, "DataMining", 30), new Task(16, "DataMining", 5), new Task(17, "DataMining", 10), new Task(18, "DataMining", 15),
        new Task(19, "DataMining", 20), new Task(20, "DataMining", 30), new Task(21, "DataMining", 5), new Task(22, "DataMining", 10),
        new Task(23, "DataMining", 15), new Task(24, "DataMining", 20), new Task(25, "DataMining", 30), new Task(26, "DataMining", 5),
        new Task(27, "DataMining", 10), new Task(28, "DataMining", 15), new Task(29, "DataMining", 20), new Task(30, "DataMining", 30)};
        Task[] bio1 = {new Task(31, "Bioinformatics", 5), new Task(32, "Bioinformatics", 10), new Task(33, "Bioinformatics", 15),
         new Task(34, "Bioinformatics", 20), new Task(35, "Bioinformatics", 30), new Task(36, "Bioinformatics", 5),
        new Task(37, "Bioinformatics", 10), new Task(38, "Bioinformatics", 15), new Task(39, "Bioinformatics", 20),
        new Task(40, "Bioinformatics", 30), new Task(41, "Bioinformatics", 5), new Task(42, "Bioinformatics", 10),
        new Task(43, "Bioinformatics", 15), new Task(44, "Bioinformatics", 20), new Task(45, "Bioinformatics", 30)};

        System.setProperty("java.security.policy", "file:/D:\\Universidad\\Sistemas Distribuidos\\JavaBoTs\\src\\client\\client.policy");
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        //El resto del código que normalmente seguiría aquí, está en HioMaster.
        HioMaster image = new HioMaster(image1);
        HioMaster data = new HioMaster(data1);
        HioMaster bio = new HioMaster(bio1);
        image.start();
        data.start();
        bio.start();
    }
}
