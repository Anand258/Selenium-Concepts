/**
 * Developed by Anand Singh on 04/Jun/2021, 12:51 PM.
 * Copyright (c) 2021. All rights reserved.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RelativeVsAbsolutePath {
    @Test
    public void relativeVsAbsolutePathConcepts(){
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.google.com");

        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).
                sendKeys("Hello"); // this is absolute path

        driver.findElement(By.xpath("//*[text()='Images']")).click(); // this is relative path using text locator.
    }
}
