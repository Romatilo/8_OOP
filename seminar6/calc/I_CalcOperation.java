package seminar6.calc;

/// Здесь реализован принцип Liskov substitution - в интерфейсе есть метод, который отвечает за выполнение
// какой-то операции. Классы сложение, вычитание, умножение и деление реализуют этот интерфейс
// и предоставляют свою реализацию метода performOperation.
public interface I_CalcOperation {
        double performOperation(double number1, double number2);
}
