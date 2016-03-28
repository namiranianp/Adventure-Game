package View;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import Controller.Game_Controller;

public class Game_View {
	Game_Controller control;
	JFrame window;
	GamePanel gameBoard;

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

	public void addKeyAdapter(CustomKeyListener listen) {
		window.addKeyListener(listen);
	}
}
