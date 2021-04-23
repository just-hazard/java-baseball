package baseball.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Balls {

    private final List<Ball> ballsAnswers;

    public Balls(List<Integer> ballsAnswers) {
        this.ballsAnswers = mapBall(ballsAnswers);
    }

    private List<Ball> mapBall(List<Integer> balls) {
        List<Ball> ballList = new ArrayList<>();
        IntStream.range(0, balls.size())
                .forEach(it -> ballList.add(new Ball(it+1, balls.get(it))));
        return ballList;
    }

    public BallStatus play(Ball userBall) {
        return ballsAnswers.stream()
                .map(it -> it.play(userBall))
                .filter(BallStatus::isNotNothing)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }

    public Result play(List<Integer> balls) {
        Balls userBalls = new Balls(balls);
        Result result = new Result();
        for(Ball ballAnswer : ballsAnswers) {
            BallStatus status = userBalls.play(ballAnswer);
            result.deliverable(status);
        }
        return result;
    }
}
