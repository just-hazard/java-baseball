package baseball.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class BallsTest {

    @Test
    void play() {
        Balls com = new Balls(Arrays.asList(1,2,3));
        Result result = com.play(Arrays.asList(4,5,6));
        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(0);
    }

    @Test
    void play_1strike_1ball() {
        Balls com = new Balls(Arrays.asList(1,2,3));
        Result result = com.play(Arrays.asList(1,3,4));
        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(1);
    }

    @Test
    void play_3ball() {
        Balls com = new Balls(Arrays.asList(1,2,3));
        Result result = com.play(Arrays.asList(3,1,2));
        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(3);
    }

    @Test
    void play_3strike() {
        Balls com = new Balls(Arrays.asList(1,2,3));
        Result result = com.play(Arrays.asList(1,2,3));
        assertThat(result.getStrike()).isEqualTo(3);
        assertThat(result.getBall()).isEqualTo(0);
    }

    @Test
    void ball() {
        Balls com = new Balls(Arrays.asList(1,2,3));
        BallStatus status = com.play(new Ball(1,2));
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    void nothing() {
        Balls com = new Balls(Arrays.asList(1,2,3));
        BallStatus status = com.play(new Ball(1,9));
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    void strike() {
        Balls com = new Balls(Arrays.asList(1,2,3));
        BallStatus status = com.play(new Ball(1,1));
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }
}
