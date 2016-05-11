package Model;

import Controller.Game_Controller;

import javax.imageio.ImageIO;
import javax.swing.*;
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

	// final variables for the directions
	final public int UP = 1;
	final public int DOWN = 3;
	final public int LEFT = 4;
	final public int RIGHT = 2;

	final static int BOARDSIZE = 10;
	public BaseBoard[][] world = new BaseBoard[10][4];
	public BackgroundTile[][] gameBoard = new BackgroundTile[BOARDSIZE][BOARDSIZE];
	Game_Controller cont;
	public boolean flashlight = false;

	// player object
	public Player guy;
	public HostileCreature test;

	public Game_Model(Game_Controller controller) {
		makeAllBoards();
		fillBoard();
		gameBoard[xPos][yPos].setPlayer(true);
		cont = controller;
		guy = new Player(cont);

		test = new HostileCreature("enemy.png", 10, 1, this,xPos - 2,yPos);
		gameBoard[xPos - 2][yPos].setCreature(test);
		test.setXPos(xPos - 2);
		test.setYPos(yPos);
		Timer t = new Timer(1000, d -> {
            System.out.println(test.getxPos() + " , " + test.getyPos());
			moveCreature();
			//damagePlayer();
		});
		t.start();
	}

	private void moveCreature() {
		// updates creature's position
		test.move();
		int x = test.getxPos();
		int y = test.getyPos();
		// draws creature
		gameBoard[x][y].setCreature(test);
	}

	public void damagePlayer() {
		// all possible horizontal and vertical options
		int[] horizontal = { 0, 1, -1, 1, 1, -1, -1, 0, 0 };
		int[] vertical = { 0, 0, 0, 1, -1, 1, -1, 1, -1 };

		// check to see if each is in bounds and if the terrain is walkable and
		// if there is a player
		for (int i = 0; i < horizontal.length; i++) {
			if ((inBounds(xPos + horizontal[i], yPos + vertical[i])
					&& !gameBoard[xPos + horizontal[i]][yPos + vertical[i]].hasTerrain())
					&& gameBoard[xPos + horizontal[i]][yPos + vertical[i]].player) {
				guy.changeHealth(-1);
				if(guy.getHealth() == 0){
					System.out.println("GAME OVER");
				}
			}
		}
	}

	private void makeAllBoards() {
		world[9][0] = new BaseBoard("[9][0].txt", 0, false, null);
		world[8][0] = new BaseBoard("[8][0].txt", 0, false, null);
		world[7][0] = new BaseBoard("[7][0].txt", 0, false, null);
		world[6][0] = new BaseBoard("[6][0].txt", 0, false, null);
		world[5][0] = new BaseBoard("[5][0].txt", 0, false, null);
		world[4][0] = new BaseBoard("[4][0].txt", 0, false, null);
		world[3][0] = new BaseBoard("[3][0].txt", 0, false, null);
		world[2][0] = new BaseBoard("[2][0].txt", 0, false, null);
		world[1][0] = new BaseBoard("[1][0].txt", 0, false, null);
		world[0][0] = new BaseBoard("[0][0].txt", 0, false, null);
		//
		world[9][1] = new BaseBoard("[9][1].txt", 0, false, null);
		world[8][1] = new BaseBoard("[8][1].txt", 0, false, null);
		world[7][1] = new BaseBoard("[7][1].txt", 0, false, null);
		world[6][1] = new BaseBoard("[6][1].txt", 0, false, null);
		world[5][1] = new BaseBoard("[5][1].txt", 0, false, null);
		world[4][1] = new BaseBoard("[4][1].txt", 0, false, null);
		world[3][1] = new BaseBoard("[3][1].txt", 0, false, null);
		world[2][1] = new BaseBoard("[2][1].txt", 0, false, null);
		world[1][1] = new BaseBoard("[1][1].txt", 0, false, null);
		world[0][1] = new BaseBoard("[0][1].txt", 0, false, null);
		//
		world[9][2] = new BaseBoard("[9][2].txt", 0, false, null);
		world[8][2] = new BaseBoard("[8][2].txt", 0, false, null);
		world[2][2] = new BaseBoard("[2][2].txt", 0, false, null);
		world[1][2] = new BaseBoard("[1][2].txt", 0, false, null);
		world[0][2] = new BaseBoard("[0][2].txt", 0, false, null);
		//
		world[9][3] = new BaseBoard("[9][3].txt", 0, false, null);
		world[8][3] = new BaseBoard("[8][3].txt", 0, false, null);
		world[7][3] = new BaseBoard("[7][3].txt", 0, false, null);
		world[6][3] = new BaseBoard("[6][3].txt", 0, false, null);
		world[0][3] = new BaseBoard("[0][3].txt", 0, false, null);
	}

	public void shoot() {
		if (guy.getDirection() == UP) {
			for (int i = yPos; i >= 0; i--) {
				if (gameBoard[xPos][i].hasTerrain())
					if (gameBoard[xPos][i].hasCreature()) {
						gameBoard[xPos][i].getCreature().changeHealth(guy.getDamage());
					}
			}
		}
		if (guy.getDirection() == RIGHT) {
			for (int i = xPos; i < BOARDSIZE; i++) {
				if (gameBoard[i][yPos].hasCreature()) {
					gameBoard[i][yPos].getCreature().changeHealth(guy.getDamage());
				}
			}
		}
		if (guy.getDirection() == LEFT) {
			for (int i = xPos; i < BOARDSIZE; i++) {
				if (gameBoard[i][yPos].hasCreature()) {
					gameBoard[i][yPos].getCreature().changeHealth(guy.getDamage());
				}
			}
		}
		if (guy.getDirection() == DOWN) {
			for (int i = yPos; i < BOARDSIZE; i++) {
				if (gameBoard[xPos][i].hasCreature()) {
					gameBoard[xPos][i].getCreature().changeHealth(guy.getDamage());
				}
			}
		}
	}

	public void setDirection(int direction) {
		guy.setDirection(direction);
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
	private void fillBoard() {
		String fileName = world[globalX][globalY].getFileName();
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

		if (world[globalX][globalY].isDarkened()) {
			flashlight = true;
			lightenBoard();
		} else {
			flashlight = false;
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
			switchBoard(x, y);
		}

	}

	private void switchBoard(int x, int y) {

		if (y < 0) {
			globalY--;
			gameBoard[xPos][yPos].setPlayer(false);
			yPos = BOARDSIZE - 1;
			fillBoard();
			gameBoard[xPos][yPos].setPlayer(true);
		} else if (y == BOARDSIZE) {
			globalY++;
			gameBoard[xPos][yPos].setPlayer(false);
			yPos = 0;
			fillBoard();
			gameBoard[xPos][yPos].setPlayer(true);
		} else if (x < 0) {
			globalX--;
			gameBoard[xPos][yPos].setPlayer(false);
			xPos = BOARDSIZE - 1;
			fillBoard();
			gameBoard[xPos][yPos].setPlayer(true);
		} else if (x == BOARDSIZE) {
			globalX++;
			gameBoard[xPos][yPos].setPlayer(false);
			xPos = 0;
			fillBoard();
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
