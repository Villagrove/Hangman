package com.vu.se.hm.gui;

import java.util.EventObject;

/**
 * HangmanEvent. Called by GuesserClient/Server when packets have been received.
 * Tells the interface to update its data.
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
