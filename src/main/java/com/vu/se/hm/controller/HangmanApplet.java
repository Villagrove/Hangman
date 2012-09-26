package com.vu.se.hm.controller;

import javax.swing.JApplet;

/**
 * Hangman View Controller Action Listener for Letters Panel
 * 
 * @author Dan Cannon
 */
public class HangmanApplet extends JApplet {

	public void init() {
		try {
			javax.swing.SwingUtilities.invokeAndWait(new Runnable() {
				public void run() {
					createGUI();
				}
			});
		} catch (Exception e) {
			System.err.println("createGUI didn't successfully complete");
		}
	}

	private void createGUI() {
		getContentPane().add(new ParentPanel());
	}

}
