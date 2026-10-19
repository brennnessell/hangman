import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;

import static java.nio.file.Files.readAllLines;

public class BankOfWords {
    private static final String WORDS_FILE_PATH = "bankOfWords.txt";

    public static String getRandomWord() {
        Path bankOfWordsFilePath = Path.of(WORDS_FILE_PATH);
        List<String> bankOfWords;
        Random random = new Random();
        String word = "";

        try {
            bankOfWords = readAllLines(bankOfWordsFilePath);
        } catch (IOException e) {
            throw new IllegalStateException("Во время открытия файла с банком слов произошла ошибка: %s".formatted(e.toString()));
        }

        if (!bankOfWords.isEmpty()) {
            int randomIndex = random.nextInt(bankOfWords.size());
            word = bankOfWords.get(randomIndex);
        } else {
            System.out.println("Файл %s не содержит слов!".formatted(WORDS_FILE_PATH));
        }

        return word;
    }
}
