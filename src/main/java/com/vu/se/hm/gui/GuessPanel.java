
package com.vu.se.hm.gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * Guess Panel
 * This panel draws the word to be guessed.
 * @author Dan Cannon
 */
public class GuessPanel extends JPanel{
    
    private String word;
    
    /*
     * GuessPanel Constructor
     * takes the word to be guessed
     */
    public GuessPanel(String word){
        this.word = word;
    }
    
    @Override
    public Dimension getPreferredSize(){
        return new Dimension(320,50);
    }
    
    
    //Paints the word, static needs work.
    @Override
    public void paint(Graphics g){
        super.paint(g);
        
        Dimension d = this.getSize();
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.drawString(word, (d.width / 2) - (word.length() * 15),(d.height / 2) - 15); //Attempts to place word in middle of screen
        
    }
}