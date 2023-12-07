package hexlet.code;

import hexlet.code.games.CalcGame;
import hexlet.code.games.EvenGame;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choosenMenuItem;

        System.out.println("Please enter the game number and press Enter.");
        System.out.println("""
                1 - Greet
                2 - Even
                3 - Calc
                0 - Exit""");
        System.out.print("Your choice: ");

        choosenMenuItem = scanner.nextInt();
        switch (choosenMenuItem) {
            case 1:
                Cli.welcome();
                break;
            case 2:
                Engine.runGame(new EvenGame());
                break;
            case 3:
                Engine.runGame(new CalcGame());
            default:
                break;
        }

    }
}
