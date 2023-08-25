package Lesson3;

import java.util.Arrays;

public class LessonThree {

    //задача 1
    public static boolean checkSum(int a, int b) {
        return (a + b >= 10) && (a + b <= 20);
    }

    //задача 2
    public static void positiveOrNegative(int num) {
        if (num >= 0) {
            System.out.println("Положительное");
        }
        else {
            System.out.println("Отрицательное");
        }
    }

    //задача 3
    public static boolean positiveOrNegativeBoolean(int num) {
        return num < 0;
    }

    //задача 4
    public static void typeString(String s, int n) {
        for (int i = 0; i < n; i ++) {
            System.out.println(s);
        }
    }

    //задача 5
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0) && !(year % 100 == 0) || year % 400 == 0;
    }

    //задача 6
    public static int[] replaceInArray() {
        int[] array = { 1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < array.length; i ++) {
            if (array[i] == 1) {
                array[i] = 0;
            }
            else {
                array[i] = 1;
            }
        }
        return array;
    }

    //задача 7
    public static int[] fillArray() {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        return array;
    }

    //задача 8
    public static int[] multiplyTwo() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] = array[i]*2;
            }
        }
        return array;
    }
    //задача 9
    public static void diagonal(int n) {
        int[][] table = new int[n][n];

        for (int i = 0; i < table.length; i ++) {

            table[i][table.length - i - 1] = 1;

            table[i][i] = 1;

            System.out.println(Arrays.toString(table[i]));
        }

    }

    //задача 10
    public static int[] initArray(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < len; i ++) {
            array[i] = initialValue;
        }
        return array;
    }


    public static void main(String[] args) {
        //Вывод для первой задачи
        System.out.println(LessonThree.checkSum(10, 0));

        //Вывод для второй задачи
        LessonThree.positiveOrNegative(1);

        //Вывод для третьей задачи
        System.out.println(LessonThree.positiveOrNegativeBoolean(0));

        // 4 задача
        LessonThree.typeString("Hello, world", 2);

        //5 задача
        System.out.println(LessonThree.isLeapYear(2000));

        //6 задача
        System.out.println(Arrays.toString(LessonThree.replaceInArray()));

        //7 задача
        System.out.println(Arrays.toString(LessonThree.fillArray()));

        // 8 задача
        System.out.println(Arrays.toString(LessonThree.multiplyTwo()));

        // 9 задача
        LessonThree.diagonal(6);

        // 10 задача
        System.out.println(Arrays.toString(LessonThree.initArray(3, 0)));
    }
}
