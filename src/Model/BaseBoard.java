package Model;

import java.util.Random;

public class BaseBoard {
	private String file;
	private int monsters;
	private boolean dark;
	HostileCreature mob;

	public BaseBoard(String fileName, int numMonsters, boolean isDark, HostileCreature monster) {
		file = fileName;
		monsters = numMonsters;
		dark = isDark;
		mob = monster;
	}

	public HostileCreature getMonster(){
		return mob;
	}
	
	public int getNumMonsters(){
		return monsters;
	}
	
	public boolean isDarkened() {
		return dark;
	}

	public String getFileName() {
		return file;
	}

	public void darken() {
		dark = true;
	}

	public void lighten() {
		dark = false;
	}
}
