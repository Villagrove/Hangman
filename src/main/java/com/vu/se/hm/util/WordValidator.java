package com.vu.se.hm.util;

import java.util.regex.Pattern;

import org.apache.log4j.Logger;

public class WordValidator {

	private static Logger logger = Logger.getLogger(WordValidator.class);

	public boolean isValidChar(char guess) {
		return Pattern.matches("[a-zA-Z]", String.valueOf(guess));
	}

	public boolean isValidString(String guess) {
		return Pattern.matches("[a-zA-Z]+", guess);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WordValidator wordValidator = new WordValidator();
		boolean isValid = wordValidator.isValidChar('V');
		// boolean isValid = wordValidator.isValid('@');
		logger.debug("isValidChar: " + isValid);

		boolean isValidString = wordValidator.isValidString("Villagrove");
		logger.debug("isValidString: " + isValidString);

	}

}
