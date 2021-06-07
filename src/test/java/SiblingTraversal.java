/**
 * Developed by Anand Singh on 04/Jun/2021, 12:51 PM.
 * Copyright (c) 2021. All rights reserved.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SiblingTraversal {
    @Test
    public void siblingConcepts(){
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("http://rahulshettyacademy.com/AutomationPractice/");

        String child1 = driver.findElement(By.xpath("//label[@for='bmw']")).getText();
        System.out.println(child1);

        String sibling1 = driver.findElement(By.xpath("//label[@for='bmw']/following-sibling::label[1]")).getText();
        System.out.println(sibling1);

        String sibling2 = driver.findElement(By.xpath("//label[@for='bmw']/following-sibling::label[2]")).getText();
        System.out.println(sibling2);

    }
}
