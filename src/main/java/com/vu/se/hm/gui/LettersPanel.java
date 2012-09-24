
package com.vu.se.hm.gui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author capnhowdy21
 */
public class LettersPanel extends JPanel{
    JButton[] buttons;
    
    /**
     * LettersPanel Constructor
     * Takes an ActionListener as Event Handler
     * Creates 26 Buttons for each letter then adds them to display.
     * @param controller Action listener to handled events, usually View Controller;
     */
    public LettersPanel(ActionListener controller){
        buttons = new JButton[26];
        for(int i = 0; i < 26; i++){
            buttons[i] = new JButton(Character.toString((char)(i+65)));
            buttons[i].addActionListener(controller);
        }
        initComponents();
    }
    
    /**
     * Sets layout, adds buttons;
     */
    public void initComponents(){
        GridLayout layout = new GridLayout(2,13);
        this.setLayout(layout);
        for(int i = 0; i < 26; i++){
            this.add(buttons[i]);
        }
    }
    
    /**
     *
     * @return Preferred Size for panel
     */
    @Override
    public Dimension getPreferredSize(){
        return new Dimension(640,100);
    }
}
