package seminar6.calc;

/// Применен приницп разделения интерфейсов. Данный интерфейс отвечает за выполнение операций калькулятора

import java.util.Scanner;

public class ConsoleUserInterface implements I_UserInterface {
    private Scanner scanner;

    public ConsoleUserInterface() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void displayResult(double result) {
        System.out.println("Результат: " + result);
    }

    @Override
    public void displayError(String message) {
        System.out.println("Ошибка: " + message);
    }

    @Override
    public double getNumber() {
        System.out.print("Введите число: ");
        return scanner.nextDouble();
    }

    @Override
    public I_CalcOperation getOperation() {
        System.out.print("Введите операцию (+ - * /): ");
        String operation = scanner.next();

        switch (operation) {
            case "+":
                return new AdditionOperation();
            case "-":
                return new SubtractionOperation();
            case "*":
                return new MultiplicationOperation();
            case "/":
                return new DivisionOperation();
            default:
                throw new IllegalArgumentException("Неприемлемая операция: " + operation);
        }
    }
}
