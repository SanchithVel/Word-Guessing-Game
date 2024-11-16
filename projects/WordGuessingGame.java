package projects;

import java.util.Random;
import java.util.ArrayList;

public class WordGuessingGame {

    static String[] wordsToGuess = {"hello", "cake", "Food", "dog", "tree", "Cats", "brief", "dream", "roOm", "bottle"};
    static int attempts = 0;
    
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<String> guessedLetters = new ArrayList<>();

        String randomWord = wordsToGuess[random.nextInt(wordsToGuess.length)].toLowerCase();

        StringBuilder displayWord = new StringBuilder();
        for (int i = 0; i < randomWord.length(); i++) {
            displayWord.append("_ ");
        }
        System.out.println(displayWord);

        while (attempts < 10 && displayWord.toString().contains("_ ")) {
            System.out.print("Guess a letter: ");
            char guess;
            String input = new java.util.Scanner(System.in).nextLine();
            
            if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                System.out.println("Invalid input! Enter alphabetical letter.");
                continue;
            } 
            
            if (guessedLetters.contains(input.toLowerCase())) {
                System.out.println("Letter was already guessed. Try again");
                continue;
            }
            	
            guess = input.charAt(0);
            guessedLetters.add(String.valueOf(guess).toLowerCase());
            
            // checking if guess is in the word
            boolean found = false;
            for (int i = 0; i < randomWord.length(); i++) {
                if (randomWord.charAt(i) == Character.toLowerCase(guess)) {
                	
                    displayWord.setCharAt(i * 2, Character.toLowerCase(guess)); // skip spaces by *2
                    found = true;
                }
            }
            System.out.println(displayWord);

            if (!found) {
                System.out.println("Try again");
            } 
            attempts++;
            System.out.println("Attempts remaining: " + (10 - attempts));
        }

        if (displayWord.toString().replace(" ", "").equals(randomWord)) {
            System.out.println("You won!");
        } else {
            System.out.println("Attempts gone. You lost. The word was: " + randomWord);
        }
    }
}