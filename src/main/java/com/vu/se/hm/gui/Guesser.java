/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vu.se.hm.gui;

import java.util.Set;

/**
 *
 * @author Dan
 */
public interface Guesser {
    public String guess(char letter);
    public String getDisguisedWord();
    public int getMissCount();
    public Set<Character> getLettersGuessed();
}
