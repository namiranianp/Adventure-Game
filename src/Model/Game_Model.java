package Model;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Game_Model {
	int xPos = 8;
	int yPos = 5;
	final static int BOARDSIZE = 10;
	BackgroundTile[][] gameBoard = new BackgroundTile[BOARDSIZE][BOARDSIZE];

	public Game_Model() {
		fillBoard("board.txt");
		gameBoard[xPos][yPos].setPlayer(true);
	}

	// fills the game board with the map on the desired file
	private void fillBoard(String fileName) {
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
		}

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