
package com.vu.se.hm.net;

import java.io.Serializable;

/**
 * HangmanPacket. helper class for sending data over the network.
 */
public class HangmanPacket implements Serializable{
    
    public enum PacketType {CONNECT, GUESS, WIN, LOSE, KICKED};
    
    PacketType type;
    char letter;
    int missCount;
    String disguisedWord;
    
    public HangmanPacket(PacketType type){
        this.type = type;
        letter = 'a';
        missCount = 0;
        disguisedWord = "";
    }
}
