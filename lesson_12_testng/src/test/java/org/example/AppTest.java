package org.example;


import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AppTest
{
    @Test
    public void factorialZeroOneTest()
    {
        assertEquals(App.factorial(0), 1);
        assertEquals(App.factorial(1), 1);
    }

    @Test
    public void factorialFourTest()
    {
        assertEquals(App.factorial(4), 24);
    }

    @Test
    public void factorialNegativeNumberTest()
    {
        assertEquals(App.factorial(-5), -1);
    }
}
