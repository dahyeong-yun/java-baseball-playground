package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

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
			Random random = new Random();
			int newBallValue = random.nextInt(9) + 1;
			
			List<Integer> valueList = gameBalls.stream().map(ball -> ball.getValue()).collect(Collectors.toList());
			boolean isDuplicate = valueList.contains(newBallValue);
			if(!isDuplicate) {
				gameBalls.add(Ball.createBall(idx++, newBallValue));	
			}
		}
	}

	public List<Ball> getBalls() {
		return gameBalls;
	}
}
