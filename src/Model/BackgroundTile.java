package Model;

import java.awt.image.BufferedImage;

public class BackgroundTile{
	BufferedImage image;
	boolean walkable = true;
	
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