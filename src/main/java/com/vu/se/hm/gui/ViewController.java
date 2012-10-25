package com.vu.se.hm.gui;

import com.vu.se.hm.service.WordGuesser;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 * ViewController. This is the interface for the hangman game.
 * ActionListener, HangmanEventListener
 */
public class ViewController implements ActionListener, HangmanEventListener{
    
    private GraphicsPanel graphics;
    private GuessPanel guess;
    private LettersPanel letters;
    private AdminPanel admin;
    private WordGuesser guesser;
    private Boolean isAdmin = false;
    
    /**
     * Constructor.
     * @param guesser The specific GuesserInterface to be used.
     * @param gameAdmin True if this interface is for the host.
     */
    public ViewController(WordGuesser guesser, boolean gameAdmin){
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
    
    /**
     * guessLetter. Called when a letter is guessed by the player
     * @param letter the char to be guessed.
     */
    public void guessLetter(char letter){
        guesser.guess(letter);
    }
    
    /**
     * update(). Called when a EventType.update has be received.
     * @param letter 
     */
    public void update(char letter){
        guess.setWord(guesser.getDisguisedWord());
        graphics.setWrongs(guesser.getMissCount());
        if(isAdmin){
            admin.setLetters(guesser.getLettersGuessed().toString());
        } else {
            letters.disableButton(letter);
        }      
    }
    
    /**
     * actionPerformed. Called when a letter button is pressed.
     * @param e button pressed
     */
    @Override
    public void actionPerformed(ActionEvent e){
            String action = e.getActionCommand();
            if(action != null){
                if(action.length() == 1){
                    guessLetter(action.charAt(0));
                }
            }
    }

    /**
     * handleHangmanEvent.
     * @param e the HangmanEvent that was received.
     */
    @Override
    public void handleHangmanEvent(HangmanEvent e) {
        update(e.letter);
    }
    
}
