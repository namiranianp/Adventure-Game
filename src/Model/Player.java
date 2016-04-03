package Model;

public class Player {
	private int direction; // up = 1 right = 2 down = 3 left = 4

	public void setDirection(String facing) {
		if (facing.equals("up")) {
			direction = 1;
		}if(facing.equals("right")){
			direction = 2;
		}if(facing.equals("down")){
			direction = 3;
		}if(facing.equals("left")){
			direction = 4;
		}
	}
}
