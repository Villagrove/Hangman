package com.vu.se.hm.gui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class HangmanStarter {

	public static void main(String[] sd) {
                /*
		JFrame frame = new JFrame("TMNT Hangman");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new HangmanWelcomeScreen());
                frame.setSize(800,600);
                frame.setVisible(true);
                */
            
                (new Thread(new GuesserServer(new WordGuesser("Test")))).start();
                GuesserClient client = new GuesserClient();               
                client.connect("127.0.0.1", 1234);
                (new Thread(client)).start();
		HangmanViewController hangmanViewController = new HangmanViewController(client, false);
                client.addEventListener(hangmanViewController);
	}

}
