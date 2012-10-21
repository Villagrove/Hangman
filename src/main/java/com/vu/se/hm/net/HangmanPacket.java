/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vu.se.hm.net;

import java.io.Serializable;
/**
 *
 * @author Dan
 */
public class HangmanPacket implements Serializable{
    char letter;
    int missCount;
    String disguisedWord;
}
