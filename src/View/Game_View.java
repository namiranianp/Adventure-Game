package View;

import Controller.CustomKeyAdapter;
import Controller.Game_Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

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
		JMenu help = new JMenu("Help");

		JMenuItem howToPlay = new JMenuItem("How to play");
		howToPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JEditorPane helpContent;
				try {
					helpContent = new JEditorPane(new URL("file:HTML/how_to_play.html"));
					JScrollPane helpPane = new JScrollPane(helpContent);
					JOptionPane.showMessageDialog(null, helpPane, "How To Play", JOptionPane.PLAIN_MESSAGE, null);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		help.add(howToPlay);

		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					JEditorPane helpContent = new JEditorPane(new URL("file:HTML/about.html"));
					JScrollPane helpPane = new JScrollPane(helpContent);
					JOptionPane.showMessageDialog(null, helpPane, "How To Play", JOptionPane.PLAIN_MESSAGE, null);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		help.add(mntmAbout);

		//Add menu bars
		menu.add(help);
		window.setJMenuBar(menu);


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
