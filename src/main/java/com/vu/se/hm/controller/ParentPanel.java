package com.vu.se.hm.controller;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.vu.se.hm.gui.GraphicsPanel;
import com.vu.se.hm.gui.GuessPanel;
import com.vu.se.hm.gui.LettersPanel;

/**
 * Hangman View Controller Action Listener for Letters Panel
 * 
 * @author Dan Cannon
 */
public class ParentPanel extends JPanel {

	public ParentPanel() {
		initComponents();
	}
	
	public void initComponents(){
	//	JFrame this = new JFrame("TMNT Hangman");
	//	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setMinimumSize(new Dimension(640, 440));
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		c.gridx = 1;
		c.gridy = 0;
		this.add(new GraphicsPanel(), c);

		c.gridx = 1;
		c.gridy = 1;
		String word = "test";
		this.add(new GuessPanel(word), c);

		c.gridx = 1;
		c.gridy = 2;
		this.add(new LettersPanel(new HangmanActionListener()), c);

		//this.pack();
		this.setVisible(true);
	}

	/**
	 * 
	 * @return Preferred Size for panel
	 */
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(640, 440);
	}

}
