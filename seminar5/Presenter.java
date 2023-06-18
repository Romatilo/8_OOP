package seminar5;


public class Presenter {
    View view;
    Model model;

    public Presenter(View view, Model model) {
        this.view = view;
        this.model = model;
    }

    public void buttonClick() throws Exception {
        double a = view.getValue("Введите число a: ");
        double b = view.getValue("Введите число b: ");
        String operator = view.getOperator("Введите оператор (+ - * /): ");
        model.setA(a);
        model.setB(b);
        model.setOperator(operator);
        if(operator.matches("[^-+/*]") ) throw new Exception("То, что вы ввели не является оператором. До свидания!");
        double result = model.calculate();
        view.showResult(result, "Результат: ");
    }
}
