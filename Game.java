import java.util.Arrays;
public class Game {
    private int attemptsLeft;
    private final String wordToGuess;

    Game() {
        attemptsLeft = 7;
        wordToGuess = Words.getRandomWord();
    }

    private static void openGuessedLetters(String originWord, String letter, String[] demaskingWord) {
        for (int i = 1; i < originWord.length(); i++) {
            if (String.valueOf(originWord.charAt(i)).equals(letter)) {
                demaskingWord[i] = letter;
            }
        }
    }

    public boolean playGame(){
        String[] maskedWord = new String[wordToGuess.length()];
        Arrays.fill(maskedWord, "_");
        UserInterface userInterface = new UserInterface();

        while (attemptsLeft != 0) {
            String currentLetter = userInterface.getUserLetter().toUpperCase();

            if (!wordToGuess.contains(currentLetter)) {
                openGuessedLetters(wordToGuess, currentLetter, maskedWord);
                if (String.join("", maskedWord).equals(wordToGuess)) {
                    return true;
                }
            } else {
                attemptsLeft -= 1;
            }
        }

        return false;
    }
}
