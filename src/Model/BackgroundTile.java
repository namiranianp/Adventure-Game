package Model;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class BackgroundTile{
	BufferedImage image;
	boolean walkable = true;
	boolean player = false;

	
	//creates the image with whether or not it's walkable
	public BackgroundTile(BufferedImage pic, boolean walk){
		image = pic;
		walkable = walk;
	}
	
	//return whether or not it is walkable
	public boolean canWalk(){
		return walkable;
	}
	
	//return the image of this tile
	public BufferedImage getImage(){
		return image;
	}
}