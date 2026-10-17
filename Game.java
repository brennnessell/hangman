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

    private void drawHangman(int attemptsLeft) {
        String draw = new String();
        switch (attemptsLeft) {
            case 7 -> draw = "       \n" +
                    "       \n" +
                    "       \n" +
                    "       \n" +
                    "       \n" +
                    "       \n" +
                    "       \n" +
                    "=======";
            case 6 -> draw = "  +---+\n" +
                    "  |   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=======";
            case 5 -> draw = "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=======";
            case 4 -> draw = "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    "  |   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=======";
            case 3 -> draw = "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=======";
            case 2 -> draw = "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=======";
            case 1 -> draw = "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    " /    |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=======";
            case 0 -> draw = "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    " / \\  |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=======";
        }
        System.out.println(draw);
    }

    private String convertMaskedWordToStr(String[] maskedWord) {
        return String.join("", maskedWord);
    }

    public void playGame(){
        String[] maskedWord = new String[wordToGuess.length()];
        Arrays.fill(maskedWord, "_");
        UserInterface userInterface = new UserInterface();
        int attemptsLeft = ATTEMPTS_LIMIT;

        while (gameState == GAME_IN_PROCESS) {
            drawHangman(attemptsLeft);
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
                    drawHangman(attemptsLeft);
                }
            }
        }

        if (gameState == GAME_IS_WON) {
            System.out.println("Ты победил, чемпион! Хочешь еще?");
        } else {
            System.out.println("Ничего, в другой раз повезет... Хочешь еще?");
            System.out.println("Загаданное слово: " + wordToGuess);
        }
    }
}
