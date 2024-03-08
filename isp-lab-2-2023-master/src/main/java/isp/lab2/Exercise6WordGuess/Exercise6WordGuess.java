package isp.lab2.Exercise6WordGuess;

import java.util.Random;
import java.util.Scanner;

public class Exercise6WordGuess {

    /**
     * This method will return the number of occurrences of a character in a word
     *
     * @param c
     * @param word
     * @return
     */
    public static int[] getOccurrencePositions(char c, char[] word) {
        int count = 0;

        for (char letter : word) {
            if (letter == c) {
                count++;
            }
        }

        int[] positions = new int[count];
        int index = 0;

        for (int i = 0; i < word.length; i++) {
            if (word[i] == c) {
                positions[index] = i;
                index++;
            }
        }
        return positions;
    }

    private static final String[] WORDS = {"apple", "banana", "cherry", "orange", "grape", "lemon"};


    public static void main(String[] args) {
        Random random = new Random();
        String word = WORDS[random.nextInt(WORDS.length)];
        boolean solved = false;
        Scanner scanner = new Scanner(System.in);

        int tries = 0;
        String guessedLetters = "";
        String guessedgoodLetters = "";
        boolean wordGuessed = false;

        scanner = new Scanner(System.in);

        while (!wordGuessed && tries < 30) {
            System.out.print("Guess a letter: ");
            char guess = scanner.next().charAt(0);

            if (word.indexOf(guess) != -1) {
                System.out.println("The letter '" + guess + "' is in the word.");
                int[] positions = getOccurrencePositions(guess, word.toCharArray());
                System.out.print("Position(s): ");
                for (int position : positions) {
                    System.out.print(position + " ");
                }
                System.out.println();

                guessedgoodLetters += guess;

                if (guessedgoodLetters.length() == word.length()) {
                    wordGuessed = true;
                }
            } else {
                System.out.println("The letter '" + guess + "' is not in the word.");
            }


            guessedLetters += guess;
            System.out.println("Guessed: " + guessedLetters);

            tries++;
        }

        if(wordGuessed)
            System.out.println("Congratulation! You guessed the word correctly:))");
        System.out.println("The word was: " + word);
        System.out.println("Number of tries: " + tries);
    }

}
