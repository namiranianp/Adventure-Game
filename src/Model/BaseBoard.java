package Model;

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
	
	public boolean isDarkened(){
		return dark;
	}
	
	public String getFileName(){
		return file;
	}
}
