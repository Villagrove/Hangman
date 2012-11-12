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
public class ServerViewController extends ViewController{
    
    private AdminPanel admin;
    
    public ServerViewController(WordGuesser guesser){
        super(guesser);
        admin = new AdminPanel(this);
        super.addPanel(admin);
    }
    
    @Override
    public void update(char letter){
        super.update(letter);
        admin.setLetters(guesser.getLettersGuessed().toString());
    }
    
    /**
     * actionPerformed. Called when a letter button is pressed.
     * @param e button pressed
     */
    @Override
    public void actionPerformed(ActionEvent e){
            String action = e.getActionCommand();
            if(action != null){
                
            }
    }
}
