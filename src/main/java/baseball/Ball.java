package baseball;

public class Ball {

    private final int ballOrder;
    private final int ballValue;

    private Ball(int ballOrder, int ballValue) {
        this.ballOrder = ballOrder;
        this.ballValue = ballValue;
    }
    
    private boolean isSameValue(int gameValue, int userValue) {
        return gameValue == userValue;
    }

    private boolean isSameOrder(int gameOrder, int userOrder) {
        return gameOrder == userOrder;
    }
    
    public static Ball createBall(int ballOrder, int ballValue) {
        if(!validate(ballValue)) {
            throw new IllegalArgumentException("공의 값은 1이상 9이하의 정수만 가능합니다.");
        }
        return new Ball(ballOrder, ballValue);
    }

    public static boolean validate(int number) {
        return number >= 1 && number <= 9;
    }

    public int getOrder() {
        return this.ballOrder;
    }

    public Integer getValue() {
        return this.ballValue;
    }
    
    public BallStatus play(Ball userBall) {
        if(!isSameOrder(this.ballOrder, userBall.getOrder()) && !isSameValue(this.ballValue, userBall.ballValue)) {
            return BallStatus.NOTHING;
        }
        if(!isSameOrder(this.ballOrder, userBall.getOrder()) && isSameValue(this.ballValue, userBall.ballValue)) {
            return BallStatus.BALL;
        }
        if(isSameOrder(this.ballOrder, userBall.getOrder()) && isSameValue(this.ballValue, userBall.ballValue)) {
            return BallStatus.STRIKE;
        }
        return BallStatus.NOTHING;
    }
}
