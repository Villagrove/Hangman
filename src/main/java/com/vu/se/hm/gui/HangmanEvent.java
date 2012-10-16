/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vu.se.hm.gui;

import java.util.EventObject;

/**
 *
 * @author Dan
 */
public class HangmanEvent extends EventObject{
    
    public enum EventType {GAMESTART, UPDATE, GAMEEND};
    
    EventType type;
    char letter;
    
    public HangmanEvent(Object source, EventType type, char letter){
        super(source);
        this.type = type;
        this.letter = letter;
    }
}
