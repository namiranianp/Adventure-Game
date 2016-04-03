package Model;

public class HostileCreature extends Creature {
	public int health;
	public int attack;

	public HostileCreature(String imageName, int hp, int atk) {
		super(imageName);
		health = hp;
		attack = atk;
	}

	public void setHealth(int hp) {
		health = hp;
	}
}
