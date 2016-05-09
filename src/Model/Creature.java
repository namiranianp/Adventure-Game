package Model;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Creature {
	BufferedImage pic;

	public Creature(String fileName) {
		try {
			pic = ImageIO.read(new File("images/" + fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public BufferedImage getpic() {
		return pic;
	}
}