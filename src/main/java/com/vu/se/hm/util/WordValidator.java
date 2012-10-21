package com.vu.se.hm.util;

import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

public class WordValidator {

	private static Logger logger = Logger.getLogger(WordValidator.class);

	public boolean isValidChar(char guess) {
		boolean isValid = false;
		if (guess != ' ') {
			isValid = Pattern.matches("[a-zA-Z]", String.valueOf(guess));
		}
		return isValid;
	}

	public boolean isValidString(String guess) {
		boolean isValid = false;
		if (StringUtils.isNotBlank(guess)) {
			isValid = Pattern.matches("[a-zA-Z]+", guess);
		}
		return isValid;
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
