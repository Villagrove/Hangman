package com.vu.se.hm.gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Hangman View Controller
 * Action Listener for Letters Panel
 * @author Dan Cannon
 */
public class HangmanViewController implements ActionListener{
    
    public HangmanViewController(String word){
        JFrame frame = new JFrame("TMNT Hangman");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(640,440));
        frame.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        c.gridx = 1;
        c.gridy = 0;
        frame.add(new GraphicsPanel(), c);
        
        c.gridx = 1;
        c.gridy = 1;
        frame.add(new GuessPanel(word), c);
        
        c.gridx = 1;
        c.gridy = 2;
        frame.add(new LettersPanel(this), c);
        
        frame.pack();
        frame.setVisible(true);
        
        
    }
    
    public void letterGuessed(char letter){
        // Send letter to model to see if correct
        // If correct send updated word to GuessPanel(Spaces for unguessed letters)
        // If incorrect increase the number of wrong guess and send to Graphics panel
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource().getClass() == JButton.class){
            JButton temp = (JButton) e.getSource();
            String letter = temp.getText();
            if(letter != null){
                temp.setEnabled(false);
                letterGuessed(letter.charAt(0));
            }
        }
    }
}

