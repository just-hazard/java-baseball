package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {

    private Ball ball;

    @BeforeEach
    void setUp() {
        ball = new Ball(1,2);
    }

    @Test
    void strike() {
        BallStatus status = ball.play(new Ball(1,2));
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void nothing() {
        BallStatus status = ball.play(new Ball(2,3));
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    void ball() {
        BallStatus status = ball.play(new Ball(2,2));
        assertThat(status).isEqualTo(BallStatus.BALL);
    }
}
