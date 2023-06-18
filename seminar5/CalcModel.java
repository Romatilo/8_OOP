package seminar5;

public class CalcModel implements Model {
    private double a;
    private double b;
    private String operator;

    @Override
    public void setA(double a) {
        this.a = a;
    }

    @Override
    public void setB(double b) {
        this.b = b;
    }

    @Override
    public void setOperator(String operator) {
        this.operator = operator;
    }
    @Override
    public double calculate() {
        double result = 0.0;
        switch(operator) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/" :
                if (b == 0) throw new ArithmeticException("На ноль делить низзя!");
                result = a / b;
                break;
        }
        return result;
    }
}
