package View;

<<<<<<< HEAD
import Controller.Game_Controller;

import javax.swing.*;

public class Game_View {

	public Game_Controller control;
	public GamePanel gameBoard;


=======
import java.awt.event.KeyAdapter;

import javax.swing.JFrame;

import Controller.Game_Controller;

public class Game_View {
	Game_Controller control;
	JFrame window;
	GamePanel gameBoard;
	
>>>>>>> origin/master
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
	
	public void addKeyAdapter(CustomKeyListener listen){
		window.addKeyListener(listen);
	}
}
