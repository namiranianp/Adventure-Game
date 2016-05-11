package Model;

import java.util.ArrayList;
import java.util.Random;

public class HostileCreature extends Creature {
	private int health;
	private int attack;
	private int xPos;

	private int yPos;

	Game_Model model;

	public HostileCreature(String imageName, int hp, int atk, Game_Model m) {
		super(imageName);
		health = hp;
		attack = atk;
		model = m;
	}

	// Checks and moves to a certain point.

	public void moveToUser() {

		int playerPosX = model.getPosX();
		int playerPosY = model.getPosY();

		if (inBounds(playerPosX, playerPosY)) {

			model.gameBoard[xPos][yPos].clearCreature();
			xPos = playerPosX;
			yPos = playerPosY;
			model.gameBoard[xPos][yPos].setCreature(this);
		}
	}

	public void move() {
		int[] horizontal = { 0, 1, -1, 1, 1, -1, -1, 0, 0 };
		int[] vertical = { 0, 0, 0, 1, -1, 1, -1, 1, -1 };
		ArrayList<Integer> possible = new ArrayList<Integer>();

		for (int i = 0; i < horizontal.length; i++) {
			if (inBounds(xPos + horizontal[i], yPos + vertical[i])
					&& model.gameBoard[xPos + horizontal[i]][yPos + vertical[i]].canWalk()) {
				possible.add(i);
			}
		}

		Random rand = new Random();
		int move = rand.nextInt(possible.size());
		model.gameBoard[xPos][yPos].clearCreature();
		xPos += horizontal[move];
		yPos += vertical[move];

	}

	private boolean inBounds(int x, int y) {
		return (x >= 0 && x < 10) && (y >= 0 && y < 10);

	}

	public void changeHealth(int hp) {
		health -= hp;
		if (health <= 0) {
			model.gameBoard[xPos][yPos].clearCreature();

		}
	}

	public int getHealth() {
		return health;
	}

	public int getAttack() {
		return attack;
	}

	public int getxPos() {
		return xPos;
	}

	public int getyPos() {
		return yPos;
	}

}
