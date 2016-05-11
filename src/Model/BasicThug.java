package Model;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.Timer;

public class BasicThug extends HostileCreature {

	private int xPos = 0;
	private int yPos = 0;
	private Game_Model m;

	public BasicThug(String imageName, int hp, int atk, Game_Model m, int x, int y) {
		super(imageName, hp, atk, m);
		xPos = x;
		yPos = y;
		model = m;
	}

	public void begin() {
		Timer t = new Timer(1000, d -> {
			move();
		});
	}

	// unique way this creature moves
	private void move() {
		// all possible horizontal and vertical options
		int[] horizontal = { 1, -1, 1, 1, -1, -1, 0, 0 };
		int[] vertical = { 0, 0, 1, -1, 1, -1, 1, -1 };
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
		//model.gameBoard[xPos][yPos].clearCreature();
		xPos += horizontal[move];
		yPos += vertical[move];
		possible.clear();

	}

	// helper method
	private boolean inBounds(int x, int y) {
		if (!model.gameBoard[y][x].walkable) {
			return false;
		}
		return (x >= 0 && x < 10) && (y >= 0 && y < 10);

	}
}
