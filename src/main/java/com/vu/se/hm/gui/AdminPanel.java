
package com.vu.se.hm.gui;

import java.awt.Graphics;
import java.awt.event.ActionListener;
import javax.swing.*;


/**
 * AdminPanel. unfinished. The Bottom panel for the host.
 */
public class AdminPanel extends JPanel{
    private JComboBox players;
    private JButton kick;
    private JTextField letters;

    
    public AdminPanel(ActionListener controller, DefaultComboBoxModel model){
        this.players = new JComboBox(model);
        
        kick = new JButton("Kick");
        kick.addActionListener(controller);

        letters = new JTextField("");
        letters.setColumns(13);
        letters.setEditable(false);
        
        this.add(this.players);
        this.add(kick);
        this.add(letters);
    }
    
    public void setLetters(String letters){
        this.letters.setText(letters);
    }
}
