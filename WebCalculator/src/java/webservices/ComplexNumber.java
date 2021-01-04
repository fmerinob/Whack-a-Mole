/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;

/**
 *
 * @author Polupero
 */
public class ComplexNumber { //Nosotros agregamos el constructor, get y set 
    //autogenerados, es importante que sean los autogenerados y no cambiar 
    //sus nombres; solo podemos cambiar lo de adentro del constructor
    private double i, j;

    public ComplexNumber() {
        i = 0;
        j = 0;
    }

    public double getI() {
        return i;
    }

    public void setI(double i) {
        this.i = i;
    }

    public double getJ() {
        return j;
    }

    public void setJ(double j) {
        this.j = j;
    }
    
}
