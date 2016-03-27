package Controller;

import Model.Game_Model;

public class Game_Controller {

    Game_Controller controller = new Game_Controller();
    Game_Model model = new Game_Model();

    public int getBoardSize() {
        return model.getBoardSize();
    }

    public static void setBoardSize(int boardSize) {
        Game_Controller.boardSize = boardSize;
    }

    public static int getBoardLength() {
        return boardLength;
    }

    //Testing Branching

}
