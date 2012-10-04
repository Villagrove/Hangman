/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vu.se.hm.gui;

import java.awt.Graphics;
import java.awt.event.ActionListener;
import javax.swing.*;


/**
 *
 * @author capnhowdy21
 */
public class AdminPanel extends JPanel{
    private JComboBox players;
    private JButton kick;
    private String letters;

    
    public AdminPanel(ActionListener controller){
        players = new JComboBox();

        kick = new JButton("Kick");
        kick.addActionListener(controller);

        letters = "";
        
        this.add(players);
        this.add(kick);
    }
    
    public void addPlayer(){
        players.addItem(null);
    }
    
    public void setLetters(String letters){
        this.letters = letters;
        this.repaint();
    }
    
    @Override
    public void paint(Graphics g){
        g.drawString(letters, this.getWidth()/2 + 20, this.getHeight()/2 - 10);
    }
}
