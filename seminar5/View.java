package seminar5;

import java.util.Scanner;

public class View {
    Scanner inNumber = new Scanner(System.in);
    Scanner inOperator = new Scanner(System.in);
    public double getValue(String title) {
        System.out.printf("%s", title);
        return inNumber.nextDouble();
    }

    public String getOperator(String title){
        System.out.printf("%s", title);
        return inOperator.next();
        }


    // print(f'{title} = {data}')
    public void showResult(double data, String title) {
        System.out.printf("%s %f\n", title, data);
    }
}
