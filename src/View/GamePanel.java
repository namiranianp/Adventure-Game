package View;

import Controller.Game_Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel {
	Game_Controller control;
	Game_View view;
	final int LINE = 60;
	final int NUMSQUARES = 10;
	int[][] flash;

	// SO IT CAN ASK CONTROLLER FOR IMAGES
	GamePanel(Game_Controller c, Game_View v) {
		control = c;
		view = v;
	}

	public void paintComponent(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(20, 40, 600, 600);
		g.setColor(Color.BLACK);

		// ASK FOR, AND DRAW IMAGES, SQUARE BY SQUARE
		for (int i = 0; i < NUMSQUARES; i++) {
			for (int j = 0; j < NUMSQUARES; j++) {
				BufferedImage pic = control.getImage(j, i);
				g.drawImage(pic, 20 + (i * LINE), 40 + (j * LINE), LINE, LINE, null);
			}
		}

	}
}
