package Model;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BackgroundTile {
	BufferedImage image, topImage;
	static BufferedImage soldier, darkness, powerUp, pot;
	boolean walkable;
	boolean player;
	boolean dark;

	public boolean isPower() {
		return power;
	}

	public void setPower(boolean power) {
		this.power = power;
	}

	public boolean isHealth() {
		return health;
	}

	public void setHealth(boolean health) {
		this.health = health;
	}

	boolean power;
	boolean health;
	HostileCreature bad = null;

	// creates the image with whether or not it's walkable
	public BackgroundTile(BufferedImage pic, boolean walk) {
		image = pic;
		walkable = walk;
		try {
			if (soldier == null) {
				// image of our player
				soldier = ImageIO.read(new File("images/temp_soldier.png"));
				// black
				darkness = ImageIO.read(new File("images/black.png"));
				// health pot
				pot = ImageIO.read(new File("images/potion.png"));
				// powerUp
				powerUp = ImageIO.read(new File("images/powerUp.png"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//
	public void setCreature(HostileCreature b) {
		bad = b;
		setTopImage(bad.getpic());
	}

	public boolean hasCreature() {
		return bad != null;
	}

	public void clearCreature() {
		clearTopImage();
		bad = null;
	}

	public HostileCreature getCreature() {
		return bad;
	}
	//

	// return whether or not it is walkable
	public boolean canWalk() {
		return walkable;
	}

	// return the image of this tile
	public BufferedImage getImage() {
		if (player) {
			return soldier;
		} else if (dark) {
			return darkness;
		} else if (topImage != null) {
			return topImage;
		} else if (power) {
			return powerUp;
		} else if (health) {
			return pot;
		}
		return image;
	}

	public void setTopImage(BufferedImage pic) {
		topImage = pic;
	}

	public void clearTopImage() {
		topImage = null;
	}

	// boolean to say whether or not there is a player on this tile
	public void setPlayer(boolean isThere) {
		player = isThere;
	}

	// changes whether or not a square is dark or not
	public void setDark(boolean isDark) {
		dark = isDark;
	}
}