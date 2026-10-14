import java.util.Arrays;
import java.util.Scanner;
public class Game {
    private int attemptsLimit;
    private char[] wordToGuess;

    Game() {
        attemptsLimit = 7;
        wordToGuess = Words.getRandomWord().toCharArray();
    }

    private String getGuessedCharsInStr(char[] guessedChars) {
        String guessedCharsInStr = new String(guessedChars);
        return guessedCharsInStr;
    }

    public void playGame(){
        char[] guessedChars = new char[this.wordToGuess.length];
        Scanner scanner = new Scanner(System.in);
        int attemptsLeft = this.attemptsLimit;

        Arrays.fill(guessedChars, '_');

        //System.out.println(getGuessedCharsInStr(guessedChars));
        //System.out.println(Arrays.toString(wordToGuess));

        while (attemptsLeft != 0) {
            System.out.print("Выберите букву алфавита: ");
            scanner.next().toString();
        }
    }
}
