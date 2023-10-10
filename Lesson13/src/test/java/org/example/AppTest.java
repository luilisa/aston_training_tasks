package org.example;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AppTest
{
    static WebDriver driver;
    static WebElement payWrapperText;
    static List<WebElement> payPartnersLogos;
    static WebElement linkToMoreInfo;
    static WebElement cookieBtn;
    static WebElement continueBtn;
    static WebElement phoneInput;
    static WebElement sumInput;
    static WebElement emailInput;

    static void locateElements() {
        cookieBtn = driver.findElement(By.xpath("//button[@class='cookie__close']"));
        payWrapperText = driver.findElement(By.xpath("//section[@class='pay']//h2"));
        payPartnersLogos = driver.findElements(By.xpath("//div[@class='pay__partners']//img"));
        linkToMoreInfo = driver.findElement(By.linkText("Подробнее о сервисе"));
    }

    @BeforeAll
    static void setupTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='cookie show']")));
        locateElements();
        cookieBtn.click();
    }

    @Test
    @Order(1)
    public void payWrapperTest() {
        String text = payWrapperText.getText();
        assertEquals("Онлайн пополнение\nбез комиссии", text);
    }

    @Test
    @Order(2)
    public void payPartnersLogosTest() {
        payPartnersLogos.forEach(logo -> assertTrue(logo.isDisplayed()));
    }

    @Test
    @Order(3)
    public void linkToMoreInfoTest() {
        linkToMoreInfo.click();
        assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", driver.getCurrentUrl());
        driver.navigate().back();
    }

    @Test
    @Order(4)
    public void continueBtnTest() {
        phoneInput = driver.findElement(By.cssSelector("#connection-phone"));
        phoneInput.click();
        phoneInput.sendKeys("297777777");

        sumInput = driver.findElement(By.cssSelector("#connection-sum"));
        sumInput.click();
        sumInput.sendKeys("100");

        emailInput = driver.findElement(By.cssSelector("#connection-email"));
        emailInput.click();
        emailInput.sendKeys("test@mail.ru");

        continueBtn = driver.findElement(By.cssSelector("#pay-connection > button"));
        continueBtn.click();

        //ждем открытия фрейма для оплаты
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@class='bepaid-iframe']")));
    }

    @AfterAll
    static void teardown() {
        driver.quit();
    }
}
