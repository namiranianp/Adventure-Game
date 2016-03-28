package View;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import Controller.Game_Controller;

import javax.swing.*;
import java.awt.*;

public class Game_View {
	Game_Controller control;

	public Game_View(Game_Controller c) {
		control = c;
		
		JFrame window = new JFrame();
		window.setBounds(100, 20, 655, 700);
		
		GamePanel gameBoard = new GamePanel(control);

		// LAST
		window.getContentPane().add(gameBoard);
		window.setVisible(true);
	}
}
