package Model;

import java.util.ArrayList;

//Custom experimentalcode, this is all pseudo code
public class Game_Model(){
	//Player location
	private int posx;
	private int posy;
	
	//Inventory --> takes in ints that corrospond to items
	private ArrayList<Integer> inv = new ArrayList<Integer>();
	
	//Maybe take in current map size 
	//(unless we add collision with certain objects)
	public Adventure_Game_Model(){
		//Not sure what to put in here, 
		// maybe take in map size? and
		//starting position
		posx = 1;
		posy = 1;
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
	
	private boolean inBounds(int x, int y){
		/*
		return(x < worldsizewidth && x > 0 && 
		y < worldsizeheight && y > 0){
		*/
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
