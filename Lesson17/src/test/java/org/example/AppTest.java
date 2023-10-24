package org.example;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {
    static AndroidDriver <AndroidElement> driver = null;;

    @BeforeAll
    public static void initialize() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 3a");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.google.android.calculator");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.android.calculator2.Calculator");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);

        try {
            driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
    }

    @DisplayName("Проверка операции сложения")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void additionTest() {
        driver.findElementById("com.google.android.calculator:id/digit_1").click();
        driver.findElementById("com.google.android.calculator:id/op_add").click();
        driver.findElementById("com.google.android.calculator:id/digit_2").click();
        driver.findElementById("com.google.android.calculator:id/eq").click();

        assertEquals("3", driver.findElementById("com.google.android.calculator:id/result_final").getText());
    }

    @DisplayName("Проверка операции вычитания")
    @Description("Проверка операции вычитания")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void substractionTest() {
        driver.findElementById("com.google.android.calculator:id/digit_9").click();
        driver.findElementById("com.google.android.calculator:id/op_sub").click();
        driver.findElementById("com.google.android.calculator:id/digit_5").click();
        driver.findElementById("com.google.android.calculator:id/eq").click();

        assertEquals("4", driver.findElementById("com.google.android.calculator:id/result_final").getText());
    }

    @DisplayName("Проверка операции умножения")
    @Step("Проверка операции умножения")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void multiplicationTest() {
        driver.findElementById("com.google.android.calculator:id/digit_6").click();
        driver.findElementById("com.google.android.calculator:id/op_mul").click();
        driver.findElementById("com.google.android.calculator:id/digit_7").click();
        driver.findElementById("com.google.android.calculator:id/eq").click();

        assertEquals("42", driver.findElementById("com.google.android.calculator:id/result_final").getText());
    }

    @DisplayName("Проверка операции деления")
    @Description("Проверка операции деления")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void divisionTest() {
        driver.findElementById("com.google.android.calculator:id/digit_7").click();
        driver.findElementById("com.google.android.calculator:id/digit_2").click();
        driver.findElementById("com.google.android.calculator:id/op_div").click();
        driver.findElementById("com.google.android.calculator:id/digit_9").click();
        driver.findElementById("com.google.android.calculator:id/eq").click();

        assertEquals("8", driver.findElementById("com.google.android.calculator:id/result_final").getText());
    }

    @AfterAll
    public static void quit() {
        driver.quit();
    }
}
