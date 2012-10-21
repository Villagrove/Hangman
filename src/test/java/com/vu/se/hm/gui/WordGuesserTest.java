package com.vu.se.hm.gui;

import java.util.Set;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.vu.se.hm.service.WordGuesser;
import com.vu.se.hm.service.impl.WordGuesserImpl;

@RunWith(MockitoJUnitRunner.class)
public class WordGuesserTest {

	private WordGuesser wordGuesser;

	@Before
	public void setUp() {
		wordGuesser = new WordGuesserImpl("terrific");
	}

	@After
	public void tearDown() {
		wordGuesser = null;
	}

	@Test
	public void isFound() {
		wordGuesser.guess('t');
		wordGuesser.guess('e');
		wordGuesser.guess('r');
		wordGuesser.guess('i');
		wordGuesser.guess('f');
		wordGuesser.guess('c');
		boolean returnValue = wordGuesser.isFound();
		Assert.assertTrue(returnValue);
	}

	@Test
	public void isFound_notFound() {
		wordGuesser.guess('t');
		wordGuesser.guess('e');
		wordGuesser.guess('r');
		wordGuesser.guess('i');
		wordGuesser.guess('f');

		boolean returnValue = wordGuesser.isFound();
		Assert.assertFalse(returnValue);
	}

	@Test
	public void isGameOver() {
		wordGuesser.guess('t');
		wordGuesser.guess('e');
		wordGuesser.guess('r');
		wordGuesser.guess('i');
		wordGuesser.guess('f');
		wordGuesser.guess('c');
		Assert.assertTrue(wordGuesser.isGameOver());
	}

	@Test
	public void isGameOver_no() {
		wordGuesser.guess('t');
		wordGuesser.guess('e');
		wordGuesser.guess('i');
		wordGuesser.guess('f');
		wordGuesser.guess('c');
		Assert.assertFalse(wordGuesser.isGameOver());
	}

	@Test
	public void isWrongGuess() {
		wordGuesser.guess('p');
		Assert.assertTrue(wordGuesser.isWrongGuess());
	}

	@Test
	public void isWrongGuess_no() {
		wordGuesser.guess('r');
		Assert.assertFalse(wordGuesser.isWrongGuess());
	}

	@Test
	public void getLettersGuessed() {
		wordGuesser.guess('f');
		Set<Character> lettersGuessed = wordGuesser.getLettersGuessed();
		Assert.assertEquals(1, lettersGuessed.size());
	}

	@Test
	public void getLettersGuessed_zero() {
		Set<Character> lettersGuessed = wordGuesser.getLettersGuessed();
		Assert.assertEquals(0, lettersGuessed.size());
	}

	@Test
	public void getSecretWord() {
		Assert.assertEquals("TERRIFIC", wordGuesser.getSecretWord());
	}

	@Test
	public void getDisguisedWord() {
		wordGuesser.guess('f');
		Assert.assertEquals("     F  ", wordGuesser.getDisguisedWord());

		wordGuesser.guess('r');
		Assert.assertEquals("  RR F  ", wordGuesser.getDisguisedWord());
	}

	@Test
	public void getDisguisedWord_noword() {
		Assert.assertEquals("        ", wordGuesser.getDisguisedWord());
	}

	@Test
	public void getGuessCount() {
		wordGuesser.guess('f');
		Assert.assertEquals(1, wordGuesser.getGuessCount());

		wordGuesser.guess('r');
		Assert.assertEquals(2, wordGuesser.getGuessCount());
	}

	@Test
	public void getGuessCount_zero() {
		Assert.assertEquals(0, wordGuesser.getGuessCount());
	}

	@Test
	public void getMissCount_zero() {
		Assert.assertEquals(0, wordGuesser.getMissCount());
	}
	
	@Test
	public void getMissCount() {
		wordGuesser.guess('f');
		Assert.assertEquals(0, wordGuesser.getMissCount());

		wordGuesser.guess('p');
		Assert.assertEquals(1, wordGuesser.getMissCount());
		wordGuesser.guess('q');
		Assert.assertEquals(2, wordGuesser.getMissCount());
	}

}
