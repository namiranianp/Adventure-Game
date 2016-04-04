package Model;

public class HostileCreature extends Creature {
	private int health;
	private int attack;
	private Weapon gun = null;

	public HostileCreature(String imageName, int hp, int atk, Weapon g) {
		super(imageName);
		health = hp;
		attack = atk;
		gun = g;
	}

	//
	public void changeHealth(int hp) {
		health -= hp;
		if (health <= 0) {
			// TODO
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
