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
public class Hilos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//La diferencia entre helloThread y helloRunnable es que helloThread es una 
//clase que es un thread, mientras que helloRunnable es una clase que puede ser
//ejecutada (de ahí el runnable) a la cual convertimos en thread en su momento,
//por eso se dice que el helloRunnable es "puro".

            //        try {
//            // TODO code application logic here
//            Thread.sleep(1000);
//            //Es importante pedir el nombre del thread para saber que hilo estoy trabajando
//            System.out.println("A-" + Thread.currentThread().getName());
//            Thread.sleep(1000);
//            System.out.println("B-" + Thread.currentThread().getName());
//            Thread.sleep(1000);
//            System.out.println("C-" + Thread.currentThread().getName());
//        } catch (InterruptedException ex) {
//            Logger.getLogger(Hilos.class.getName()).log(Level.SEVERE, null, ex);
//        }

//Aquí se van rectos y los dos son main porque run no activa paralelismo
//        HelloThread hilo1 = new HelloThread();
//        Thread hilo2 = new Thread(new HelloRunnable());
//        System.out.println(Thread.currentThread().getName());
//        hilo1.run();
//        hilo2.run();

//Start si activa paralelismo, y además, cambia el resultado
//cada vez que le des run debido a que depende del algoritmo de
//planificación del sistema
//Los nombres de Thread-0 y Thread-1 los asigna el sistema, agrega el número 
//final por el método definido en la clase HelloRunnable y HelloThread.
//        try {
//HelloThread hilo1 = new HelloThread(); //Hilo no puro
//Thread hilo2 = new Thread(new HelloRunnable());
//System.out.println(Thread.currentThread().getName());
//hilo1.start(); //Thread - 0
//hilo1.join(1000); //Hace que solo se ejecute el 2 si ya acabó el 1 o si pasa el 
////tiempo límite, eto se puede apreciar al aumentar el hellothread a un número 
////mayor, p.e. 1000. Hace que se vea como el anterior con puro .run
////Si quito el join, debo de quitar el try catch también.
//System.out.println("Espera lol");
//hilo2.start(); //Thread - 1
//        } catch (InterruptedException ex) {
//            Logger.getLogger(Hilos.class.getName()).log(Level.SEVERE, null, ex);
//        }

//Lo que esto me dice es que con generar 2 hilos, ya sea del mismo tipo o 
//diferentes (Thread o Runnable), pueden funcionar de manera concurrente con
//el .start; además, la clase Synchronized thread no cambia en nada de 
//helloThread o helloRunnable, solo llama a otro método dentro de si y le puedes
//pasar un parámetro, pero es lo mismo.

    Counter counter = new Counter(0);
    SynchronizedThread hiloContador1 = new SynchronizedThread(counter);
    SynchronizedThread hiloContador2 = new SynchronizedThread(counter);
////    Thread hiloContador1 = new Thread(new SynchronizedThread(counter));
////    Thread hiloContador2 = new Thread(new SynchronizedThread(counter));
    hiloContador1.start();
    hiloContador2.start();
    //Al hacerlo de esta manera se interrumpen entre si, siendo que por ejemplo, 
    //si se imprimió 2 2 3 4 5, lo que pasa es que primero se incremento dos 
    //veces y luego se imprimió. O si se dió 2 3 4 5 6 7 8 9 10 11 2 12 13, lo
    //que pasa es que incrementó 2 veces luego imprimió y antes de que pudiera 
    //darse la instrucción de imprimir del hilo A, se hacen todos los 
    //incrementar e imprimir del hilo B y luego se reanuda el hilo A, dando el 
    //que estaba pendiente y luego siguiendo normal
    }
    
}
