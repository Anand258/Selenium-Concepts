import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

/**
 * Developed by Anand Singh on 11/Jun/2021, 12:35 AM.
 * Copyright (c) 2021. All rights reserved.
 */
public class ActionInteraction {
    @Test
    public void actionsConcept(){
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");
        Actions a = new Actions(driver);

        WebElement moveElement2 = driver.findElement(By.id("twotabsearchtextbox"));
        a.moveToElement(moveElement2).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();

        WebElement moveElement1 = driver.findElement(By.id("nav-link-accountList"));
        a.moveToElement(moveElement1).contextClick().build().perform(); // move to specific element

    }
}
