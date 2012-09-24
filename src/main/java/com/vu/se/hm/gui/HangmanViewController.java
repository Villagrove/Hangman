package com.vu.se.hm.gui;

import java.awt.GridLayout;
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
        frame.setLayout(new GridLayout(3,0));
        frame.add(new GraphicsPanel());
        frame.add(new GuessPanel(word));
        frame.add(new LettersPanel(this));
        frame.pack();
        frame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        JButton temp = (JButton) e.getSource();
    }
}

