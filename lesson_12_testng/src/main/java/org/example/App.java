package org.example;

public class App 
{
    public static int factorial(int digit) {
        if (digit < 0) {
            return -1;
        }
        if (digit == 1 || digit == 0) {
            return 1;
        }
        return factorial(digit - 1) * digit;
    }

    public static void main( String[] args )
    {
        System.out.println( factorial(4) );
    }
}
