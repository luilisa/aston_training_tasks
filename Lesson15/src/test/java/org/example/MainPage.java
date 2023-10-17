package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;
import java.util.List;


public class MainPage {
    private WebDriver driver;
    private Wait<WebDriver> wait;
    private JavascriptExecutor js;
    private Actions builder;

    private List<WebElement> goodNames;
    private List<WebElement> goodPrices;
    private List<WebElement> goodWrappers;
    private WebElement shoppingCardLink;
    private WebElement goods;
    private WebElement goodWrapper;
    private WebElement addToBasketBtn;


    MainPage(WebDriver driver) {
        this.driver = driver;
    }

    void open() {
        driver.get("https://www.wildberries.ru/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        js = (JavascriptExecutor) driver;
        builder = new Actions(driver);
    }

    void initElements() {
        //ждем отображения продуктов и записываем в goods
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'main-page__goods')]")));
        goods = driver.findElement(By.xpath("//div[contains(@class,'main-page__goods')]"));

        //скроллим до goods
        js.executeScript("arguments[0].scrollIntoView();",goods);

        //ждем отображения названия, стоимости
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='product-card__name']")));
    }

    List<WebElement> getGoodNames() {
        goodNames = driver.findElements(By.xpath("//*[@class='product-card__name']"));
        Collections.reverse(goodNames.subList(0,3));
        return goodNames.subList(0,3);
    }

    List<WebElement> getGoodPrices() {
        goodPrices = driver.findElements(By.xpath("//*[contains(@class,'price__lower-price')]"));
        Collections.reverse(goodPrices.subList(0,3));
        return goodPrices.subList(0,3);
    }

    WebElement getGoodsWrapper(int i) {
        goodWrappers = driver.findElements(By.xpath("//*[@class='product-card__wrapper']"));
        return goodWrappers.get(i);
    }

    WebElement getAddButtons(int i) {
        List<WebElement> addButtons = driver.findElements(By.xpath("//*[contains(@class,'product-card__add-basket')]"));
        return addButtons.get(i);
    }



    void addGood(int number) {
        goodWrapper = getGoodsWrapper(number);
        builder.moveToElement(goodWrapper).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'btn-main-sm')]")));
        addToBasketBtn = getAddButtons(number);
        addToBasketBtn.click();
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@class, 'popup-list-of-sizes')]//ul/li[1]")));
            driver.findElement(By.xpath("//*[contains(@class, 'popup-list-of-sizes')]//ul/li[1]")).click();
        }
        catch (TimeoutException timeoutException){
            timeoutException.getStackTrace();
        }
    }

    void openShoppingCart() {
        shoppingCardLink = driver.findElement(By.xpath("//*[@id='basketContent']//*[@href='/lk/basket']"));
        shoppingCardLink.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".good-info__good-name")));
    }

}
