import java.util.Scanner;
import java.util.InputMismatchException;
public class Hangman {
    public static void main(String args[]){
        int workMode = 1;
        Scanner scanner = new Scanner(System.in);

        while (workMode != 0) {
            System.out.println("Выберите режим работы: [1] - Игра, [0] - Выход");
            System.out.print("Ваш выбор: ");
            try {
                workMode = scanner.nextInt();

                if (workMode != 0 && workMode != 1) {
                    System.out.println("Упс, такого режима работы нет... Попробуйте еще раз.");
                } else {
                    Game game = new Game();
                    game.playGame();
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Введено некорректное значение для выбора режима работы! Попробуйте еще раз.");
                scanner.next();
            }
        } ;
    }
}
