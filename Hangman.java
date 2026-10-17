import java.util.Scanner;
public class Hangman {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        UserInterface userInterface = new UserInterface(scanner);
        int workMode = 1;

        userInterface.resetKeyboard();
        while (workMode != 0) {
            System.out.println("Выберите режим работы: [1] - Игра, [0] - Выход");
            System.out.print("Ваш выбор: ");

            workMode = userInterface.getWorkMode();

            if (workMode == 1) {
                Game game = new Game();
                game.playGame(userInterface);
            } else if (workMode != 0 && workMode != 1) {
                System.out.println("Упс, такого режима работы нет... Попробуйте еще раз.");
            }
        } ;
    }
}
