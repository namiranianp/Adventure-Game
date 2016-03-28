package View;

import Controller.Game_Controller;

import javax.swing.*;

public class Game_View {

	public Game_Controller control;
	public GamePanel gameBoard;


	public Game_View(Game_Controller c) {
		control = c;
		
		JFrame window = new JFrame();
		window.setBounds(100, 20, 655, 700);
		
		gameBoard = new GamePanel(control);

		// LAST
		window.getContentPane().add(gameBoard);
		window.setVisible(true);
        window.setResizable(false);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
}
