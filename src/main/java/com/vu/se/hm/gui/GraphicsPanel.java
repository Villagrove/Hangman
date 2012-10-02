
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
    
    private int wrongs;
    
    /**
     *
     * @return Preferred Dimensions for this panel
     */
    @Override
    public Dimension getPreferredSize(){
        return new Dimension(320, 240);
    }
    
    /**
     *
     * @param wrongs number of incorrect guesses
     */
    public void setWrongs(int wrongs){
        if(wrongs > 6){
            wrongs = 6;
        }else if (wrongs < 0){
            wrongs = 0;
        }
        this.wrongs = wrongs;
        this.repaint();
    }
    

    /**
     * Paints the stick figure, switch fall thru is intentional
     * @param g Graphics context to draw upon
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
        
        switch(wrongs){
            case 6: g.drawLine(185, 130, 205, 145); // Right Leg
            case 5: g.drawLine(185, 130, 165, 145); // Left Leg     
            case 4: g.drawLine(185, 85, 205, 100); // Right Arm
            case 3: g.drawLine(185, 85, 165, 100); // Left Arm
            case 2: g.drawLine(185, 70, 185, 130); // Body
            case 1: g.fillOval(170, 40, 30, 30); // Head 
                    break;
            default: break;
        }
    }
}