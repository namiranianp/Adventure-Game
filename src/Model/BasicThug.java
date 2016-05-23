package Model;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.Timer;

public class BasicThug extends HostileCreature {

	private Game_Model model;
	private Timer t = new Timer(1000, d -> {
		movement();
	});;

	public BasicThug(String imageName, int hp, int atk, Game_Model m, int x, int y) {
		super(imageName, hp, atk, m, x, y);
		model = m;
		super.t = new Timer(500, d -> {
			movement();
			damagePlayer();
		});

	}

	// unique way this creature moves
	private void movement() {
		// first value is horizontal, second is vertical
		int[][] directions = { { -1, -1 }, { 0, -1 }, { 1, -1 }, { 1, 0 }, { 1, 1 }, { 0, 1 }, { -1, 1 }, { -1, 0 } };
		ArrayList<Integer> possibilities = new ArrayList<Integer>();
		int x;
		int y;
		int currentX = getXPos();
		int currentY = getYPos();
		Random rand = new Random();

		for (int i = 0; i < directions.length; i++) {
			x = currentX + directions[i][0];
			y = currentY + directions[i][1];

			if (isInBounds(x, y) && model.gameBoard[x][y].canWalk()) {
				possibilities.add(i);
			}
		}

		int pos = rand.nextInt(possibilities.size());
		model.gameBoard[currentX][currentY].clearCreature();
		setXPos(currentX + directions[possibilities.get(pos)][0]);
		setYPos(currentY + directions[possibilities.get(pos)][1]);
		model.gameBoard[getXPos()][getYPos()].setCreature(this);
		model.cont.refreshScreen();
		//damagePlayer();
	}

	private void damagePlayer() {
		// first value is horizontal, second is vertical
		int[][] directions = { { -1, -1 }, { 0, -1 }, { 1, -1 }, { 1, 0 }, { 1, 1 }, { 0, 1 }, { -1, 1 }, { -1, 0 } };
		int x;
		int y;
		int currentX = getXPos();
		int currentY = getYPos();

		for (int i = 0; i < directions.length; i++) {
			x = currentX + directions[i][0];
			y = currentY + directions[i][1];

			if (isInBounds(x, y) && model.gameBoard[x][y].player) {
				model.guy.changeHealth(0 - getAttack());
			}
		}
	}

	// helper method
	private boolean isInBounds(int x, int y) {
		// if the position is in bounds continue, otherwise return false
		if ((x >= 0 && x < model.BOARDSIZE) && (y >= 0 && y < model.BOARDSIZE)) {
			return true;
		}
		return false;

	}
}
