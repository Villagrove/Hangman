package com.vu.se.hm.gui;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
import javax.swing.*;
public class HangmanWelcomeScreen extends JPanel {

JPanel panel;
JLabel welcome, credits;
JButton onePlayerButton, twoPlayerButton;
String currentWord;
Box titleBox,imageBox,creditBox,buttonBox;

	public HangmanWelcomeScreen(){
		
		ButtonListener action = new ButtonListener();
		
		welcome = new JLabel("Welcome to Hangman!");
		welcome.setFont(new Font("Courier New", Font.CENTER_BASELINE, 20));
		
		onePlayerButton = new JButton("Start a 1-player game");
		twoPlayerButton = new JButton("Start a 2-player game");
		
		onePlayerButton.addActionListener(action);
		twoPlayerButton.addActionListener(action);
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		titleBox = new Box(BoxLayout.X_AXIS);
		imageBox = new Box(BoxLayout.X_AXIS);
		creditBox = new Box(BoxLayout.X_AXIS);
		buttonBox = new Box(BoxLayout.X_AXIS);
		
		
		titleBox.add(welcome);
		
		buttonBox.add(onePlayerButton);
		buttonBox.add(Box.createRigidArea(new Dimension(100,0)));
		buttonBox.add(twoPlayerButton);

		try{
			BufferedImage myPicture = ImageIO.read(new File("C:\\hangman\\teenage-fun.jpg"));
			JLabel picLabel = new JLabel(new ImageIcon( myPicture ));
			imageBox.add(picLabel);
			
			myPicture = ImageIO.read(new File("C:\\hangman\\hangman.png"));
			picLabel = new JLabel(new ImageIcon( myPicture ));
			imageBox.add(picLabel);
			
		}
		catch (IOException e){
			JOptionPane.showMessageDialog(null, "Image file not found");
		}
		
		credits = new JLabel("Created by Team Teenage Mutant Ninja Turtles: Dan, Mike, Pal, and Mounika");
		creditBox.add(credits);
		this.add(titleBox);
		this.add(Box.createRigidArea(new Dimension(0,25)));
		this.add(imageBox);
		this.add(Box.createRigidArea(new Dimension(0,15)));
		this.add(creditBox);
		this.add(Box.createRigidArea(new Dimension(0,50)));
		this.add(buttonBox);
	}
	
	public class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getActionCommand().equals("Start a 1-player game")){
				JOptionPane.showMessageDialog(null, "Sorry, this game mode is not currently supported", "Error",
						JOptionPane.PLAIN_MESSAGE);
			}
			
			if(e.getActionCommand().equals("Start a 2-player game")){
				currentWord = JOptionPane.showInputDialog(null, "Please enter the word to be guessed:", "Word Entry",
						JOptionPane.PLAIN_MESSAGE);
			}
		}
	}

}
