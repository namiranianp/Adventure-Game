package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import Controller.Game_Controller;

public class GamePanel extends JPanel {
	Game_Controller control;
	final int LINE = 60;
	final int NUMSQUARES = 10;

	// SO IT CAN ASK CONTROLLER FOR IMAGES
	GamePanel(Game_Controller c) {
		control = c;
	}

	public void paintComponent(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(20, 40, 600, 600);
		g.setColor(Color.BLACK);

		// ASK FOR, AND DRAW IMAGES, SQUARE BY SQUARE
		for (int i = 0; i < NUMSQUARES; i++) {
			for (int j = 0; j < NUMSQUARES; j++) {
				BufferedImage pic = control.getImage(j,i);
				g.drawImage(pic, 20+(i*LINE), 40+(j*LINE), LINE, LINE, null);
			}
		}
	}
}
