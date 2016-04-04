package Model;

import java.awt.image.BufferedImage;

public class Weapon {
	int damage;
	BufferedImage icon;
	
	public Weapon(int dmg, BufferedImage pic){
		damage = dmg;
		icon = pic;
	}
	
	public int getDamage(){
		return damage;
	}
	public BufferedImage getImage(){
		return icon;
	}
}
