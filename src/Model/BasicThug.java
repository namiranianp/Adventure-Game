package Model;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.Timer;

public class BasicThug extends HostileCreature {

	private Game_Model model;

	public BasicThug(String imageName, int hp, int atk, Game_Model m, int x, int y) {
		super(imageName, hp, atk, m, x, y);
		model = m;
		begin();
	}

	public void begin() {
		Timer t = new Timer(1000, d -> {
			move();
		});
		t.start();
	}

	// unique way this creature moves
	private void move() {
		// all possible horizontal and vertical options
		int[] horizontal = { 1, -1, 1, 1, -1, -1, 0, 0 };
		int[] vertical = { 0, 0, 1, -1, 1, -1, 1, -1 };
		ArrayList<Integer> possible = new ArrayList<Integer>();
		possible.clear();

		// check to see if each is in bounds and if the terrain is walkable
		for (int i = 0; i < horizontal.length; i++) {
			int x = getXPos() + horizontal[i];
			int y = getXPos() + vertical[i];
			if (inBounds(x, y)) {
				possible.add(i);
			}
		}

		// randomly pick where to move
		Random rand = new Random();
		int move = 0;
		if (possible.size() > 0) {
			move = rand.nextInt(possible.size());
		}
		model.gameBoard[getXPos()][getYPos()].clearCreature();
		setXPos(getXPos() + horizontal[move]);
		setYPos(getYPos() + vertical[move]);
		model.gameBoard[getXPos()][getYPos()].setCreature(this);
	}

	// helper method
	private boolean inBounds(int x, int y) {
		// if the position is in bounds continue, otherwise return false
		if ((x >= 0 && x < 10) && (y >= 0 && y < 10)) {
			// if there is walkable terrain return true, otherwise return false
			if (!(model.gameBoard[y][x].hasTerrain())) {
				return true;
			}
		}
		return false;

	}
}
