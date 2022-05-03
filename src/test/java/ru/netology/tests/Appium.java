package ru.netology.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class Appium {
    private final AppiumDriver<AndroidElement> driver;

    @AndroidFindBy(id = "textToBeChanged")
    public MobileElement textBefore;

    @AndroidFindBy(id = "userInput")
    public MobileElement input;

    @AndroidFindBy(id = "buttonChange")
    public MobileElement buttonChange;

    @AndroidFindBy(id = "buttonActivity")
    public MobileElement buttonActivity;

    @AndroidFindBy(id = "text")
    public MobileElement activityText;

    public Appium(AppiumDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(15)), this);
    }
}
