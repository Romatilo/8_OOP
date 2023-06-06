package seminar1.task2;


public class Main {
    public static void main(String[] args) {
        Rectangle rectangle1 = new Rectangle();
        System.out.println(Rectangle.calculateRectangleArea(rectangle1));
        rectangle1.setWidth(50);
        rectangle1.setHeight(150);
        System.out.println(Rectangle.calculateRectangleArea(rectangle1));

        Rectangle rectangle2 = new Rectangle(20,50);
        System.out.println(Rectangle.calculateRectangleArea(rectangle2));
    }
}
