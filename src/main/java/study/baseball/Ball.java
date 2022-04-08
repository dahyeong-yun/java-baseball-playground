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

}
