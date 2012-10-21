package com.vu.se.hm.util;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class WordValidatorTest {
	private WordValidator wordValidator;

	@Before
	public void setUp() {
		wordValidator = new WordValidator();
	}

	@Test
	public void isValidChar() {
		Assert.assertTrue(wordValidator.isValidChar('a'));
		Assert.assertTrue(wordValidator.isValidChar('b'));
		Assert.assertTrue(wordValidator.isValidChar('c'));
		Assert.assertTrue(wordValidator.isValidChar('d'));
		Assert.assertTrue(wordValidator.isValidChar('e'));
		Assert.assertTrue(wordValidator.isValidChar('f'));
		Assert.assertTrue(wordValidator.isValidChar('g'));
		Assert.assertTrue(wordValidator.isValidChar('h'));
		Assert.assertTrue(wordValidator.isValidChar('i'));
		Assert.assertTrue(wordValidator.isValidChar('j'));
		Assert.assertTrue(wordValidator.isValidChar('k'));
		Assert.assertTrue(wordValidator.isValidChar('l'));
		Assert.assertTrue(wordValidator.isValidChar('m'));
		Assert.assertTrue(wordValidator.isValidChar('n'));
		Assert.assertTrue(wordValidator.isValidChar('o'));
		Assert.assertTrue(wordValidator.isValidChar('p'));
		Assert.assertTrue(wordValidator.isValidChar('q'));
		Assert.assertTrue(wordValidator.isValidChar('r'));
		Assert.assertTrue(wordValidator.isValidChar('s'));
		Assert.assertTrue(wordValidator.isValidChar('t'));
		Assert.assertTrue(wordValidator.isValidChar('u'));
		Assert.assertTrue(wordValidator.isValidChar('v'));
		Assert.assertTrue(wordValidator.isValidChar('w'));
		Assert.assertTrue(wordValidator.isValidChar('x'));
		Assert.assertTrue(wordValidator.isValidChar('y'));
		Assert.assertTrue(wordValidator.isValidChar('z'));
		Assert.assertTrue(wordValidator.isValidChar('A'));
		Assert.assertTrue(wordValidator.isValidChar('B'));
		Assert.assertTrue(wordValidator.isValidChar('C'));
		Assert.assertTrue(wordValidator.isValidChar('D'));
		Assert.assertTrue(wordValidator.isValidChar('E'));
		Assert.assertTrue(wordValidator.isValidChar('F'));
		Assert.assertTrue(wordValidator.isValidChar('G'));
		Assert.assertTrue(wordValidator.isValidChar('H'));
		Assert.assertTrue(wordValidator.isValidChar('I'));
		Assert.assertTrue(wordValidator.isValidChar('J'));
		Assert.assertTrue(wordValidator.isValidChar('K'));
		Assert.assertTrue(wordValidator.isValidChar('L'));
		Assert.assertTrue(wordValidator.isValidChar('M'));
		Assert.assertTrue(wordValidator.isValidChar('N'));
		Assert.assertTrue(wordValidator.isValidChar('O'));
		Assert.assertTrue(wordValidator.isValidChar('P'));
		Assert.assertTrue(wordValidator.isValidChar('Q'));
		Assert.assertTrue(wordValidator.isValidChar('R'));
		Assert.assertTrue(wordValidator.isValidChar('S'));
		Assert.assertTrue(wordValidator.isValidChar('T'));
		Assert.assertTrue(wordValidator.isValidChar('U'));
		Assert.assertTrue(wordValidator.isValidChar('V'));
		Assert.assertTrue(wordValidator.isValidChar('W'));
		Assert.assertTrue(wordValidator.isValidChar('X'));
		Assert.assertTrue(wordValidator.isValidChar('Y'));
		Assert.assertTrue(wordValidator.isValidChar('Z'));
		
		Assert.assertFalse(wordValidator.isValidChar(' '));
		Assert.assertFalse(wordValidator.isValidChar('1'));
		Assert.assertFalse(wordValidator.isValidChar('2'));
		Assert.assertFalse(wordValidator.isValidChar('3'));
		Assert.assertFalse(wordValidator.isValidChar('4'));
		Assert.assertFalse(wordValidator.isValidChar('5'));
		Assert.assertFalse(wordValidator.isValidChar('6'));
		Assert.assertFalse(wordValidator.isValidChar('7'));
		Assert.assertFalse(wordValidator.isValidChar('8'));
		Assert.assertFalse(wordValidator.isValidChar('9'));
		Assert.assertFalse(wordValidator.isValidChar('0'));
		Assert.assertFalse(wordValidator.isValidChar('~'));
		Assert.assertFalse(wordValidator.isValidChar('?'));
		Assert.assertFalse(wordValidator.isValidChar('`'));
		Assert.assertFalse(wordValidator.isValidChar('!'));
		Assert.assertFalse(wordValidator.isValidChar('@'));
		Assert.assertFalse(wordValidator.isValidChar('#'));
		Assert.assertFalse(wordValidator.isValidChar('$'));
		Assert.assertFalse(wordValidator.isValidChar('%'));
		Assert.assertFalse(wordValidator.isValidChar('^'));
		Assert.assertFalse(wordValidator.isValidChar('&'));
		Assert.assertFalse(wordValidator.isValidChar('*'));
		Assert.assertFalse(wordValidator.isValidChar('('));
		Assert.assertFalse(wordValidator.isValidChar(')'));
		
	}

	@Test
	public void isValidString() {
		Assert.assertTrue(wordValidator.isValidString("theworldisnotenough"));
		Assert.assertTrue(wordValidator.isValidString("testable"));
		Assert.assertTrue(wordValidator.isValidString("A"));
		
		Assert.assertFalse(wordValidator.isValidString("the world is not enough"));
		Assert.assertFalse(wordValidator.isValidString("1"));
		Assert.assertFalse(wordValidator.isValidString("*"));
		Assert.assertFalse(wordValidator.isValidString(null));
		Assert.assertFalse(wordValidator.isValidString(""));
		Assert.assertFalse(wordValidator.isValidString("testable#notvalid"));
	}

}
