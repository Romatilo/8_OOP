/*
Напишите обобщенный метод printArray, который принимает массив любого типа и выводит его элементы на консоль.

В этом примере мы объявляем обобщенный метод printArray, который принимает массив типа T.
Затем мы используем цикл for-each, чтобы пройти по всем элементам массива и вывести их на консоль.
В методе main мы создаем массивы типов Integer и String и вызываем printArray для каждого из них.
В результате мы получаем вывод на консоль элементов каждого массива.

Таким образом, обобщенные методы позволяют нам создавать код, который может работать с разными типами данных,
обеспечивая повторное использование и гибкость.

 */

package seminar4.task2;

public class Main {
        public static <T> void printArray(T[] array) {
            for (T element : array) {
                System.out.println(element);
            }
        }

        public static void main(String[] args) {
            Integer[] intArray = {5, 4, 3, 2, 1, 0};
            String[] stringArray = {"Missile", "is", "launched"};

            printArray(intArray);
            printArray(stringArray);
        }
}
