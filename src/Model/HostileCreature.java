package Model;

import java.util.ArrayList;
import java.util.Random;

public class HostileCreature extends Creature {
	private int health;
	private int attack;
	private int xPos;
	private int yPos;

	Game_Model model;

	public HostileCreature(String imageName, int hp, int atk, Game_Model m, int xpos, int ypos) {
		super(imageName);
		health = hp;
		attack = atk;
		model = m;

		yPos = ypos;
		xPos = xpos;

	}

	// Checks and moves to a certain point.
	public void move() {
		//all possible horizontal and vertical options
		int[] horizontal = { 1, -1, 1, 1, -1, -1, 0, 0 };
		int[] vertical =   { 0, 0, 1, -1, 1, -1, 1, -1 };
		ArrayList<Integer> possible = new ArrayList<Integer>();

		//check to see if each is in bounds and if the terrain is walkable
		for (int i = 0; i < horizontal.length; i++) {
			int x = xPos + horizontal[i];
			int y = yPos + vertical[i];
			if (inBounds(x,y) && model.gameBoard[x][y].hasTerrain()) {
				possible.add(i);
			}
		}

		//randomly pick where to move
		Random rand = new Random();
		int move = rand.nextInt(possible.size());
		model.gameBoard[xPos][yPos].clearCreature();
		xPos += horizontal[move];
		yPos += vertical[move];
		possible.clear();

	}

	private boolean inBounds(int x, int y) {
		return ((x >= 0 && x < 10) && (y >= 0 && y < 10)) && model.gameBoard[y][x].canWalk();

	}

	public void changeHealth(int hp) {
		health--;
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

	public void setXPos(int x){
		xPos = x;
	}
	
	public void setYPos(int y){
		yPos = y;
	}
}
