package Lesson2;

public class LessonTwo {

    static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    static void checkSumSign() {
        int a = -5;
        int b = 5;
        int sum = a + b;
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        }
        else {
            System.out.println("Сумма отрицательная");
        }
    }

    static void printColor() {
        int value = 106;
        if (value <= 0) {
            System.out.println("Красный");
        }
        else if ((value > 0) && (value <= 100)) {
            System.out.println("Желтый");
        }
        else  {
            System.out.println("Зеленый");
        }
    }

    static void compareNumbers() {
        int a = 2;
        int b = 2;
        if (a >= b) {
            System.out.println("a >= b");
        }
        else {
            System.out.println("a < b");
        }
    }

    public static void main(String[] args) {
        LessonTwo.printThreeWords();
        LessonTwo.checkSumSign();
        LessonTwo.printColor();
        LessonTwo.compareNumbers();
    }
}
