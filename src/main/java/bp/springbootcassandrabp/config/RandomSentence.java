package bp.springbootcassandrabp.config;

import java.util.Random;


public class RandomSentence {


    public static String generateRandomWord(int wordLength) {
        Random r = new Random(); // Intialize a Random Number Generator with SysTime as the seed
        StringBuilder sb = new StringBuilder(wordLength);
        for(int i = 0; i < wordLength; i++) { // For each letter in the word
            char tmp = (char) ('a' + r.nextInt('z' - 'a')); // Generate a letter between a and z
            sb.append(tmp); // Add it to the String
        }
        return sb.toString();
    }

    public static String generateSentence(int wordAmount){
        String veta = "";
        for (int i = 0; i < wordAmount; i++) {
            veta +=generateRandomWord(5);
            veta+=" ";

        }
        return veta;
    }
}
