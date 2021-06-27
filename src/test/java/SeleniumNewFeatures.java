import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

/**
 * Developed by Anand Singh on 27/Jun/2021, 12:12 PM.
 * Copyright (c) 2021. All rights reserved.
 */
public class SeleniumNewFeatures {
    WebDriver driver = new ChromeDriver();

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver.get("https://rahulshettyacademy.com/angularpractice/");
    }

    @Test
    public void relativeLocators(){

        // using above
        WebElement nameTextBoxElement = driver.findElement(By.cssSelector("[name='name']"));
        System.out.println(driver.findElement(with(By.tagName("label")).above(nameTextBoxElement)).getText());

        // using below
        WebElement emailText = driver.findElement(By.xpath("//label[text()='Email']"));
        driver.findElement(with(By.tagName("input")).below(emailText)).sendKeys("Hello");

        // using toLeftOf
        WebElement checkboxText = driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
        driver.findElement(with(By.tagName("input")).toLeftOf(checkboxText)).click();

        // using toRightOf
        WebElement radioText = driver.findElement(By.cssSelector("[for='exampleFormControlRadio1']"));
        driver.findElement(with(By.tagName("input")).toRightOf(radioText)).click();
    }

    @Test
    public void multiWindow(){

        WebElement nameTextBoxElement = driver.findElement(By.cssSelector("[name='name']"));

        // driver.switchTo().newWindow(WindowType.WINDOW); // to open new window
        driver.switchTo().newWindow(WindowType.TAB);  // to open new tab

        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentWindowId = it.next();
        String childWindowId = it.next();
        driver.switchTo().window(childWindowId);
        driver.get("https://rahulshettyacademy.com/#/index");
        String courseName = driver.findElements(By.cssSelector("[href*='https://courses.rahulshettyacademy.com/p/']")).get(1).getText();
        driver.switchTo().window(parentWindowId);
        nameTextBoxElement.sendKeys(courseName);
    }

    @Test
    public void elementScreenShot() throws IOException {
        WebElement nameTextBoxElement = driver.findElement(By.cssSelector("[name='name']"));
        nameTextBoxElement.sendKeys("Hello");
        File file = nameTextBoxElement.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("/Users/anasingh/IdeaProjects/Selenium-Concepts/screenshots/nameTextBox.png"));
    }

    @Test
    public void getElementDimentions(){
        WebElement nameTextBoxElement = driver.findElement(By.cssSelector("[name='name']"));
        System.out.println(nameTextBoxElement.getRect().getDimension().getHeight());
        System.out.println(nameTextBoxElement.getRect().getDimension().getWidth());
    }
}
