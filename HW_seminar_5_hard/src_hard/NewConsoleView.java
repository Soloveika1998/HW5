public class NewConsoleView extends ConsoleView {
    
    public NewConsoleView() {
        super();
    }

    @Override
    public void setEmail(String value) {
        super.setEmail(value);
        System.out.println();
    }

}