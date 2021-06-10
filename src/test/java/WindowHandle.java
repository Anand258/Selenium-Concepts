import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

/**
 * Developed by Anand Singh on 11/Jun/2021, 1:06 AM.
 * Copyright (c) 2021. All rights reserved.
 */
public class WindowHandle {
    @Test
    public void windowHandleConcept(){
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.findElement(By.xpath("//a[@class='blinkingText']")).click();
        Set<String> windowIds = driver.getWindowHandles();
        Iterator<String> itr = windowIds.iterator();
        String parentWindowId = itr.next();
        String childWindowId = itr.next();
        driver.switchTo().window(childWindowId);
        String emailId = driver.findElement(By.xpath("//*[@class='im-para red']")).getText().split("Please email us at")[1].trim().split(" ")[0];
        driver.switchTo().window(parentWindowId);
        driver.findElement(By.id("username")).sendKeys(emailId);
    }
}
