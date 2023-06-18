package seminar5;

public class Main {
    public static void main(String[] args) throws Exception {
        Presenter p = new Presenter(new View(), new CalcModel());
        p.buttonClick();
    }
}
