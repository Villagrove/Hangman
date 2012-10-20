package com.vu.se.hm.gui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class HangmanStarter {

	public static void main(String[] sd) {
		JFrame frame = new JFrame("TMNT Hangman");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new WelcomeScreen());
                frame.setSize(800,600);
                frame.setVisible(true);
                /*  
                WelcomeScreen starter = new WelcomeScreen();
                starter.setSize(800,600);
                starter.setVisible(true);*/
                /*
                currentWord = JOptionPane.showInputDialog(null, "Please enter the word to be guessed:", "Word Entry",
						JOptionPane.PLAIN_MESSAGE);
		HangmanViewController hangmanViewController = new HangmanViewController(currentWord);
                */
	}

}
