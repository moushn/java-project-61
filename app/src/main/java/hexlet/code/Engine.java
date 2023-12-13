package hexlet.code;

import hexlet.code.games.Game;
import hexlet.code.games.RoundData;

import java.util.Scanner;

public class Engine {
    private static final int ROUND_COUNT = 3;

    public static void runGame(Game game) {
        String answer;
        boolean result;
        RoundData roundData;
        Scanner scanner = new Scanner(System.in);

        String username = welcome();
        System.out.println(game.getRule());
        for (int i = 0; i < ROUND_COUNT; i += 1) {
            roundData = game.generateRound();
            System.out.println("Question: " + roundData.question());
            System.out.print("Your answer: ");
            answer = scanner.next();
            result = checkAnswer(answer, roundData.rightAnswer());
            System.out.println(dialogSupporter(answer, roundData.rightAnswer(), result, username, i));
            if (!result) {
                break;
            }
        }
    }

    private static String welcome() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String username = scanner.next();
        System.out.println("Hello, " + username + "!");
        return username;
    }

    private static String dialogSupporter(String answer,
                                          String rightAnswer,
                                          boolean isRightAnswer,
                                          String username,
                                          int step) {
        String resultCheckInfo = isRightAnswer
                ? "Correct!"
                : "'" + answer + "' is wrong answer ;(. Correct answer was '"
                + rightAnswer + "'.\n"
                + "Let's try again, " + username + "!";
        if (isRightAnswer && step == ROUND_COUNT - 1) {
            resultCheckInfo += "\nCongratulations, " + username + "!";
        }
        return resultCheckInfo;
    }

    private static boolean checkAnswer(String answer, String rightAnswer) {
        return rightAnswer.equals(answer);
    }
}
