package org.example;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
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
    static WebElement continueBtn;
    static WebElement phoneInput;
    static WebElement sumInput;
    static WebElement emailInput;

    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");
    }

    public void selectOption(int i) {
        Actions builder = new Actions(driver);
        WebElement selectWrapper = driver.findElement(By.cssSelector("div.select__wrapper"));
        List<WebElement> selectOptions = driver.findElements(By.xpath("//p[@class='select__option']"));
        builder
                .click(selectWrapper)
                .click(selectOptions.get(i))
                .perform();
    }

    @Test
    @Order(1)
    public void selectBtnTest() {
        Actions builder = new Actions(driver);
        WebElement form = driver.findElement(By.id("pay-connection"));
        builder.moveToElement(form);

        phoneInput = driver.findElement(By.id("connection-phone"));
        sumInput = driver.findElement(By.id("connection-sum"));
        emailInput = driver.findElement(By.id("connection-email"));

        assertEquals("Номер телефона", phoneInput.getAttribute("placeholder"));
        assertEquals("Сумма", sumInput.getAttribute("placeholder"));
        assertEquals("E-mail для отправки чека", emailInput.getAttribute("placeholder"));

        selectOption(1);

        phoneInput = driver.findElement(By.cssSelector("#internet-phone"));
        sumInput = driver.findElement(By.cssSelector("#internet-sum"));
        emailInput = driver.findElement(By.cssSelector("#internet-email"));

        assertEquals("Номер абонента", phoneInput.getAttribute("placeholder"));
        assertEquals("Сумма", sumInput.getAttribute("placeholder"));
        assertEquals("E-mail для отправки чека", emailInput.getAttribute("placeholder"));

        selectOption(2);

        phoneInput = driver.findElement(By.cssSelector("#score-instalment"));
        sumInput = driver.findElement(By.cssSelector("#instalment-sum"));
        emailInput = driver.findElement(By.cssSelector("#instalment-email"));

        assertEquals("Номер счета на 44", phoneInput.getAttribute("placeholder"));
        assertEquals("Сумма", sumInput.getAttribute("placeholder"));
        assertEquals("E-mail для отправки чека", emailInput.getAttribute("placeholder"));

        selectOption(3);

        phoneInput = driver.findElement(By.cssSelector("#score-arrears"));
        sumInput = driver.findElement(By.cssSelector("#arrears-sum"));
        emailInput = driver.findElement(By.cssSelector("#arrears-email"));
        assertEquals("Номер счета на 2073", phoneInput.getAttribute("placeholder"));
        assertEquals("Сумма", sumInput.getAttribute("placeholder"));
        assertEquals("E-mail для отправки чека", emailInput.getAttribute("placeholder"));

        selectOption(0);
    }

    @Test
    @Order(2)
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

        continueBtn = driver.findElement(By.cssSelector("#pay-connection button"));
        continueBtn.click();

        //ждем открытия фрейма для оплаты
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@class='bepaid-iframe']")));
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p.header__payment-amount")));
        WebElement sumInfo = driver.findElement(By.cssSelector("p.header__payment-amount"));
        String sum = sumInfo.getText();
        assertEquals("100.00 BYN", sum);

        String buttonText = driver.findElement(By.xpath("//div[@class='card-page__card']/button")).getText();
        assertTrue(buttonText.contains("100.00 BYN"));

        WebElement numberInfo = driver.findElement(By.cssSelector("p.header__payment-info"));
        String number = "297777777";
        assertTrue(numberInfo.getText().contains(number));

        List<WebElement> cardDetails = driver.findElements(By.xpath("//div[@class='card-page__card']//label"));
        assertEquals("Номер карты", cardDetails.get(0).getText());
        assertEquals("Срок действия", cardDetails.get(1).getText());
        assertEquals("CVC", cardDetails.get(2).getText());
        assertEquals("Имя держателя (как на карте)", cardDetails.get(3).getText());

        List<WebElement> cardBrands = driver.findElements(By.xpath("//div[contains(@class, 'cards-brands__container')]/*"));
        cardBrands.forEach(icon -> assertTrue(icon.isDisplayed()));
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }
}
