package Model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Item {
	private BufferedImage pic;

	public Item(String fileName) {
		try {
			pic = ImageIO.read(new File("images/" + fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public BufferedImage getImage(){
		return pic;
	}

}
