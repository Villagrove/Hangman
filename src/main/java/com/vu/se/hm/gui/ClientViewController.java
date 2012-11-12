/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vu.se.hm.gui;

import com.vu.se.hm.service.WordGuesser;
import java.awt.event.ActionEvent;

/**
 *
 * @author capnhowdy21
 */
public class ClientViewController extends ViewController{
        
    private LettersPanel letters;
    
    public ClientViewController(WordGuesser guesser){
        super(guesser);
        letters = new LettersPanel(this);
        super.addPanel(letters);
    }
    
    /**
     * guessLetter. Called when a letter is guessed by the player
     * @param letter the char to be guessed.
     */
    public void guessLetter(char letter){
        guesser.guess(letter);
    }
    
    @Override
    public void update(char letter){
        super.update(letter);
        letters.disableButton(letter);
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
}
