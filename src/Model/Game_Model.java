package Model;

import Controller.Game_Controller;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Game_Model {
	// player's positions on the game board
	private int xPos = 7;
	private int yPos = 4;

	// player's positions in the world array
	private int globalX = 9;
	private int globalY = 1;

	// use these values to edit the surrounding values
	final int[] horizontal = { 0, 1, -1, 1, 1, -1, -1, 0, 0 };
	final int[] vertical = { 0, 0, 0, 1, -1, 1, -1, 1, -1 };

	//variables to show where the player is trying to exit the board
	final int UP = 0;
	final int DOWN = 3;
	final int LEFT = 4;
	final int RIGHT = 2;
	
	
	final static int BOARDSIZE = 10;
	public BaseBoard[][] world = new BaseBoard[10][10];
	BackgroundTile[][] gameBoard = new BackgroundTile[BOARDSIZE][BOARDSIZE];
	Game_Controller cont;
	public boolean flashlight = false;

	public Game_Model(Game_Controller controller) {
		world[9][1] = new BaseBoard("board.txt", 0, true);
		fillBoard(globalX, globalY);
		gameBoard[xPos][yPos].setPlayer(true);
		cont = controller;
	}

	// turns everything dark
	private void darkenBoard() {
		for (int i = 0; i < BOARDSIZE; i++) {
			for (int j = 0; j < BOARDSIZE; j++) {
				gameBoard[i][j].setDark(true);
			}
		}
	}

	// make the parts around it lighter
	private void lightenBoard() {
		darkenBoard();
		for (int i = 0; i < horizontal.length; i++) {
			if (inBounds(getPosX() + horizontal[i], getPosY() + vertical[i])) {
				gameBoard[getPosX() + horizontal[i]][getPosY() + vertical[i]].setDark(false);
			}
		}

	}

	// fills the game board with the map on the desired file
	private void fillBoard(int worldX, int worldY) {
		String fileName = world[worldX][worldY].getFileName();
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
			e.printStackTrace();
		}

		if (world[worldX][worldY].isDarkened()) {
			flashlight = true;
			lightenBoard();
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

			if (flashlight) {
				lightenBoard();
			}

		}
		if (!inBounds(x, y)) {

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
