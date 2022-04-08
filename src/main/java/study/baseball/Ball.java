package study.baseball;

public class Ball {

    private final int ballOrder;
    private final int ballValue;

    private Ball(int ballOrder, int ballValue) {
        this.ballOrder = ballOrder;
        this.ballValue = ballValue;
    }

    public static Ball createBall(int ballOrder, int ballValue) {
        return new Ball(ballOrder, ballValue);
    }

    public int getOrder() {
        return this.ballOrder;
    }

    public Integer getValue() {
        return this.ballValue;
    }

    private boolean isSameValue(int gameValue, int userValue) {
        return gameValue == userValue;
    }

    private boolean isSameOrder(int gameOrder, int userOrder) {
        return gameOrder == userOrder;
    }
    
    public BallStatus play(Ball userBall) {
        if(isSameOrder(this.ballOrder, userBall.getOrder()) && isSameValue(this.ballValue, userBall.ballValue)) {
            return BallStatus.NOTHING;
        }
        return BallStatus.NOTHING;
    }
}
