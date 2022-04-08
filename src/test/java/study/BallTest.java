package study;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import study.baseball.Ball;

class BallTest {

	@Test
	@DisplayName("공은 위치와 값을 같는다.")
	void test() {
		int ballOrder = 1;
		int ballValue = 2;
		
		Ball ball = Ball.createBall(ballOrder, ballValue);
		assertEquals(ballOrder, ball.getOrder());
		assertEquals(ballValue, ball.getValue());
	}
}
