package hexlet.code;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choosenMenuItem;

        System.out.println("Please enter the game number and press Enter.");
        System.out.println("""
                1 - Greet
                2 - Even
                0 - Exit""");
        System.out.print("Your choice: ");

        choosenMenuItem = scanner.nextInt();
        switch (choosenMenuItem) {
            case 1:
                Cli.welcome();
                break;
            case 2:
                Cli.welcome();
                EvenGame.start();
                break;
            default:
                break;
        }

    }
}
