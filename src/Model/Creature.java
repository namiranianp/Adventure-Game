package Model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Creature {
	BufferedImage pic;

	public Creature(String fileName) {
		try {
			pic = ImageIO.read(new File("images/" + fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public BufferedImage getpic() {
		return pic;
	}
}