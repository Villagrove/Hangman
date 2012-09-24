
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
    
    /*
     * GuessPanel Constructor
     * takes the word to be guessed
     */
    public GuessPanel(String word){
        this.word = word;
    }
    
     public void setWord(String word){
        this.word = word;
        this.revalidate();
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