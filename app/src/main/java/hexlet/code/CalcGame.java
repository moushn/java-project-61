package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class CalcGame {
    private static final int NEED_RIGHT_ANSWER = 3;
    private static final int MAX_NUMBER_GUESS = 100;
    private static final int GUESSES_OPERATORS_COUNT = 2;

    public static void start() {
        System.out.println("What is the result of the expression?");
        if (play()) {
            System.out.println("Congratulations, " + Cli.getUsername() + "!");
        }
    }

    private static boolean play() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int guessedNumber1;
        int guessedNumber2;
        int guessedOperator;

        String answer;
        int rightAnswer;
        boolean isRightAnswer = false;

        for (int i = 0; i < NEED_RIGHT_ANSWER; i += 1) {
            guessedNumber1 = random.nextInt(MAX_NUMBER_GUESS);
            guessedNumber2 = random.nextInt(MAX_NUMBER_GUESS);
            guessedOperator = random.nextInt(GUESSES_OPERATORS_COUNT);
            System.out.println("Question: "
                    + guessedNumber1
                    + " " + (guessedOperator == 0 ? "-" : "+") + " "
                    + guessedNumber2);
            System.out.print("Your answer: ");
            answer = scanner.next();
            rightAnswer = getRightAnswer(guessedNumber1, guessedNumber2, guessedOperator);
            isRightAnswer = checkAnswer(Integer.parseInt(answer), rightAnswer);
            System.out.println(dialogSupporter(answer, String.valueOf(rightAnswer), isRightAnswer));
            if (!isRightAnswer) {
                break;
            }
        }

        return isRightAnswer;
    }

    private static int getRightAnswer(int guessedNumber1, int guessedNumber2, int guessedOperator) {
        return guessedOperator == 0 ? guessedNumber1 - guessedNumber2 : guessedNumber1 + guessedNumber2;
    }

    private static boolean checkAnswer(int answer, int rightAnswer) {
        return rightAnswer == answer;
    }

    private static String dialogSupporter(String answer, String rightAnswer, boolean isRightAnswer) {
        return isRightAnswer
                ? "Correct!"
                : "'" + answer + "' is wrong answer ;(. Correct answer was '" + rightAnswer + "'.\n"
                + "Let's try again, " + Cli.getUsername() + "!";
    }
}
