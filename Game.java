import java.util.Arrays;

public class Game {
    private String secretWord;
    private String gameState;

    private static final String GAME_IN_PROCESS = "GAME_IN_PROCESS";
    private static final String GAME_IS_WON = "GAME_IS_WON";
    private static final String GAME_IS_LOST = "GAME_IS_LOST";

    private static final int ERRORS_LIMIT = 7;

    Game() {
        gameState = GAME_IN_PROCESS;
        secretWord = BankOfWords.getRandomWord();
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
        String[] maskedWord = new String[secretWord.length()];
        Arrays.fill(maskedWord, "_");
        int errorsCount = 0;

        while (gameState.equals(GAME_IN_PROCESS)) {
            userInterface.drawHangman(errorsCount);
            System.out.println("Слово: " + convertMaskedWordToStr(maskedWord));

            String currentLetter = userInterface.getUserLetter();

            if (secretWord.contains(currentLetter)) {
                System.out.println(">>> Молодец! Такая буква есть!");
                openGuessedLetters(secretWord, currentLetter, maskedWord);
                if (convertMaskedWordToStr(maskedWord).equals(secretWord)) {
                    gameState = GAME_IS_WON;
                }
            } else {
                System.out.println(">>> Увы, такой буквы нет...");
                errorsCount += 1;

                if (errorsCount == ERRORS_LIMIT) {
                    gameState = GAME_IS_LOST;
                    userInterface.drawHangman(errorsCount);
                }
            }
        }

        if (gameState.equals(GAME_IS_WON)) {
            System.out.println("Ты победил, чемпион! Хочешь еще?");
        } else {
            System.out.println("Ничего, в другой раз повезет... Хочешь еще?");
            System.out.println("Загаданное слово: " + secretWord);
        }
    }
}
