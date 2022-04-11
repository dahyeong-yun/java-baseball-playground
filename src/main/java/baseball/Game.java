package baseball;

import java.util.ArrayList;
import java.util.List;

public class Game {

	private List<Ball> gameBalls;
	
	public static Game start() {
		Game game = new Game();
		game.createGameBalls();
		return game;
	}

	private void createGameBalls() {
		gameBalls = new ArrayList<Ball>();
		
		int idx = 0;
		while(gameBalls.size() <3 )  {
			gameBalls.add(Ball.createBall(idx++, 7));
		}
	}

	public List<Ball> getBalls() {
		return gameBalls;
	}
}
