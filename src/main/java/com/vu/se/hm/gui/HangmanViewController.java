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
 * Action Listener for Letters Panel, and Admin Panel
 * @author Dan Cannon
 */
public class HangmanViewController implements ActionListener{
    
    private GraphicsPanel graphics;
    private GuessPanel guess;
    private LettersPanel letters;
    private WordGuesser guesser;
    private Boolean admin = false;
    
    public HangmanViewController(String word){
        JFrame frame = new JFrame("TMNT Hangman");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(640,440));
        frame.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        guesser = new WordGuesser(word);
        
        c.gridx = 1;
        c.gridy = 0;
        graphics = new GraphicsPanel();
        frame.add(graphics, c);
        
        c.gridx = 1;
        c.gridy = 1;
        guess = new GuessPanel(guesser.getDisguisedWord());
        frame.add(guess, c);
        
        c.gridx = 1;
        c.gridy = 2;
        letters = new LettersPanel(this);
        frame.add(letters, c);
        
        frame.pack();
        frame.setVisible(true);
    }
    
    public void guessLetter(char letter){
        guesser.guess(letter);
        letterGuessed(letter);
    }
    
    public void letterGuessed(char letter){
        guess.setWord(guesser.getDisguisedWord());
        graphics.setWrongs(guesser.getMissCount());
        letters.disableButton(letter);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
            String action = e.getActionCommand();
            if(action != null){
                if(action.length() == 1){
                    letters.disableButton(action.charAt(0));
                    guessLetter(action.charAt(0));
                }
            }
    }
    
}
