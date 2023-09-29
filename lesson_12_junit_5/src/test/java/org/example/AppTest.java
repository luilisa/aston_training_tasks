package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest 
{
    @DisplayName("Проверка 0 и 1. Ожидаемое значение = 1")
    @Test
    public void factorialZeroOneTest()
    {
        assertEquals(App.factorial(0), 1);
        assertEquals(App.factorial(1), 1);
    }

    @DisplayName("Проверка 4. Ожидаемое значение = 24")
    @Test
    public void factorialFourTest()
    {
        assertEquals(App.factorial(4), 24);
    }

    @DisplayName("Проверка отрицательного числа. Ожидаемое значение = -1")
    @Test
    public void factorialNegativeNumberTest()
    {
        assertEquals(App.factorial(-5), -1);
    }
}
