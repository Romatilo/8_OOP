package seminar1.task1;

import seminar1.task1.objects.Cat;

public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();

        cat1.setName("Том");
        cat1.setAge(2);
        cat1.setNameOwner("Карабас-Барабас");
        cat1.greet();

        cat2.setName("Бурбон");
        cat2.setAge(5);
        cat2.setNameOwner("Манджафоко");
        cat2.greet();
    }
}