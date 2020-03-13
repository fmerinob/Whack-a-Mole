/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hitmonsters;

import java.util.Random;

/**
 *
 * @author Polupero
 */
public class HitMonsters {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random r=new Random();
        System.out.println(r.nextInt(4));
        String[] iconos = new String[2];
        iconos[0] = "/hitmonsters/hole.png";
        iconos[1] = "/hitmonsters/mole.png";
        //String prueba = new javax.swing.ImageIcon(getClass().getResource(iconos[0]));
    }
    
}
