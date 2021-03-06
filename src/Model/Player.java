package Model;

import Controller.Game_Controller;

public class Player {
	private int direction = 4; // up = 1 right = 2 down = 3 left = 4
	private int health = 1;
	Game_Controller control;
	Game_Model model;
	int attack = 1;

	public Player(Game_Controller c, Game_Model m) {
		model = m;
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
			// Game Over
			control.view.window.dispose();
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
