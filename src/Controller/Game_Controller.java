package Controller;

import java.awt.image.BufferedImage;

import Model.Game_Model;
import View.Game_View;

public class Game_Controller {

	Game_Model model;
	Game_View view;

	public void playGame() {

        view = new Game_View(this);
        model = new Game_Model();
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
