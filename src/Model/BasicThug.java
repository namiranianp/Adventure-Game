package Model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class BasicThug extends HostileCreature {

	private int xPos = 4;
	private int yPos = 5;
	Timer t = null;

	public BasicThug(String imageName, int hp, int atk, Game_Model model, int x, int y) {
		super(imageName, hp, atk, model);
		xPos = x;
		yPos = y;
	}

	public void begin() {
		 t = new Timer(1000, d -> {
			moveCreature();
		});
		t.start();
	}

	private void moveCreature() {
		// updates creature's position
		move();
		// draws creature
		model.gameBoard[this.getxPos()][ this.getyPos()].setCreature(this);
		model.refreshScreen();
	}

	// unique way this creature moves
	private void move() {
		// all possible horizontal and vertical options
		int[] horizontal = { 1, -1, 1, 1, -1, -1, 0, 0 };
		int[] vertical =   { 0, 0, 1, -1, 1, -1, 1, -1 };
		ArrayList<Integer> possible = new ArrayList<Integer>();

		// check to see if each is in bounds and if the terrain is walkable
		for (int i = 0; i < horizontal.length; i++) {
			int x = xPos + horizontal[i];
			int y = yPos + vertical[i];
			if (inBounds(x, y)) {
				possible.add(i);
			}
		}

		// randomly pick where to move
		Random rand = new Random();
		int move = rand.nextInt(possible.size());
		model.gameBoard[xPos][yPos].clearCreature();
		xPos += horizontal[move];
		yPos += vertical[move];
		possible.clear();

	}

	// helper method
	private boolean inBounds(int x, int y) {

		if ((x >= 0 && x < 10) && (y >= 0 && y < 10)){
			if(model.gameBoard[x][y].canWalk()){
				return true;
			}
		}
		return false;
	}
}
