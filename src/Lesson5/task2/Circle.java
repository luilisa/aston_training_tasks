package Lesson5.task2;

public class Circle implements Shape{
    String fillColor;
    String borderColor;
    double radius;
    double perimeter;
    double area;

    public Circle(double radius, String fillColor, String borderColor) {
        this.radius = radius;
        this.borderColor = borderColor;
        this.fillColor = fillColor;
        this.perimeter = perimeter(radius);
        this.area = area(radius);
    }

    @Override
    public void setFillColor(String color) {
        this.fillColor = color;

    }

    @Override
    public void setBorderColor(String color) {
        this.borderColor = color;
    }

    @Override
    public void getShapeInfo() {
        System.out.println("Параметры круга: " +
                "цвет заливки = " + fillColor +
                ", цвет границы = " + borderColor +
                ", радиус = " + radius +
                ", длина окружности = " + perimeter +
                ", площадь = " + area);
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}
