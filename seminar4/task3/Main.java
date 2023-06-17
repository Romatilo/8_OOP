/*
Напишите обобщенную функцию getMax, которая принимает два параметра типа T и возвращает максимальное значение из них.

В этом примере мы объявляем обобщенную функцию getMax, которая принимает два параметра типа T,
ограниченных интерфейсом Comparable. Мы используем метод compareTo для сравнения значений
и возвращаем максимальное значение из двух.

В методе main мы вызываем getMax с разными типами данных: целое число (Integer), число с плавающей запятой (Double)
и строку (String). В результате мы получаем максимальные значения из каждой пары и выводим их на консоль.

Обобщения позволяют нам писать универсальный код, который может работать с разными типами данных,
сохраняя при этом безопасность типов.

 */

package seminar4.task3;

public class Main {
    public static <T extends Comparable<T>> T getMax(T a, T b) {
        if (a.compareTo(b) > 0) {
            return a;
        } else {
            return b;
        }
    }

    public static void main(String[] args) {
        Integer int1 = 33;
        Integer int2 = 42;
        Double double1 = 3.14;
        Double double2 = 1.81;
        String string1 = "max";
        String string2 = "min";

        System.out.println("Max integer: " + getMax(int1, int2));
        System.out.println("Max double: " + getMax(double1, double2));
        System.out.println("Max string: " + getMax(string1, string2));
    }
}
