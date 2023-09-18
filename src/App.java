public class App {
    public static void main(String[] args) throws Exception {
        CalculatorModel model = new CalculatorModel();
        CalculatorView view = new CalculatorView();
        CalculatorController controller = new CalculatorController(model, view);

        double num1 = 5;
        double num2 = 7;
        char operator = '+';

        controller.calculate(num1, num2, operator);
        }

}
