package ru.netology.tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AppTest {
    private AndroidDriver<AndroidElement> driver;
    private Appium main;

    @AfterAll
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @BeforeAll
    public void setUp() {
        AppiumDriverLocalService appiumLocalService = new AppiumServiceBuilder().usingAnyFreePort().build();
        appiumLocalService.start();
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:deviceName", "Android Virtual Device");
        desiredCapabilities.setCapability("appium:app", "C:\\Users\\69301\\MyProjects\\Netology\\mobile\\2_4hw\\apk\\app-debug.apk");

        driver = new AndroidDriver<>(appiumLocalService, desiredCapabilities);
        main = new Appium(driver);
    }

    @Test
    @Order(1)
    @DisplayName("input Nothing")
    public void inputNothing() {
        String textBefore = main.textBefore.getText();
        main.buttonChange.click();
        String textAfter = main.textBefore.getText();
        assertEquals(textBefore, textAfter);
    }

    @Test
    @Order(2)
    @DisplayName("input Space")
    public void inputSpace() {
        String textBefore = main.textBefore.getText();
        main.input.sendKeys(" ");
        main.buttonChange.click();
        String textAfter = main.textBefore.getText();
        assertEquals(textBefore, textAfter);
    }

    @Test
    @Order(3)
    @DisplayName("new Activity")
    public void newActivity() {
        main.input.sendKeys("Netology");
        main.buttonActivity.click();
        String textAfter = main.activityText.getText();
        assertEquals("Netology", textAfter);
    }
}
