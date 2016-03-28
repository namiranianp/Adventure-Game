package Controller;

import Model.Game_Model;
import View.Game_View;

import java.awt.image.BufferedImage;

public class Game_Controller {

	Game_Model model;
	Game_View view;

	public void playGame() {

		model = new Game_Model();
        view = new Game_View(this);
        view.addKeyAdapter(new CustomKeyAdapter(model,view));

	}

	public BufferedImage getImage(int row, int col) {
		return model.getImage(row, col);
	}

	public int getBoardSize() {
		return model.getBoardSize();
	}

	public void setBoardSize(int boardSize) {

		model.setBoardSize(boardSize);

	}

	public int getBoardLength() {
		return model.getBoardSize();
	}

}
