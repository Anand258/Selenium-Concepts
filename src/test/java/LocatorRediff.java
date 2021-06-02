/*
 * Developed by Anand Singh on 30/05/21, 8:59 PM.
 * Last modified 30/05/21, 8:59 PM.
 * Copyright (c) 2021. All rights reserved.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LocatorRediff {

    @Test
    public void test(){
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("http://rediff.com");

        driver.findElement(By.cssSelector("a[title*='Sign in']")).click(); // customized css with regx

        driver.findElement(By.cssSelector("input[id='login1']")).sendKeys("this is username"); // customized css

        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("this is password"); //customized xpath

        driver.findElement(By.xpath("//input[contains(@name, 'procee')]")).click(); // customized xpath with regx

        driver.close();
        driver.quit();
    }
}
