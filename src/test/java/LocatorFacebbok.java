/*
 * Developed by Anand Singh on 24/05/21, 7:47 PM.
 * Last modified 24/05/21, 7:47 PM.
 * Copyright (c) 2021. All rights reserved.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LocatorFacebbok {
    @Test
    public void test(){
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("http://facebook.com");

        //driver.findElement(By.id("email")).sendKeys("This is email"); // id locator

        //driver.findElement(By.name("pass")).sendKeys("this is password"); // name locator

        //driver.findElement(By.linkText("Forgotten password?")).click(); // linkText locator

        driver.findElement(By.cssSelector("#email")).sendKeys("This is email"); // css locator

        driver.findElement(By.cssSelector("#pass")).sendKeys("This is password"); // css locator

        driver.findElement(By.xpath("//input[@value='Log In']")).click();

        driver.close();
        driver.quit();
    }
}
