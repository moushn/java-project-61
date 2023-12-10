package hexlet.code.games;

import java.util.Random;

public final class CalcGame implements Game {
    private static final int MAX_NUMBER_GUESS = 100;
    private static final int GUESSES_OPERATORS_COUNT = 2;
    private static final String TASK = "What is the result of the expression?";
    private int guessedNumber1;
    private int guessedNumber2;
    private String guessedOperator;

    @Override
    public String getTask() {
        return TASK;
    }

    public String getQuestion() {
        Random random = new Random();
        guessedNumber1 = random.nextInt(MAX_NUMBER_GUESS);
        guessedNumber2 = random.nextInt(MAX_NUMBER_GUESS);
        guessedOperator = random.nextInt(GUESSES_OPERATORS_COUNT) == 0 ? "-" : "+";
        return guessedNumber1 + " " + (guessedOperator) + " " + guessedNumber2;
    }

    public CheckAnswerResult postAnswer(String answer) {
        int rightAnswer = getRightAnswer(guessedNumber1, guessedNumber2, guessedOperator);
        boolean isRightAnswer = checkAnswer(Integer.parseInt(answer), rightAnswer);
        return new CheckAnswerResult(String.valueOf(rightAnswer), isRightAnswer);
    }

    private int getRightAnswer(int number1, int number2, String operator) {
        return operator.equals("-")
                ? number1 - number2
                : number1 + number2;
    }

    private boolean checkAnswer(int answer, int rightAnswer) {
        return rightAnswer == answer;
    }
}
