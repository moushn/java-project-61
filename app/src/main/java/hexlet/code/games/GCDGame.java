package hexlet.code.games;

import java.util.Random;

public final class GCDGame implements Game {
    private static final int MAX_NUMBER_GUESS = 100;
    private static final String TASK = "Find the greatest common divisor of given numbers.";
    private int guessedNumber1;
    private int guessedNumber2;

    @Override
    public String getTask() {
        return TASK;
    }

    public String getQuestion() {
        Random random = new Random();
        guessedNumber1 = random.nextInt(MAX_NUMBER_GUESS);
        guessedNumber2 = random.nextInt(MAX_NUMBER_GUESS);
        return guessedNumber1 + " " + guessedNumber2;
    }

    public CheckAnswerResult postAnswer(String answer) {
        int rightAnswer = getRightAnswer(guessedNumber1, guessedNumber2);
        boolean isRightAnswer = checkAnswer(Integer.parseInt(answer), rightAnswer);
        return new CheckAnswerResult(String.valueOf(rightAnswer), isRightAnswer);
    }

    private int getRightAnswer(int number1, int number2) {
        int min = Math.min(number1, number2);
        int max = Math.max(number1, number2);
        int gcd;
        do {
            gcd = max % min;
            max = min;
            min = gcd;
        } while (gcd != 0);
        return max;
    }

    private boolean checkAnswer(int answer, int rightAnswer) {
        return rightAnswer == answer;
    }
}
