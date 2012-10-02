package com.vu.se.hm.gui;

import org.apache.log4j.Logger;

public class WordGuesserClient {
	private static Logger logger = Logger.getLogger(WordGuesserClient.class);

	private static void log(WordGuesser wordGuesser) {
		logger.debug("Disguised word:" + wordGuesser.getDisguisedWord() + ", isFound:" + wordGuesser.isFound() + ", isGameOver:" + wordGuesser.isGameOver()
				+ ", isWrongGuess:" + wordGuesser.isWrongGuess());
	}

	public static void main(String[] args) {

		WordGuesser wordGuesser = new WordGuesser("pollan");
		String disguised = wordGuesser.guess('n');
		log(wordGuesser);

		disguised = wordGuesser.guess('o');
		log(wordGuesser);
		
		disguised = wordGuesser.guess('k');
		disguised = wordGuesser.guess('q');
		disguised = wordGuesser.guess('r');
		log(wordGuesser);
		
		disguised = wordGuesser.guess('l');
		log(wordGuesser);
		
		disguised = wordGuesser.guess('u');
		log(wordGuesser);
		
		//un comment below line to see a lose condition
//		disguised = wordGuesser.guess('s');
		disguised = wordGuesser.guess('t');
		disguised = wordGuesser.guess('a');
		log(wordGuesser);
		
		disguised = wordGuesser.guess('p');
		log(wordGuesser);

	}
}
