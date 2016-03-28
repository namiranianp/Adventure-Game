package View;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel{
	public void paintComponent(Graphics g){
		g.setColor(Color.WHITE);
		g.fillRect(20, 40, 600, 600);
	}
}
