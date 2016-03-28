package View;

import java.awt.event.KeyAdapter;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import Controller.Game_Controller;

public class Game_View {
	Game_Controller control;
	JFrame window;
	public GamePanel gameBoard;

	public Game_View(Game_Controller c) {
		control = c;

		window = new JFrame();
		window.setBounds(100, 20, 655, 700);

		gameBoard = new GamePanel(control);

		// LAST
		window.getContentPane().add(gameBoard);
		window.setVisible(true);
		window.setResizable(false);
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
<<<<<<< HEAD
	
	public void addKeyAdapter(KeyAdapter listen){
=======

	public void addKeyAdapter(CustomKeyListener listen) {
>>>>>>> Pedram_Changes
		window.addKeyListener(listen);
	}
}
