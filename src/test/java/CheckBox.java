import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Developed by Anand Singh on 04/Jun/2021, 6:32 PM.
 * Copyright (c) 2021. All rights reserved.
 */
public class CheckBox {
    @Test
    public void checkBoxConcept(){
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        System.out.println(driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected());
        driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
        System.out.println(driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected());

        // Count the number of checkbox on the page
        List<WebElement> allCheckbox = driver.findElements(By.xpath("//input[@type='checkbox']"));
        System.out.println(allCheckbox.size());

    }
}
