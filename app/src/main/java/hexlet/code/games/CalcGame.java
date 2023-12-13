package hexlet.code.games;

import java.util.Random;

public final class CalcGame implements Game {
    private static final int MAX_NUMBER_GUESS = 100;
    private static final int GUESSES_OPERATORS_COUNT = 2;
    private static final String RULE = "What is the result of the expression?";

    @Override
    public String getRule() {
        return RULE;
    }

    @Override
    public RoundData generateRound() {
        String question;
        Random random = new Random();
        int guessedNumber1 = random.nextInt(MAX_NUMBER_GUESS);
        int guessedNumber2 = random.nextInt(MAX_NUMBER_GUESS);
        String guessedOperator = random.nextInt(GUESSES_OPERATORS_COUNT) == 0 ? "-" : "+";
        int rightAnswer = getRightAnswer(guessedNumber1, guessedNumber2, guessedOperator);
        question = guessedNumber1 + " " + (guessedOperator) + " " + guessedNumber2;
        return new RoundData(question, String.valueOf(rightAnswer));
    }

    private int getRightAnswer(int number1, int number2, String operator) {
        return operator.equals("-")
                ? number1 - number2
                : number1 + number2;
    }
}
