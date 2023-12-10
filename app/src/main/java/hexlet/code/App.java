package hexlet.code;

import hexlet.code.games.CalcGame;
import hexlet.code.games.EvenGame;
import hexlet.code.games.GCDGame;
import hexlet.code.games.PrimeGame;
import hexlet.code.games.ProgressionGame;

import java.util.Scanner;

public class App {
    private static final int GREET_NUMBER = 1;
    private static final int EVEN_GAME_NUMBER = 2;
    private static final int CALC_GAME_NUMBER = 3;
    private static final int GCD_GAME_NUMBER = 4;
    private static final int PROGRESSION_GAME_NUMBER = 5;
    private static final int PRIME_GAME_NUMBER = 6;
    private static final String MENU = """
                1 - Greet
                2 - Even
                3 - Calc
                4 - GCD
                5 - Progression
                6 - Prime
                0 - Exit""";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choosenMenuItem;

        System.out.println("Please enter the game number and press Enter.");
        System.out.println(MENU);
        System.out.print("Your choice: ");

        choosenMenuItem = scanner.nextInt();
        switch (choosenMenuItem) {
            case GREET_NUMBER:
                Cli.welcome();
                break;
            case EVEN_GAME_NUMBER:
                Engine.runGame(new EvenGame());
                break;
            case CALC_GAME_NUMBER:
                Engine.runGame(new CalcGame());
                break;
            case GCD_GAME_NUMBER:
                Engine.runGame(new GCDGame());
                break;
            case PROGRESSION_GAME_NUMBER:
                Engine.runGame(new ProgressionGame());
                break;
            case PRIME_GAME_NUMBER:
                Engine.runGame(new PrimeGame());
            default:
                break;
        }

    }
}
