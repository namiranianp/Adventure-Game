package Model;

import java.util.ArrayList;
import java.awt.image.BufferedImage;

//Custom experimentalcode, this is all pseudo code
public class Game_Model(){
	//Player location
	private int posx;
	private int posy;
	//Map size
	private int boardSize;
	//array of map (holds map data)
	private BufferedImage[][] map;
	
	//Inventory --> takes in ints that corrospond to items
	private ArrayList<Integer> inv = new ArrayList<Integer>();
	
	//Maybe take in current map size 
	//(unless we add collision with certain objects)
	public Adventure_Game_Model(){
		//Not sure what to put in here, 
		// maybe take in map size? and
		//starting position
		
		//Test purposes
		posx = 1;
		posy = 1;
		//This will be replaced with a method that reads a file to
		boardSize = 10;
		initializeMap(boardSize);
	}
	
	//this should read the save file for map data, should also read a save file if there is one,
	//else it will create a document named save.txt
	public void readFile(){
		//if there is no save data on document, create one.
	}
	
	//Saves file for character (should create a txtfile containing data)
	public void saveFile(){
		//character data
	}
	
	//creates an array of the map and holds all the data of the blocks
	private void initializeMap(int size){
		map = new String[size][size];
		for(int row = 0; row < map.length; row++){
			for(int col = 0; col < map[0].length; col++){
				map[row][col] = "null";
			}
		}
	}
	
	//Sets the data on what the map looks like
	public void setImage(int x, int y, BufferedImage pic){
		map[y][x] = pic;
	}
	
	//Returns number corrolating to picture
	public BufferedImage getImage(int x, int y){
		return map[y][x];
	}
	
	public void moveRight(int x, int y){
		if(inBounds(x,y)){
			x--;
		}
	}
	public void moveLeft(int x, int y){
		if(inBounds(x,y)){
			x++;
		}
	}
	public void moveUp(int x, int y){
		if(inBounds(x,y)){
			y--;
		}
	}
	public void moveDown(int x, int y){
		if(inBounds(x,y)){
			y++;
		}
	}
	
	public void getPosX(){
		return posx;
	}
	public void getPosY(){
		return posy;
	}
	
	public void getBoardSize(){
		return boardSize;
	}
	
	private boolean inBounds(int x, int y){
		return(x < boardSize && x > 0 && y < boardSize && y > 0){
	}
	
	public void giveInv(int itemCode){
		inv.add(item);
	}
	
	public void removeItem(int itemCode){
		for(int i = 0; i < inv.size(); i++){
			if(inv.get(i) == itemcode){
				inv.remove(i);
				break;
			}
		}
	}
}
