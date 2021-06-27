import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Developed by Anand Singh on 11/Jun/2021, 2:40 AM.
 * Copyright (c) 2021. All rights reserved.
 */
public class Scroll {
    @Test
    public void scrollingConcept(){
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        WebDriverWait w = new WebDriverWait(driver, 5);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".tableFixHead")));
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=500");
        List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
        int sum = 0;
        for(int loop =0; loop < values.size(); loop++){
            sum = sum + Integer.parseInt(values.get(loop).getText());
        }
        int total = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
        Assert.assertEquals(total, sum);
    }

    @Test
    public void scrollExample(){
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        int sum = 0;
        List<WebElement> values = driver.findElements(By.cssSelector(".table-display td:nth-child(3)"));
        for(int loop = 0 ; loop < values.size() ; loop++){
            sum = sum + Integer.parseInt(values.get(loop).getText());
        }
        System.out.println(sum);
    }
}
