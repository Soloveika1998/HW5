import java.util.Scanner;

public class ConsoleView implements UserView {
    Scanner in;
    public ConsoleView() {
        in = new Scanner(System.in);
    }
    @Override
    public String getLogin() {
        System.out.printf("Login: ");
        return in.nextLine();
    }

    @Override
    public void setLogin(String value) {
        System.out.printf("Login: %s\n", value);
    }

    @Override
    public String getEmail() {
        System.out.printf("Email: ");
        return in.nextLine();
    }

    @Override
    public void setEmail(String value) {
        System.out.printf("Email: %s\n", value);
    }

    @Override
    public String getPassword() {
        System.out.printf("Password: ");
        return in.nextLine();
    }

    @Override
    public void setPassword(String value) {
        System.out.printf("Password: %s\n", value);        
    }
    
}
