import java.util.Arrays;
import java.util.Scanner;
public class Hangman {
    private static int attemptsLimit = 7;

    private String getGuessedCharsInStr(char[] guessedChars) {
        String guessedCharsInStr = new String(guessedChars);
        return guessedCharsInStr;
    }

    public void playHangman(){
        char[] wordToGuess = HangmanWords.getRandomWord().toCharArray();
        char[] guessedChars = new char[wordToGuess.length];
        Scanner in = new Scanner(System.in);
        int attemptsLeft = attemptsLimit;

        Arrays.fill(guessedChars, '_');

        //System.out.println(getGuessedCharsInStr(guessedChars));
        //System.out.println(Arrays.toString(wordToGuess));

        while (attemptsLeft != 0) {
            System.out.print("Выберите букву алфавита: ");
            in.next().toString();
        }
    }
}
