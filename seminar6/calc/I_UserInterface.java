package seminar6.calc;

/// Применен принцип разделения интерфейсов. Данный интерфейс отвечает за взаимодействие с пользователем
// и отображение информации на экране

public interface I_UserInterface {
    void displayResult(double result);
    void displayError(String message);
    double getNumber();
    I_CalcOperation getOperation();
}
