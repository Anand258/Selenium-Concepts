/**
 * Developed by Anand Singh on 04/Jun/2021, 12:51 PM.
 * Copyright (c) 2021. All rights reserved.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LocatorSalesForce {
    @Test
    public void locatorConcepts(){
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://login.salesforce.com");

        driver.findElement(By.id("username")).sendKeys("Hello");

        driver.findElement(By.name("pw")).sendKeys("12345");

        //driver.findElement(By.className("button r4 wide primary")).click(); // Error due to compound class name

        driver.findElement(By.xpath("//*[@id='Login']")).click(); // xpath locator

        String error  = driver.findElement(By.cssSelector("#error")).getText(); // To get the text from element
        System.out.println(error);

        driver.close();
        driver.quit();
    }
}
