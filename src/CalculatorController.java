public class CalculatorController {
    
    private CalculatorModel model;
    private CalculatorView view;

    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;
    }

    public void calculate(double num1, double num2, char operator) {
        double result;
        try {
            switch (operator) {
                case '+':
                    result = model.sum(num1, num2);
                    break;
                case '-':
                    result = model.subtract(num1, num2);
                    break;
                case '*':
                    result = model.multiply(num1, num2);
                    break;
                case '/':
                    result = model.divide(num1, num2);
                    break;
                default:
                    view.printError("Неверная операция");
                    return;
            }
            view.printResult(result);
        } catch (ArithmeticException e) {
        view.printError(e.getMessage());
        }   
    }
}
