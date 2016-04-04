package Model;

import java.util.ArrayList;
import java.util.Random;

public class HostileCreature extends Creature {
	private int health;
	private int attack;
	private Weapon gun = null;
	private int xPos;
	private int yPos;
	Game_Model model;

	public HostileCreature(String imageName, int hp, int atk, Weapon g, Game_Model m) {
		super(imageName);
		health = hp;
		attack = atk;
		gun = g;
		model = m;
	}

	//
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
		model.gameBoard[xPos][yPos].setCreature(this);
	}

	private boolean inBounds(int x, int y) {
		return (x >= 0 && x < 10) && (y >= 0 && y < 10);

	}
	//

	//
	public void changeHealth(int hp) {
		health -= hp;
		if (health <= 0) {
			model.gameBoard[xPos][yPos].clearCreature();
			
		}
	}

	public int getHealth() {
		return health;
	}
	//

	public int getAttack() {
		return attack;
	}

	public Weapon getWeapon() {
		return gun;
	}

}
