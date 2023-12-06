package hexlet.code;

import java.util.Scanner;

public class Cli {
    private static String username;

    public static String getUsername() {
        return username;
    }

    public static void welcome() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        username = scanner.next();
        System.out.println("Hello, " + username + "!");
    }

}
