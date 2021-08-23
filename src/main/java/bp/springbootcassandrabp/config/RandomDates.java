package bp.springbootcassandrabp.config;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class RandomDates {

    public static int createRandomIntBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

    public static String createRandomDate(int startYear, int endYear) {
        int day = createRandomIntBetween(1, 28);
        int month = createRandomIntBetween(1, 12);
        int year = createRandomIntBetween(startYear, endYear);
        LocalDate date = LocalDate.of(year, month, day);
        String formattedDate = date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        return formattedDate;
    }

    public static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}