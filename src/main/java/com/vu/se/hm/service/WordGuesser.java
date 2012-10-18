/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vu.se.hm.service;

import java.util.Set;

/**
 *
 * @author Dan
 */
public interface WordGuesser {
    public String guess(char letter);
    public String getDisguisedWord();
    public int getMissCount();
    public Set<Character> getLettersGuessed();
}
