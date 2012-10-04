package com.vu.se.hm.gui;

import javax.swing.JOptionPane;

public class HangmanStarter {

	public static void main(String[] sd) {
		String currentWord = "test";
              /*  HangmanWelcomeScreen starter = new HangmanWelcomeScreen();
                starter.setSize(800,600);
                starter.setVisible(true);0*/
                currentWord = JOptionPane.showInputDialog(null, "Please enter the word to be guessed:", "Word Entry",
						JOptionPane.PLAIN_MESSAGE);
		HangmanViewController hangmanViewController = new HangmanViewController(currentWord);
	}

}
