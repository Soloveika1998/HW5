import java.util.Scanner;

public class App {
    public static void ButtonClick() {
        NewConsoleView view = new NewConsoleView();
        UserPresenter presenter = new UserPresenter(view, "data.txt");
        presenter.LoadFromFile();

        try (Scanner in = new Scanner(System.in)) {

            while (true) {
                System.out.println(" 1 - add  2 - remove  3 - load from file  4 - save to file ");
                String key = in.next();
                System.out.print("\033[H\033[J");
                switch (key) {
                    case "1":
                        presenter.add();
                        break;
                    case "2":
                        presenter.remove();
                        break;
                    case "3":
                        presenter.LoadFromFile();
                        break;
                    case "4":
                        presenter.saveToFile();
                        break;

                    default:
                        System.out.println("Такой команды нет");
                        break;
                }
            }
        }

    }
}
