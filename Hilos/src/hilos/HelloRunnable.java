/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Polupero
 */
public class HelloRunnable implements Runnable {

@Override
    //Debe de ser público para poder llamarlo
    public void run(){
        for (int i = 0; i<100; i++){
            try {
                System.out.println(Thread.currentThread().getName()+ " " + i);
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(HelloThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
