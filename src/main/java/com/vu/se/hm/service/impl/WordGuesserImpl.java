package com.vu.se.hm.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;

import com.vu.se.hm.service.WordGuesser;
import com.vu.se.hm.util.WordValidator;

public class WordGuesserImpl implements WordGuesser {
	private Logger logger = Logger.getLogger(WordGuesserImpl.class);

	private String secretWord;
	private String disguisedWord = "";
	private int guessCount = 0, missCount = 0;
	private boolean gameOver;
	private boolean wrongGuess;
	public final int NUMBER_OF_ATTEMPTS = 6;
	Set<Character> lettersGuessed = new HashSet<Character>();
	private WordValidator wordValidator;

	/**
	 * Creates an instance of Word to be used throughout the game
	 * 
	 * @param newWord
	 *            The word to be guessed
	 */
	public WordGuesserImpl(String newWord) {
		setSecretWord(newWord.toUpperCase());
		wordValidator = new WordValidator();
	}

	private void setSecretWord(String newWord) {
		secretWord = newWord;
		guessCount = 0;
		missCount = 0;

		int wordLength = newWord.length();

		while (wordLength > 0) {
			disguisedWord = disguisedWord + " ";
			wordLength--;
		}

	}

	/* (non-Javadoc)
	 * @see com.vu.se.hm.service.impl.WordGuesser#getSecretWord()
	 */
	@Override
	public String getSecretWord() {
		return secretWord;
	}

	/* (non-Javadoc)
	 * @see com.vu.se.hm.service.impl.WordGuesser#isFound()
	 */
	@Override
	public boolean isFound() {
		return secretWord.equalsIgnoreCase(disguisedWord);
	}

	/* (non-Javadoc)
	 * @see com.vu.se.hm.service.impl.WordGuesser#getDisguisedWord()
	 */
	@Override
	public String getDisguisedWord() {
		return disguisedWord;
	}

	/* (non-Javadoc)
	 * @see com.vu.se.hm.service.impl.WordGuesser#getGuessCount()
	 */
	@Override
	public int getGuessCount() {
		return guessCount;
	}

	/* (non-Javadoc)
	 * @see com.vu.se.hm.service.impl.WordGuesser#getMissCount()
	 */
	@Override
	public int getMissCount() {
		return missCount;
	}

	/* (non-Javadoc)
	 * @see com.vu.se.hm.service.impl.WordGuesser#isGameOver()
	 */
	@Override
	public boolean isGameOver() {
		return gameOver;
	}

	private void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}

	/* (non-Javadoc)
	 * @see com.vu.se.hm.service.impl.WordGuesser#isWrongGuess()
	 */
	@Override
	public boolean isWrongGuess() {
		return wrongGuess;
	}

	private void setWrongGuess(boolean wrongGuess) {
		this.wrongGuess = wrongGuess;
	}

	/* (non-Javadoc)
	 * @see com.vu.se.hm.service.impl.WordGuesser#getLettersGuessed()
	 */
	@Override
	public Set<Character> getLettersGuessed() {
		return lettersGuessed;
	}

	/**
	 * matches the supplied character with secret word
	 * 
	 * @param character
	 */
	private void matchCharacter(char c) {
		// int position = secretWord.indexOf(c);
		boolean gotIt = false;
		String updateDisguised = "";

		for (int i = 0; i < secretWord.length(); i++) {

			if (c == secretWord.charAt(i)) {

				updateDisguised = updateDisguised + secretWord.charAt(i);

				String checkDuplicate = updateDisguised.substring(0, i);
				int duplicatePos = checkDuplicate.indexOf(c);
				if (duplicatePos < 0)
					guessCount++;
				gotIt = true;
				setWrongGuess(false);
			} else {
				updateDisguised = updateDisguised + disguisedWord.charAt(i);
			}

		}
		if (gotIt == false) {
			missCount++;
			guessCount++;
			setWrongGuess(true);
		}

		disguisedWord = updateDisguised;

	}

	/* (non-Javadoc)
	 * @see com.vu.se.hm.service.impl.WordGuesser#guess(char)
	 */
	@Override
	public String guess(char guess) {
		// logger.debug("DisguisedWord before guess: " + this.getDisguisedWord());
		guess = Character.toUpperCase(guess);
		if (this.isGameOver()) {
			logger.debug("The game is already over. no more guesses allowed.");
			return getDisguisedWord();
		}

		if (lettersGuessed.contains(guess)) {
			logger.warn("The letter was already guessed:" + guess);
			return getDisguisedWord();
		}

		// match the character to the letter in secret word
		this.matchCharacter(guess);

		// update already guessed list of letters
		lettersGuessed.add(guess);

		logger.debug("Number of guesses so far: " + this.getGuessCount() + ", Number of misses so far: " + this.getMissCount());

		if (this.getMissCount() == NUMBER_OF_ATTEMPTS) {
			logger.debug("The game is over. Player lost the game.");
			setGameOver(true);
		}

		if (this.isFound()) {
			logger.debug("The game is over. Player Won the game.");
			setGameOver(true);
		}

		logger.debug("DisguisedWord after guess: " + this.getDisguisedWord());
		return getDisguisedWord();

	}

}