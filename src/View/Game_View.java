package View;

import java.awt.Graphics;

import javax.swing.JPanel;

public class Game_View {
	
	public Game_View(){
		System.out.println("it worked!");
	}
	
	
	private class mainViewPanel extends JPanel {
		public void paintComponent(Graphics g) {
			for(int i=0; i<Game_Controller.getBoardSize(); i++){
				for(int j=0; j<Game_Controller.getBoardLength(); j++){
					
				}
			}
		}
	}
}
