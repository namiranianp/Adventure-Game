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

<<<<<<< HEAD
	public void moveToUser() {

		int playerPosX = model.getPosX();
		int playerPosY = model.getPosY();

		if (inBounds(playerPosX, playerPosY)) {

			model.gameBoard[xPos][yPos].clearCreature();
			xPos = playerPosX;
			yPos = playerPosY;
			model.gameBoard[xPos][yPos].setCreature(this);
=======
	//region Richards Code
	public void moveToUser(){

		int playerPosX = model.getPosX();
		int playerPosY = model.getPosY();
		
		//How far before hostile creature follows the player
		int range = 3;
		//Radius of hostile creature
		if(inBounds(xPos,yPos) && Math.pow(playerPosX - xpos, 2) + Math.pow(playerPosY - ypos, 2) < Math.pow(range,2)){
			//Move toward player (this probabily doesnt work, im still changing it)
			xPos = xPos + (playerPosX - (Math.abs(posX) + 1));
			yPos = xPos + (playerPosX - (Math.abs(posX) + 1));
>>>>>>> 66d021dc78aabd92c043826d177db014dcb7c808
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
//endregion

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
