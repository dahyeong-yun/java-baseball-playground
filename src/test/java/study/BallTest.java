package study;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.Ball;
import baseball.BallStatus;

class BallTest {

    @Test
    @DisplayName("공은 위치와 값을 갖는다")
    void setBall() {
        int ballOrder = 1;
        int ballValue = 2;
        
        Ball ball = Ball.createBall(ballOrder, ballValue);
        assertEquals(ballOrder, ball.getOrder());
        assertEquals(ballValue, ball.getValue());
    }
    
    // 어떤 입력이 있을 때, 순서와 값이 맞는지 비교한다.
    // 입력을 통해 생성된 어떤 객체와 Ball 인스턴스를 비교한다.
    // 그냥 같은 객체를 사용자와 게임으로 이름을 구분한다.
    @Test
    @DisplayName("공의 위치와 값이 다른 경우는 NOTHING 이다.")
    void isNothing() {
        int gameValue = 4;
        int userValue = 3;

        int gameOrder = 2;
        int userOrder = 1;
        
        Ball gameBall = Ball.createBall(gameOrder, gameValue);
        Ball userBall = Ball.createBall(userOrder, userValue);
        assertEquals(BallStatus.NOTHING, gameBall.play(userBall));
    }
    
    @Test
    @DisplayName("공의 위치가 다르고 값이 맞는 경우는 BALL 이다.")
    void isBall() {
        int gameValue = 4;
        int userValue = 4;

        int gameOrder = 2;
        int userOrder = 1;
        
        Ball gameBall = Ball.createBall(gameOrder, gameValue);
        Ball userBall = Ball.createBall(userOrder, userValue);
        
    	assertEquals(BallStatus.BALL, gameBall.play(userBall));
    }
    
    @Test
    @DisplayName("공의 위치와 값이 같은 경우는 STRIKE 이다.")
    void isStrike() {
        int gameValue = 4;
        int userValue = 4;

        int gameOrder = 2;
        int userOrder = 2;
        
        Ball gameBall = Ball.createBall(gameOrder, gameValue);
        Ball userBall = Ball.createBall(userOrder, userValue);
        
    	assertEquals(BallStatus.STRIKE, gameBall.play(userBall));
    }
}
