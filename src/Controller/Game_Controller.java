package Controller;

import Model.Game_Model;
import View.Game_View;

import java.awt.image.BufferedImage;

public class Game_Controller {

	Game_Model model;
	Game_View view;

	public void playGame() {

		model = new Game_Model(this);
		view = new Game_View(this);
		view.addKeyAdapter(new CustomKeyAdapter(model, view));
        setFlashlight(true);
	}

	public int[][] getFlashlightArr(){
		return model.flashlightArray;
	}

	public BufferedImage getImage(int row, int col) {
		return model.getImage(row, col);
	}

	public int getBoardSize() {
		return model.getBoardSize();
	}

	public int getBoardLength() {
		return model.getBoardSize();
	}

    //Sets the flashlight to on or off
	public void setFlashlight(boolean flashlight){
		view.setFlashLight(flashlight);
	}

}
