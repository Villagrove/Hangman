package com.vu.se.hm.gui;

import com.vu.se.hm.service.WordGuesser;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * ViewController. This is the interface for the hangman game.
 * ActionListener, HangmanEventListener
 */
public abstract class ViewController implements ActionListener, HangmanEventListener{
    
    private GraphicsPanel graphics;
    private GuessPanel guess;
    protected WordGuesser guesser;
    private JFrame frame;
    
    /**
     * Constructor.
     * @param guesser The specific GuesserInterface to be used.
     * @param gameAdmin True if this interface is for the host.
     */
    public ViewController(WordGuesser guesser){
        frame = new JFrame("TMNT Hangman");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setMinimumSize(new Dimension(640,440));
        frame.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        this.guesser = guesser;
        
        c.gridx = 1;
        c.gridy = 0;
        graphics = new GraphicsPanel();
        frame.add(graphics, c);
        
        c.gridx = 1;
        c.gridy = 1;
        guess = new GuessPanel(guesser.getDisguisedWord());
        frame.add(guess, c);
    }
    
    public void addPanel(JPanel panel){
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 2;
        frame.add(panel, c);
        frame.pack();
        frame.setVisible(true);
    }
    
    /**
     * update(). Called when a EventType.update has be received.
     * @param letter 
     */
    public void update(char letter){
        guess.setWord(guesser.getDisguisedWord());
        graphics.setWrongs(guesser.getMissCount());
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
