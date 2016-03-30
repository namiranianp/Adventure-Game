package Model;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class BackgroundTile{
	BufferedImage image;
	boolean walkable = true;
	boolean player = false;
	final BufferedImage PLAYER = ImageIO.read(new File("images/"))
	
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