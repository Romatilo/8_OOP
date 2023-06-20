package seminar6.calc;

public class DivisionOperation implements I_CalcOperation {
    @Override
    public double performOperation(double number1, double number2){
        if (number2 == 0) {
            throw new ArithmeticException("На ноль делить низзя!");
        }
        return number1/number2;
    }
}
