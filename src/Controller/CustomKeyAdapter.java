package Controller;

import Model.Game_Model;
import View.Game_View;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Write a description of class PersonalActionListener here.
 *
 * @author Vybhav Achar Bhargav
 * @version 3/27/2016
 */

public class CustomKeyAdapter extends KeyAdapter {

	Game_View view;
	Game_Model model;

	CustomKeyAdapter(Game_Model m, Game_View v) {
		view = v;
		model = m;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		super.keyTyped(e);
		view.window.requestFocus();
		// Grab the x and y position of the player
		int x = model.getPosX();
		int y = model.getPosY();

		// change x and y pos
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			model.move(x, y - 1);
			view.window.repaint();
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			model.move(x, y + 1);
			view.window.repaint();
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			model.move(x - 1, y);
			view.window.repaint();
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			model.move(x + 1, y);
			view.window.repaint();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		super.keyTyped(e);
		view.window.requestFocus();
		// Grab the x and y position of the player
		int x = model.getPosX();
		int y = model.getPosY();

		// change x and y pos
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			model.move(x, y - 1);
			view.window.repaint();
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			model.move(x, y + 1);
			view.window.repaint();
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			model.move(x - 1, y);
			view.window.repaint();
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			model.move(x + 1, y);
			view.window.repaint();
		}
	}

}