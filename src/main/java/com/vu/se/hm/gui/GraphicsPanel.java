/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vu.se.hm.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * Graphics Panel
 * Draws the stick figure
 * @author Dan Cannon
 */
public class GraphicsPanel extends JPanel{
    
    
    @Override
    public Dimension getPreferredSize(){
        return new Dimension(320, 240);
    }
    
    /*
     * Paints the the stick figure.
     * Static right now, needs work.
     */
    @Override
    public void paint(Graphics g){
        super.paint(g);
        Dimension size = this.getSize();
        
        g.fillRect(120, 20, 10, 160);
        g.fillRect(80, 180, 90, 10);
        g.fillRect(120, 10, 70, 10);
        g.fillRect(180, 20, 10, 20);
        
        g.setColor(Color.RED);
        g.fillOval(170, 40, 30, 30);
        g.fillRect(183, 70, 5, 60);
        g.fillRect(163, 90, 20, 5);
    }
}