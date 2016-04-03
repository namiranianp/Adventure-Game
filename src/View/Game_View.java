package View;

import Controller.CustomKeyAdapter;
import Controller.Game_Controller;

import javax.swing.*;

public class Game_View {
	Game_Controller control;
	public JFrame window;
	public GamePanel gameBoard;
    boolean flashlight;


	public Game_View(Game_Controller c) {
		control = c;

		window = new JFrame();
		window.setBounds(100, 20, 655, 700);

		gameBoard = new GamePanel(control,this);

		//HTML Pages
		JMenuBar menu = new JMenuBar();
		window.setJMenuBar(menu);
		JMenu about = new JMenu("About");
		JMenuItem howToPlay = new JMenuItem("How to play");

		// LAST
		window.getContentPane().add(gameBoard);
		window.setVisible(true);
		window.setResizable(false);
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	public void addKeyAdapter(CustomKeyAdapter listen) {

		window.addKeyListener(listen);
	}

	//Turns on the flashlight or off
	public void setFlashLight(boolean flashlightState){

        flashlight = flashlightState;

    }

}
