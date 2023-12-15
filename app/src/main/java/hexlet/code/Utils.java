package hexlet.code;

import java.util.Random;

public class Utils {
    public static int getRandomNumber(int lowerLimit, int upperLimit) {
        Random random = new Random();
        return lowerLimit + random.nextInt(upperLimit - lowerLimit + 1);
    }

    public static int getRandomNumber(int upperLimit) {
        return getRandomNumber(0, upperLimit);
    }
}
