import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/**
 * Developed by Anand Singh on 04/Jun/2021, 1:31 PM.
 * Copyright (c) 2021. All rights reserved.
 */
public class ChildParentTraversal {
    @Test
    public void childParentConcepts(){
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).click();

        String parent = driver.findElement(By.xpath("//input[@id='checkBoxOption1']/parent::label")).getText();
        System.out.println(parent);
    }
}
