import java.util.Scanner;
import java.util.InputMismatchException;
public class UserInterface {
    private String keyboard;
    private Scanner scanner;

    UserInterface(Scanner newScanner){
        scanner = newScanner;
    }

    public void resetKeyboard() {
        keyboard = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    }

    public String getUserLetter() {
        String letter = "";

        boolean letterIsGot = false;

        System.out.println("Доступные буквы: " + keyboard);
        while (!letterIsGot) {
            System.out.print("Выберите букву: ");
            letter = scanner.next().toUpperCase();

            if (letter.length() != 1) {
                System.out.println("Упс, введена строка, а не буква. Попробуйте еще раз!");
                continue;
            } else if (!keyboard.contains(letter)) {
                System.out.println("Упс, такая буква уже была использована, либо введенный символ не является буквой. Попробуйте еще раз!");
                continue;
            } else {
                letterIsGot = true;
            }
        }

        keyboard = keyboard.replace(letter, "");
        return letter;
    }

    public int getWorkMode() {
        int workMode;
        while (true) {
            try {
                workMode = scanner.nextInt();
                break;
            }
            catch (InputMismatchException e) {
                System.out.println("Введено некорректное значение для выбора режима работы! Попробуйте еще раз.");
                scanner.next();
            }
        }

        return workMode;
    }

    public void drawHangman(int attemptsLeft) {
        String draw = "";
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
}
