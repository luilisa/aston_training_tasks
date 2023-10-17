package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ShoppingCart {

    private WebDriver driver;
    private List<String> goodNamesList;
    private List<WebElement> goodNames;
    private List<WebElement> goodPrices;
    private List<WebElement> goodQuantity;

    ShoppingCart(WebDriver driver) {
        this.driver = driver;
    }

    List<WebElement> getGoodNames() {
        goodNames = driver.findElements(By.cssSelector(".good-info__good-name"));
        return goodNames;
    }

    List<WebElement> getGoodPrices() {
        goodPrices = driver.findElements(By.xpath("//*[@class='list-item__price-new']"));
        return goodPrices;
    }

    WebElement getTotalQuantity() {
        return driver.findElement(By.xpath("//*[@class='b-top__count line']/span[1]"));
    }

    WebElement getTotalPrice() {
        return driver.findElement(By.xpath("//*[@class='b-top__total line']/span/span"));
    }


}
