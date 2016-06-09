package Model;

import javax.swing.*;

public class HostileCreature extends Creature {
	private int health;
	private int attack;
	private int xPos;
	private int yPos;
	Game_Model model;
	Timer t = null;
	
	public HostileCreature(String imageName, int hp, int atk, Game_Model m, int x, int y) {
		super(imageName);
		health = hp;
		attack = atk;
		model = m;
		xPos = x;
		yPos = y;
	}
	
	public void begin(){
		t.start();
	}
	
	public void stop(){
		t.stop();
	}
	
	public void changeHealth(int hp) {
		health += hp;
		if (health <= 0) {
			model.gameBoard[xPos][yPos].getCreature().stop();
			model.gameBoard[xPos][yPos].clearCreature();
		}
	}

	public int getHealth() {
		return health;
	}

	public int getAttack() {
		return attack;
	}

	public int getXPos() {
		return xPos;
	}

	public int getYPos() {
		return yPos;
	}

	public void setXPos(int x){
		xPos = x;
	}
	
	public void setYPos(int y){
		yPos = y;
	}
	
	public void setPos(int x, int y){
		xPos = x;
		yPos = y;
	}
	
}
