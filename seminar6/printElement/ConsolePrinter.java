package seminar6.printElement;

public class ConsolePrinter<T> implements I_Printable<T> {

    public void print(T element) {
        System.out.println(element);
    }
}

