package Model;

import Controller.Game_Controller;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Game_Model {
	private int xPos = 8;
	private int yPos = 5;
	private int hp = 3;

    //use these values to edit the surrounding values
    final int[] horizontal = {0,1,-1,1, 1,-1,-1,0, 0};
    final int[] vertical =   {0,0, 0,1,-1, 1,-1,1,-1};

	final static int BOARDSIZE = 10;
	BackgroundTile[][] gameBoard = new BackgroundTile[BOARDSIZE][BOARDSIZE];
    public int[][]  flashlightArray = new int[BOARDSIZE][BOARDSIZE];
    Game_Controller cont;

	public Game_Model(Game_Controller controller) {
		fillBoard("board.txt");
		gameBoard[xPos][yPos].setPlayer(true);
        cont = controller;
	}

	// fills the game board with the map on the desired file
	private void fillBoard(String fileName) {

        //All of the positions are "not lit"
        for (int i = 0; i < flashlightArray.length; i++) {
            for (int j = 0; j < flashlightArray.length; j++) {
                flashlightArray[i][j] = 0;
            }
        }

		try {
			Scanner read = new Scanner(new File("Boards/" + fileName));
			for (int i = 0; i < BOARDSIZE; i++) {
				for (int j = 0; j < BOARDSIZE; j++) {
					String imageName = read.next();
					imageName = imageName.substring(1);
					BufferedImage pic = ImageIO.read(new File("images/" + imageName));

					String walkable = read.next();
					walkable = walkable.substring(0, walkable.length() - 1);

					if (walkable.equalsIgnoreCase("true")) {
						gameBoard[j][i] = new BackgroundTile(pic, true);
					} else {
						gameBoard[j][i] = new BackgroundTile(pic, false);
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        //make a 3x3 boundary around player as "Flashlight"
        for (int i = 0; i < horizontal.length; i++) {
            if(inBounds(getPosX()+horizontal[i] , getPosY()+vertical[i])){

                flashlightArray[getPosX()+horizontal[i]][getPosY()+vertical[i]] = 1;

            }
        }

	}

	// returns the board size (length = width)
	public int getBoardSize() {
		return BOARDSIZE;
	}

	// returns the image at the location requested
	public BufferedImage getImage(int x, int y) {
		return gameBoard[y][x].getImage();
	}

	public int getXPos() {
		return xPos;
	}

	public int getYPos() {
		return yPos;
	}

	public void move(int x, int y) {

		if (inBounds(x, y) && gameBoard[x][y].canWalk()) {
			gameBoard[xPos][yPos].setPlayer(false);
			xPos = x;
			yPos = y;
			gameBoard[xPos][yPos].setPlayer(true);

            //reset the array
            for (int i = 0; i < flashlightArray.length; i++) {
                for (int j = 0; j < flashlightArray.length; j++) {
                    flashlightArray[i][j] = 0;
                }
            }

            //set flashlight from new pos
            for (int i = 0; i < horizontal.length; i++) {
                if(inBounds(getPosX()+horizontal[i] , getPosY()+vertical[i])){

                    flashlightArray[getPosX()+horizontal[i]][getPosY()+vertical[i]] = 1;

                }
            }

		}

	}
	
	//This changes characters current health
	public void editHealth(int change){
		hp += change;
	}
	public int getHealth(){
		return hp;
	}

	// checks to see whether or not the desired location is within the board
	public boolean inBounds(int x, int y) {
		return (x >= 0 && x < BOARDSIZE) && (y >= 0 && y < BOARDSIZE);
	}


	public int getPosX() {
		return xPos;
	}


	public int getPosY() {
		return yPos;
	}
}
