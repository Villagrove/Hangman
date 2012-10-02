package com.vu.se.hm.gui;

public class HangmanStarter {

	public static void main(String[] sd) {
		String word = "test";
              /*  HangmanWelcomeScreen starter = new HangmanWelcomeScreen();
                starter.setSize(800,600);
                starter.setVisible(true);0*/
                
		HangmanViewController hangmanViewController = new HangmanViewController(word);
	}

}
