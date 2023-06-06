package seminar1.task1.objects;

public class Cat {

    private static String name;

    private static int age;

    private static String nameOwner;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNameOwner() {
        return Owner.name;
    }

    /*
        Через этот сеттер присваиваем значение полю name класса Owner.
        И то же самое значение полю nameOwner данного класса (Cat)
     */
    public void setNameOwner(String name) {
        Owner.name = name;
        this.nameOwner = Owner.name;
    }

    public static void greet(){
        System.out.printf("Мяу! Меня зовут %s. Мне %s года(лет). Мой владелец - %s\n", name, age,nameOwner);
    }

}
