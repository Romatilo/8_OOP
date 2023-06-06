package seminar1.task2;

public class Rectangle {
    private static double width;
    private static double height;

    Rectangle(){
        width = 10;
        height = 20;
    }

    Rectangle(double w, double h){
        width = w;
        height = h;
    }

    public static double getWidth() {
        return width;
    }

    public static void setWidth(double width) {
        Rectangle.width = width;
    }

    public static double getHeight() {
        return height;
    }

    public static void setHeight(double height) {
        Rectangle.height = height;
    }

    public static double calculateRectangleArea(Rectangle rectangle) {
        double rectangleArea = width*height;
        return rectangleArea;
    }

    public double calculateRectanglePerimeter (Rectangle rectangle) {
        double rectanglePerimeter = 2*(width+height);
        return rectanglePerimeter;
    }
}
