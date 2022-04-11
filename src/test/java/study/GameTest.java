package study;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.Ball;
import baseball.BallStatus;
import baseball.Game;

class GameTest {

	// B
    @Test
    @DisplayName("게임은 세개의 공을 갖는다")
    void setBall() {
        Game game = Game.start();
        assertEquals(3, game.getBalls().size());
    }
    
}
