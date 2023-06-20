package seminar6.calc;

/// Здесь наглядно применен принцип инверсии зависимостей. Класс калькулятора
/// не соединяется с инструментами вычислений (операциями сложения, вычитания и т.д.).
// Вместо этого он соединён с интерфейсами, которые помогают установить связь между инструментом и классом.

public class Calculator {
    private I_UserInterface userInterface;

    public Calculator(I_UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    public void run() {
        try {
            double number1 = userInterface.getNumber();
            I_CalcOperation operation = userInterface.getOperation();
            double number2 = userInterface.getNumber();

            double result = operation.performOperation(number1, number2);
            userInterface.displayResult(result);
        } catch (Exception e) {
            userInterface.displayError(e.getMessage());
        }
    }
}
