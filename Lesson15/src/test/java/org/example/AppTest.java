package org.example;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest 
{
    static WebDriver driver;
    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void selectProductsTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.initElements();
        mainPage.addGood(0);
        mainPage.addGood(1);
        mainPage.addGood(2);
        List<String> goodNamesExpected = mainPage.getGoodNames().stream().map(WebElement -> WebElement.getText().substring(2)).collect(Collectors.toList());
        List<String> goodPricesExpected = mainPage.getGoodPrices().stream().map(WebElement::getText).collect(Collectors.toList());
        mainPage.openShoppingCart();

        ShoppingCart shoppingCart = new ShoppingCart(driver);
        List<String> goodNamesActual = shoppingCart.getGoodNames().stream().map(WebElement::getText).collect(Collectors.toList());
        List<String> goodPricesActual = shoppingCart.getGoodPrices().stream().map(WebElement::getText).collect(Collectors.toList());

        //сравнение наименований и цен, полученных на главной странице и в корзине
        assertEquals(goodNamesExpected, goodNamesActual);
        assertEquals(goodPricesExpected, goodPricesActual);

        //сравнение количества товаров
        assertEquals("Товары, 3 шт.", shoppingCart.getTotalQuantity().getText());

        //сравнение суммы товаров
        int totalSum = 0;
        for (String goodPrice: goodPricesExpected) {
            totalSum += Integer.parseInt(goodPrice.substring(0, goodPrice.length()-2));
        }
        String totalSumActual = shoppingCart.getTotalPrice().getText().replaceAll("\\s", "");
        assertEquals(totalSum, Integer.parseInt(totalSumActual.substring(0, totalSumActual.length()-1)));
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

}
