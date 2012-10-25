
package com.vu.se.hm.net;

import java.io.Serializable;

/**
 * HangmanPacket. helper class for sending data over the network.
 */
public class HangmanPacket implements Serializable{
    char letter;
    int missCount;
    String disguisedWord;
}
