import java.util.Arrays;
public class Game {
    private final String wordToGuess;
    private String gameState;

    private static final String GAME_IN_PROCESS = "GAME_IN_PROCESS";
    private static final String GAME_IS_WON = "GAME_IS_WON";
    private static final String GAME_IS_LOST = "GAME_IS_LOST";

    private static final int ATTEMPTS_LIMIT = 7;


    Game() {
        wordToGuess = Words.getRandomWord();
        gameState = GAME_IN_PROCESS;
    }

    private static void openGuessedLetters(String originWord, String letter, String[] demaskingWord) {
        for (int i = 0; i < originWord.length(); i++) {
            if (String.valueOf(originWord.charAt(i)).equals(letter)) {
                demaskingWord[i] = letter;
            }
        }
    }

    private String convertMaskedWordToStr(String[] maskedWord) {
        return String.join("", maskedWord);
    }

    public void playGame(UserInterface userInterface){
        String[] maskedWord = new String[wordToGuess.length()];
        Arrays.fill(maskedWord, "_");
        int attemptsLeft = ATTEMPTS_LIMIT;

        while (gameState.equals(GAME_IN_PROCESS)) {
            userInterface.drawHangman(attemptsLeft);
            System.out.println("Слово: " + convertMaskedWordToStr(maskedWord));

            String currentLetter = userInterface.getUserLetter();

            if (wordToGuess.contains(currentLetter)) {
                System.out.println("Молодец! Такая буква есть!");
                openGuessedLetters(wordToGuess, currentLetter, maskedWord);
                if (convertMaskedWordToStr(maskedWord).equals(wordToGuess)) {
                    gameState = GAME_IS_WON;
                }
            } else {
                System.out.println("Увы, такой буквы нет...");
                attemptsLeft -= 1;

                if (attemptsLeft == 0) {
                    gameState = GAME_IS_LOST;
                    userInterface.drawHangman(attemptsLeft);
                }
            }
        }

        if (gameState.equals(GAME_IS_WON)) {
            System.out.println("Ты победил, чемпион! Хочешь еще?");
        } else {
            System.out.println("Ничего, в другой раз повезет... Хочешь еще?");
            System.out.println("Загаданное слово: " + wordToGuess);
        }
    }
}
