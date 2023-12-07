package hexlet.code.games;

import java.util.Random;

public class GCDGame implements Game {
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

    public ResultCheckAnswer postAnswer(String answer) {
        int rightAnswer = getRightAnswer(guessedNumber1, guessedNumber2);
        boolean isRightAnswer = checkAnswer(Integer.parseInt(answer), rightAnswer);
        return new ResultCheckAnswer(String.valueOf(rightAnswer), isRightAnswer);
    }

    private static int getRightAnswer(int guessedNumber1, int guessedNumber2) {
        int min = Math.min(guessedNumber1, guessedNumber2);
        int max = Math.max(guessedNumber1, guessedNumber2);
        int gcd;
        do {
            gcd = max % min;
            max = min;
            min = gcd;
        } while (gcd != 0);
        return max;
    }

    private static boolean checkAnswer(int answer, int rightAnswer) {
        return rightAnswer == answer;
    }
}
