
package com.vu.se.hm.gui;

import java.awt.Color;
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

    /**
     * Constructor
     * @param word word to be drawn with blank spaces for letters not yet guessed
     */
    public GuessPanel(String word){
        this.word = word;
    }
    
     /**
     * @param word word to be drawn with blank spaces for letters not yet guessed
     * Tells program to repaint after word has been updated;
     */
    public void setWord(String word){
        this.word = word;
        this.revalidate();
    }
    
    /**
     * @return preferredSize
     */
    @Override
    public Dimension getPreferredSize(){
        return new Dimension(320,75);
    }
    
    
    //Paints the word
    /**
     * Paints the word on the screen and dashes
     * @param g
     */
    @Override
    public void paint(Graphics g){
        super.paint(g);
        
        Dimension d = this.getSize();
        int x = (d.width / 2) - (word.length() * 15);
        int y = d.height / 2 - 15;
        
        g.setColor(Color.BLUE);
        for (int i = 0; i < word.length(); i++){
            g.drawLine(x + (i * 25), y + 10, x + (i * 25) + 15, y + 10);
        }
        
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 30));
        for (int i = 0; i < word.length(); i++){
            g.drawString(word.substring(i, i+1), x + (i * 25), y);
        }
    }
}