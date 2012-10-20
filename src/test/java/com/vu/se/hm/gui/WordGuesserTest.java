package com.vu.se.hm.gui;

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
		// TODO Create a mock object of the classes needed
	}

	@After
	public void tearDown() {
		// TODO Set all references to null
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

}
