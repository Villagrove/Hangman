/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vu.se.hm.gui;

import com.vu.se.hm.net.Admin;
import com.vu.se.hm.service.WordGuesser;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;


/**
 *
 * @author capnhowdy21
 */
public class ServerViewController extends ViewController{
    
    private AdminPanel adminPanel;
    private Admin server;
    private DefaultComboBoxModel<String> playerModel;
    
    
    public ServerViewController(WordGuesser guesser){
        super(guesser);
        server = (Admin)guesser;
        playerModel = new DefaultComboBoxModel();
        for (int i = 0; i < server.numPlayers(); i++){
            playerModel.addElement("Player " + (i+1));
        }
        adminPanel = new AdminPanel(this, playerModel);
        super.addPanel(adminPanel);
    }
    
    @Override
    public void update(char letter){
        super.update(letter);
        adminPanel.setLetters(guesser.getLettersGuessed().toString());
    }
    
    /**
     * actionPerformed. Called when a letter button is pressed.
     * @param e button pressed
     */
    @Override
    public void actionPerformed(ActionEvent e){
            String action = e.getActionCommand();
            if(action != null){
                if(action.matches("Kick")){
                    System.out.println("Kicked");
                    Object o = playerModel.getSelectedItem();
                    int i = playerModel.getIndexOf(o);
                    if(i > -1){
                        server.kickPlayer(i);
                        playerModel.removeElement(o);
                    }
                }
            }
    }
}
