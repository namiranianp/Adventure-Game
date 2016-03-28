//600x600 JPanel

package View;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import Controller.Game_Controller;

import javax.swing.*;
import java.awt.*;

public class Game_View {
	public static void main(String[] args) {
		Game_View go = new Game_View();
	}

	public Game_View() {
		JFrame window = new JFrame();
		window.setBounds(100, 20, 655, 700);
		
		GamePanel gameBoard = new GamePanel();

		// LAST
		window.getContentPane().add(gameBoard);
		window.setVisible(true);
	}
}
