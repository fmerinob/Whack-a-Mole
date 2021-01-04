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
public class Counter {
    
    private int n = 0;
    
    public Counter(int n){
        this.n = n;
    }
    
    //public synchronized void aMethod(){ De no poner synchronized, entran como
    //Dios les de a entender, al ponerlo, primero va uno y luego va el otro
    public void aMethod(){//Ahora quitamos el synchronized y lo ponemos en el de
//imprimir para hacer que no vaya uno primero completo y luego el otro completo, 
//si no que se vayan cambiando entre si
        for(int i = 0; i<10000; i++){
//            n++;
//            System.out.println(n + "" + Thread.currentThread().getName());
//Esto se hace mejor con imprimir para que se aumente y luego se imprima y se 
//eviten errores
            imprimir();
        }
    }
    
    public synchronized void imprimir(){
        n++;
        System.out.println(n + "" + Thread.currentThread().getName());
    }

}
