package Lesson5.task2;

public interface Shape {

    void setFillColor(String color);
    void setBorderColor(String color);

    void getShapeInfo();

    String getFillColor();
    String getBorderColor();

    default double area(double... params) {
        double pl = 0;
        double p;
        switch(params.length) {
            //Если передан 1 параметр, то это радиус круга
            case 1: pl = Math.PI * params[0] * params[0];
            break;
            //Если передано 2 параметра, то это стороны прямоугольника
            case 2: pl = params[0] * params[1];
            break;
            //Если передано 3 параметра, то это стороны треугольника
            case 3: {
                p = perimeter(params)/2; // полупериметр
                pl = Math.sqrt(p*(p - params[0])*(p - params[1])*(p - params[2])); // формула Герона (по 3 сторонам)
                break;
            }
        }
        return pl;
    }

    default double perimeter(double... params) {
        double p = 0;
        switch (params.length) {
            case 1: p = 2 * Math.PI * params[0];
            break;
            case 2: p = (params[0] + params[1]) * 2;
            break;
            case 3: p = params[0] + params[1] + params[2];
            break;
        }
        return p;
    }
}
