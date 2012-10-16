package com.vu.se.hm.gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 * Hangman View Controller
 * Action Listener for Letters Panel, and Admin Panel
 * @author Dan Cannon
 */
public class HangmanViewController implements ActionListener, HangmanEventListener{
    
    private GraphicsPanel graphics;
    private GuessPanel guess;
    private LettersPanel letters;
    private AdminPanel admin;
    private Guesser guesser;
    private Boolean isAdmin = false;
    
    public HangmanViewController(Guesser guesser, boolean gameAdmin){
        JFrame frame = new JFrame("TMNT Hangman");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(640,440));
        frame.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        this.isAdmin = gameAdmin;
        this.guesser = guesser;
        
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
        if(isAdmin){
            admin = new AdminPanel(this);
            frame.add(admin, c);  
        } else {
            letters = new LettersPanel(this);
            frame.add(letters, c);
        }
        
        frame.pack();
        frame.setVisible(true);
    }
    
    public void guessLetter(char letter){
        guesser.guess(letter);
    }
    
    public void update(char letter){
        guess.setWord(guesser.getDisguisedWord());
        graphics.setWrongs(guesser.getMissCount());
        if(isAdmin){
            admin.setLetters(guesser.getLettersGuessed().toString());
        } else {
            letters.disableButton(letter);
        }      
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

    @Override
    public void handleHangmanEvent(HangmanEvent e) {
        update(e.letter);
    }
    
}
