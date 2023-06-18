/*
Конструируем калькулятор, применяя архитектуру MVP (Model-View-Presenter), с возможностью выполнения базовых математических операций, 
таких как сложение, вычитание, умножение и деление, работающий с дробными числами.
Доп. Задача (*) Мы также обеспечим обработку возможных ошибок, чтобы предотвратить некорректные операции.

*/

package seminar5;

public class Main {
    public static void main(String[] args) throws Exception {
        Presenter p = new Presenter(new View(), new CalcModel());
        p.buttonClick();
    }
}
