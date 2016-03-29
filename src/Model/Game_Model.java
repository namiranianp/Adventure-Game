package Model;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

//Custom experimental code, this is all pseudo code

public class Game_Model {
	// Player Info
	private int posx;
	private int posy;
	private int healthCap;
	private int health;
	

	// Map size
	private int boardSize;

	// Array of map (holds map data)
	private BufferedImage[][] map;

	// Inventory --> takes in integers that correspond to items
	private ArrayList<Integer> inv = new ArrayList<Integer>();

	// (unless we add collision with certain objects)
	public Game_Model() {
		// Base location of character
		posx = 1;
		posy = 1;
		
		healthCap = 3;
		health = 3;

		// Base size
		boardSize = 10;
		map = new BufferedImage[boardSize][boardSize];

		readFile();
	}

	// this should read the save file for map data
	public void readFile() {
		String file = "board.txt";
		String line = null;
		int row = 0;

		try {
			FileReader reader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(reader);

			while ((line = bufferedReader.readLine()) != null) {
				String[] arr = line.split(" ");
				for (int col = 0; col < boardSize; col++) {
					String temp = "images/" + arr[col].substring(1);
					BufferedImage in = ImageIO.read(new File(temp));
					map[row][col] = in;
					
				}
				row++;
			}
			bufferedReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void initializeMapArray() {
		// uses readfile and puts all data in array
	}

	/*
	 * //Saves file for character (should create a txtfile containing data)
	 * public void saveFile(){ //character data <<<<<<< HEAD }
	 * 
	 * //creates an array of the map and holds all the data of the blocks
	 * private void initializeMap(int size){ map = new
	 * BufferedImage[size][size]; // this should use file data to setup array
	 * data } ======= }
	 */
	
	public int getHealth(){
		return health;
	}
	
	public void heal(int num){
		if(health += num > healthCap){
			health = cap;
		}
	}
	
	//Increases the max hp
	public void increaseHpCap(int num){
		healthCap += num;
	}
	
	public void takeDmg(int dmg){
		health - dmg;
	}

	// Sets the data on what the map looks like
	public void setImage(int x, int y, BufferedImage pic) {
		map[y][x] = pic;
	}

	// Returns number correlating to picture
	public BufferedImage getImage(int x, int y) {
		return map[y][x];
	}

	// Moves to this location
	public void move(int x, int y) {
		if (inBounds(x, y)) {
			posx = x;
			posy = y;
		}
	}

	public int getPosX() {
		return posx;
	}

	public int getPosY() {
		return posy;
	}

	public int getBoardSize() {
		return boardSize;
	}

	public void setBoardSize(int size) {
		boardSize = size;
		map = new BufferedImage[size][size];
	}

	private boolean inBounds(int x, int y) {
		return (x < boardSize && x > 0 && y < boardSize && y > 0);
	}

	public void giveInv(int itemCode) {
		inv.add(itemCode);
	}

	// Removes the item from the inventory
	public void removeItem(int itemCode) {
		for (int i = 0; i < inv.size(); i++) {
			if (inv.get(i) == itemCode) {
				inv.remove(i);
				break;
			}
		}
	}
}
