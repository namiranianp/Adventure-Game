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
