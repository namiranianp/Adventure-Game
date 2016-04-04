package Model;

import Controller.Game_Controller;

public class Player {
	private int direction = 4; // up = 1 right = 2 down = 3 left = 4
	private int health = 50;
	Game_Controller control;
	int attack = 1;

	public Player(Game_Controller c) {
		control = c;
	}

	public void setDirection(int facing) {
		direction = facing;
	}

	public int getDirection() {
		return direction;
	}

	//
	public void changeHealth(int change) {
		health += change;
		if (health <= 0) {
			// TODO
		}
	}

	public int getHealth() {
		return health;
	}
	//

	//
	public int getDamage() {
		return attack;
	}

	public void upDamage() {
		attack++;
	}
	//
}
