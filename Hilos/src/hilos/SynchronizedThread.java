/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos;

/**
 *
 * @author Polupero
 */
public class SynchronizedThread extends Thread {
//public class SynchronizedThread implements Runnable {
    
    private Counter counter;
    
    public SynchronizedThread (Counter counter) {
        this.counter = counter;
    }
    
    public void run() {
        counter.aMethod();
    }
    
}
