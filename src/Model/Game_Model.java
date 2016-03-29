package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Game_Model{
	final static int BOARDSIZE = 10;
	BackgroundTile[][] gameBoard = new BackgroundTile[BOARDSIZE][BOARDSIZE];
	
	
	public Game_Model(){
		fillBoard("board.txt");
	}
	
	//fills the game board with the map on the desired file
	private void fillBoard(String fileName){		
		try {
			Scanner read = new Scanner(new File(fileName));
			for(int i=0; i<BOARDSIZE; i++){
				for(int j=0; j<BOARDSIZE; j++){
					String imageName = read.next();
					imageName = imageName.substring(1);
					
					String walkable = read.next();
					walkable = walkable.substring(0, walkable.length()-1);
					
					//gameBoard[j][i] = new BackgroundTile(pic, walk)
					System.out.println(imageName);
					System.out.println(walkable);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}