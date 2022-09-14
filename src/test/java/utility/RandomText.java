package utility;

import java.util.Random;

public class RandomText {

     public String getRandomGmail (int length) {

        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        Random randomEmail = new Random();

        for (int i = 0; i < length; i++) {
            int index = randomEmail.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(index);
            sb.append(randomChar);
        }
        return sb +"@gmail.com";

    }

    public StringBuilder getRandomText (int length) {

        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        Random randomPass = new Random();

        for (int i = 0; i < length; i++) {
            int index = randomPass.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(index);
            sb.append(randomChar);
        }
        return sb;


    }
}