import java.util.Scanner;
public class Main {
    private static final int START = 1;
    private static final int QUIT = 0;
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        UserInterface userInterface = new UserInterface(scanner);

        int workMode = 1;

        userInterface.resetKeyboard();
        while (true) {
            System.out.printf("Выберите режим работы: [%d] - Игра, [%d] - Выход", START, QUIT);
            System.out.print("Ваш выбор: ");

            workMode = userInterface.getWorkMode();

            if (workMode == START) {
                Game game = new Game();
                game.playGame(userInterface);
            } else if (workMode == QUIT) {
                return;
            } else {
                System.out.println("Упс, такого режима работы нет... Попробуйте еще раз.");
            }
        }
    }
}
