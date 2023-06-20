package seminar6.printElement;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        I_Printable<Integer> intPrinter = new ConsolePrinter<>();
        intPrinter.print(42);

        I_Printable<String> stringPrinter = new ConsolePrinter<>();
        stringPrinter.print("is answer to everything");

        I_Printable<Double> doublePrinter = new FilePrinter<>("seminar6/printElement/answer.txt");
        doublePrinter.print(3.1415926);
    }
}
