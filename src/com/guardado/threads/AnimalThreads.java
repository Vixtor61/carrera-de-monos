/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guardado.threads;

import javax.swing.JLabel;

/**
 *
 * @author LN710Q
 */
public class AnimalThreads extends Thread {
    private String nombre;
    private int limite;
    private JLabel animal;
    private int x;
    private int y;
    
    public AnimalThreads(){}
    
    public AnimalThreads(String nombre, int limite, int x, int y, JLabel animal){
        this.nombre = nombre;
        this.x = x;
        this.y = y;
        this.limite = limite;
        this.animal = animal;
    }
    
    @Override
    public void run(){
        int g = 0;
        for (int i=0; i<=this.limite; i+=10)
        {
            System.out.println(this.nombre + "avanza");
            
            this.animal.setLocation(i,y);
            if(this.nombre == "tortuga"){
                try {
                sleep(1000);
            } catch (InterruptedException e){
                e.printStackTrace();  
                
            }
            }
            try {
                sleep(100);
            } catch (InterruptedException e){
                e.printStackTrace();  
                
            }
            g=i+10;
            yield();
        }
        System.out.println(this.nombre + " a llegado a la meta");
        for (int i=g; i>=0; i-=10)
        {
            System.out.println(this.nombre + "avanza");
            this.animal.setLocation(i,y);
            if(this.nombre == "tortuga"){
                try {
                sleep(1000);
            } catch (InterruptedException e){
                e.printStackTrace();  
                
            }
            }
            try {
                sleep(100);
            } catch (InterruptedException e){
                e.printStackTrace();  
                
            }
            yield();
        }
        System.out.println(this.nombre + " a regraso");
        
    }
    
    
}
