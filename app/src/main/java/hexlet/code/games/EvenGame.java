package hexlet.code.games;

import java.util.Random;

public class EvenGame implements Game {

    private static final int MAX_NUMBER_GUESS = 100;
    private static final String YES_ANSWER = "yes";
    private static final String NO_ANSWER = "no";
    private static final String TASK = "Answer '" + YES_ANSWER
            + "' if the number is even, otherwise answer '"
            + NO_ANSWER + "'.";
    private int guessedNumber;

    @Override
    public String getTask() {
        return TASK;
    }

    @Override
    public String getQuestion() {
        Random random = new Random();
        guessedNumber = random.nextInt(MAX_NUMBER_GUESS);
        return String.valueOf(guessedNumber);
    }

    @Override
    public ResultCheckAnswer postAnswer(String answer) {
        String rightAnswer = getRightAnswer(guessedNumber);
        boolean isRightAnswer = checkAnswer(answer, rightAnswer);
        return new ResultCheckAnswer(rightAnswer, isRightAnswer);
    }

    private String getRightAnswer(int number) {
        return number % 2 == 0 ? YES_ANSWER : NO_ANSWER;
    }

    private boolean checkAnswer(String answer, String rightAnswer) {
        return rightAnswer.equals(answer);
    }
}