/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 package agents;
 
 import jade.core.*;
 import jade.domain.*;
 import jade.lang.acl.*;
 
    public class HelloAgent extends Agent {
     
        protected void setup() {
            System.out.println("Hello World. ");
            System.out.println("My name local is "+getLocalName());
            System.out.println("My GUID is "+getAID().getName());
        }
    }