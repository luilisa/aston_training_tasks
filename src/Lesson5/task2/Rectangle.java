package Lesson5.task2;

public class Rectangle implements Shape{
    String fillColor;
    String borderColor;
    double width;
    double height;
    double perimeter;
    double area;

    public Rectangle(double width, double height, String fillColor, String borderColor) {
        this.width = width;
        this.height = height;
        this.borderColor = borderColor;
        this.fillColor = fillColor;
        this.perimeter = perimeter(width, height);
        this.area = area(width, height);
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
        System.out.println("Параметры прямоугольника: " +
                "цвет заливки = " + fillColor +
                ", цвет границы = " + borderColor +
                ", ширина = " + width +
                ", длина = " + height +
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
