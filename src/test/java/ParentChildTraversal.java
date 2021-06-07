/**
 * Developed by Anand Singh on 04/Jun/2021, 12:51 PM.
 * Copyright (c) 2021. All rights reserved.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ParentChildTraversal {
    @Test
    public void parentChildConcept(){
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.google.com");
        driver.findElement(By.xpath("//div[@class='RNNXgb']/div/div[2]/input")).sendKeys("Able to traverse from parent to child");
    }
}
