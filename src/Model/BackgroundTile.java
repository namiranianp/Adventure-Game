package Model;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BackgroundTile {
	BufferedImage image;
	BufferedImage soldier;
	BufferedImage darkness;
	boolean walkable = true;
	boolean player = false;
	boolean dark = false;

	// creates the image with whether or not it's walkable
	public BackgroundTile(BufferedImage pic, boolean walk) {
		image = pic;
		walkable = walk;
		try {
			// image of our player
			soldier = ImageIO.read(new File("images/temp_soldier.png"));
			// black
			darkness = ImageIO.read(new File("images/black.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// return whether or not it is walkable
	public boolean canWalk() {
		return walkable;
	}

	// return the image of this tile
	public BufferedImage getImage() {
		if (player) {
			return soldier;
		}
		return image;
	}

	// boolean to say whether or not there is a player on this tile
	public void setPlayer(boolean isThere) {
		player = isThere;
	}

	// changes whether or not a square is dark or not
	public void setDark(boolean light) {
		dark = light;
	}
}