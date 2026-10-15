import java.util.Scanner;
public class UserInterface {
    private String keyboard;

    UserInterface(){
        keyboard = new String("АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ");
    }

    private void crossOutTheLetter(String letter) {
        keyboard.replace(letter, "");
    }

    private boolean checkIfLetterIsAvailable(String letter) {
        int letterIndex = keyboard.indexOf(letter);
        return letterIndex != -1;
    }

    public String getUserLetter() {
        String letter = new String();
        Scanner scanner = new Scanner(System.in);

        boolean letterIsGot = false;

        while (!letterIsGot) {
            System.out.print("Выберите букву: ");
            letter = scanner.next();
            if (!this.checkIfLetterIsAvailable(letter)) {
                System.out.println("Упс, такая буква уже была использована, либо введенный символ не является буквой. Попробуйте еще раз!");
                continue;
            } else {
                letterIsGot = true;
            }
        }

        this.crossOutTheLetter(letter);
        return letter;
    }
}
