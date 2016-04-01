package Model;

public class BaseBoard {
	private String file;
	private int monsters;
	private boolean dark;

	public BaseBoard(String fileName, int numMonsters, boolean isDark) {
		file = fileName;	
		monsters = numMonsters;
		dark = isDark;
	}
	
	public boolean isDarkened(){
		return dark;
	}
	
	public String getFileName(){
		return file;
	}
}
