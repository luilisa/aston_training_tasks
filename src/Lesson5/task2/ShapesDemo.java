package Lesson5.task2;

public class ShapesDemo {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(20, 10, "белый", "голубой");
        rectangle.getShapeInfo();

        rectangle.setFillColor("зеленый");
        System.out.println("Цвет заливки: " + rectangle.getFillColor());

        Triangle triangle = new Triangle(20, 20, 10, "красный", "синий");
        triangle.getShapeInfo();

        Circle circle = new Circle(10, "белый", "черный");
        circle.getShapeInfo();
        circle.setBorderColor("зеленый");
        System.out.println("Цвет границы: " + circle.getBorderColor());

    }
}
