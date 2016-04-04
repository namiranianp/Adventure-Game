package Model;

import java.awt.image.BufferedImage;

public class Weapon {
	BufferedImage icon;
	
	public Weapon(int dmg, BufferedImage pic){
		icon = pic;
	}

	public BufferedImage getImage(){
		return icon;
	}
}
