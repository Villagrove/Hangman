package com.vu.se.hm.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * Hangman View Controller Action Listener for Letters Panel
 * 
 * @author Dan Cannon
 */
public class HangmanActionListener implements ActionListener {


	public void letterGuessed(char letter) {
		// Send letter to model to see if correct
		// If correct send updated word to GuessPanel(Spaces for unguessed letters)
		// If incorrect increase the number of wrong guess and send to Graphics panel
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().getClass() == JButton.class) {
			JButton temp = (JButton) e.getSource();
			String letter = temp.getText();
			if (letter != null) {
				temp.setEnabled(false);
				letterGuessed(letter.charAt(0));
			}
		}
	}
}
