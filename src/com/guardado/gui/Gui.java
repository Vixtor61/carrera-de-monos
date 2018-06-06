/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guardado.gui;
import com.guardado.threads.AnimalThreads;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author LN710Q
 */
public class Gui extends JFrame {
    private JLabel[] labels;
    private JButton inicio;
    private JButton reinicio;
    private String[] nombres = {"canguro", "tortuga", "dragon"};
    
    public Gui(){
        super("Carrera de animales");
        initialComponents();
    }
    
    public void initialComponents(){
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setLayout(null);
       labels = new JLabel[3];
       inicio = new JButton("inicion");
       Container container = getContentPane();
       
       for(int i=0;i<3;i++) {
               labels[i]=new JLabel();
       labels[i].setIcon(new ImageIcon(getClass().getResource(nombres[i]+".gif")));
       labels[i].setBounds(10,(i*200)+10, 200, 200);
           container.add(labels[i]);
       }
       inicio.setBounds(10, 0, 100, 30);
       inicio.addActionListener(new ActionListener(){
 
           @Override
           public void actionPerformed(ActionEvent e) {
               AnimalThreads canguro  = new AnimalThreads("canguro",510,labels[0].getX(),labels[0].getY(),labels[0]);
         AnimalThreads tortuga  = new AnimalThreads("tortuga",510,labels[1].getX(),labels[1].getY(),labels[1]);
         AnimalThreads dragon  = new AnimalThreads("dragon",510,labels[2].getX(),labels[2].getY(),labels[2]);
         canguro.start();
         tortuga.start();
         dragon.start();
           }
       });
       container.add(inicio);
       setSize(700,650);
       
       
               
               }
    public static void main(String[] args){
        java.awt.EventQueue.invokeLater(new Runnable(){
            @Override
            public void run() {
       new Gui().setVisible(true);
            }
            
        });
    }
}