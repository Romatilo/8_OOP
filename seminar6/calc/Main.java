package seminar6.calc;

import seminar5.CalcModel;

public class Main {
    public static void main(String[] args) {
        I_UserInterface userInterface = (I_UserInterface) new ConsoleUserInterface();
        Calculator calculator = new Calculator(userInterface);
        calculator.run();
    }
}