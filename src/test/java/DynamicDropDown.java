import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/**
 * Developed by Anand Singh on 04/Jun/2021, 4:15 PM.
 * Copyright (c) 2021. All rights reserved.
 */
public class DynamicDropDown {
    @Test
    public void dynamicDropDownConcept() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='BLR']")).click();
        Thread.sleep(2000L);
        //driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click(); // using index concept.

        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).
                click(); // using parent child relationship concept.
    }
}
