package com.vu.se.hm.service.impl;

import org.apache.log4j.Logger;

import com.vu.se.hm.service.WordGuesser;


public class WordGuesserClient {
	private static Logger logger = Logger.getLogger(WordGuesserClient.class);

	private static void log(WordGuesser wordGuesser) {
		logger.debug("Disguised word:" + wordGuesser.getDisguisedWord() + ", Letters guessed:" + wordGuesser.getLettersGuessed() + ", isFound:" + wordGuesser.isFound() + ", isGameOver:" + wordGuesser.isGameOver()
				+ ", isWrongGuess:" + wordGuesser.isWrongGuess());
	}

	public static void main(String[] args) {

		WordGuesser wordGuesser = new WordGuesserImpl("pollan");
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
