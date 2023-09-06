package Lesson5.task2;

public class Triangle implements Shape{
    String fillColor;
    String borderColor;
    double a;
    double b;
    double c;
    double perimeter;
    double area;

    public Triangle(double a, double b, double c, String fillColor, String borderColor) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.borderColor = borderColor;
        this.fillColor = fillColor;
        this.perimeter = perimeter(a, b, c);
        this.area = area(a, b, c);
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
        System.out.println("Параметры треугольника: " +
                "цвет заливки = " + fillColor +
                ", цвет границы = " + borderColor +
                ", сторона a = " + a +
                ", сторона b = " + b +
                ", сторона c = " + c +
                ", периметр = " + perimeter +
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
