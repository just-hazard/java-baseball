package baseball.domain;

public class Number {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private final int number;

    public Number(int inputNumber) {
        validNumber(inputNumber);
        this.number = inputNumber;
    }

    public void validNumber(int inputNumber) {
        if(inputNumber < MIN_NUMBER || inputNumber > MAX_NUMBER) {
            throw new IllegalArgumentException("1-9 범위의 숫자가 아닙니다.");
        }
    }

    public int getNumber() {
        return number;
    }

    public boolean isMatchNumber(int number) {
        return this.number == number;
    }
}
