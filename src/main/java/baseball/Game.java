package baseball;

import java.util.ArrayList;
import java.util.List;

public class Game {

	private List<Ball> gameBalls;
	
	public static Game start() {
		Game game = new Game();
		return game;
	}

	public List<Ball> getBalls() {
		gameBalls = new ArrayList<Ball>();
		
		gameBalls.add(Ball.createBall(0, 0));
		gameBalls.add(Ball.createBall(1, 3));
		gameBalls.add(Ball.createBall(2, 4));
		
		return gameBalls;
	}

}
