package com.vu.se.hm.service;

import java.util.Set;

public interface WordGuesser {

	/**
	 * @return the word to be guessed
	 */
	public String getSecretWord();

	/**
	 * @return true if the word is successfully guessed and false otherwise
	 */
	public boolean isFound();

	/**
	 * @return the word with guessed characters filled in and not guessed characters filled in with white spaces
	 */
	public String getDisguisedWord();

	public int getGuessCount();

	/**
	 * @return number of missed counts
	 */
	public int getMissCount();

	/**
	 * indicates the game is over
	 * 
	 * @return true means game is over and false for continue to play
	 */
	public boolean isGameOver();

	/**
	 * check to see if this guess was wrong
	 * 
	 * @return true for
	 */
	public boolean isWrongGuess();

	/**
	 * already guessed list of letters
	 * 
	 * @return set of already guessed list of chars
	 */
	public Set<Character> getLettersGuessed();

	/**
	 * this is the function to be called by client
	 * 
	 * @param guess
	 * @return the word with guessed characters filled in and not guessed characters filled in with white spaces
	 */
	public String guess(char guess);

}
