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

        String username = greet();
        System.out.println(game.getRule());
        for (int i = 0; i < ROUND_COUNT; i += 1) {
            roundData = game.generateRound();
            System.out.println("Question: " + roundData.question());
            System.out.print("Your answer: ");
            answer = scanner.next();
            result = roundData.rightAnswer().equals(answer);
            if (!result) {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '"
                        + roundData.rightAnswer() + "'.\n" + "Let's try again, " + username + "!");
                return;
            }
            System.out.println("Correct!");
        }
        System.out.println("Congratulations, " + username + "!");
    }

    private static String greet() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String username = scanner.next();
        System.out.println("Hello, " + username + "!");
        return username;
    }
}
