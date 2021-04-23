package baseball.domain;

public class Ball {

    private final Number position;
    private final Number number;

    public Ball(int position, int ball) {
        this.position = new Number(position);
        this.number = new Number(ball);
    }

    public BallStatus play(Ball ball) {
        if(this.isMatchStrike(ball)) {
            return BallStatus.STRIKE;
        }

        if(ball.isMatchBall(number.getNumber())) {
            return BallStatus.BALL;
        }

        return BallStatus.NOTHING;
    }

    private boolean isMatchStrike(Ball ball) {
        return this.position.isMatchNumber(ball.position.getNumber()) && isMatchNumberCheck(ball.number.getNumber());
    }

    private boolean isMatchNumberCheck(int number) {
        return this.number.isMatchNumber(number);
    }

    private boolean isMatchBall(int number) {
        return isMatchNumberCheck(number);
    }
}
