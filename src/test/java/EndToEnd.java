import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Developed by Anand Singh on 06/Jun/2021, 11:39 PM.
 * Copyright (c) 2021. All rights reserved.
 */
public class EndToEnd {

    @Test
    public void spicejetE2E() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.spicejet.com/");

        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='BLR']")).click();
        Thread.sleep(2000L);
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();

        driver.findElement(By.cssSelector("a.ui-state-default.ui-state-highlight")).click();

        if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")){
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }

        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(1000L);
        WebElement dropDownElementPass = driver.findElement(By.id("ctl00_mainContent_ddl_Adult"));
        Select dropDownPass = new Select(dropDownElementPass);
        dropDownPass.selectByValue("5");
        String valuePass = dropDownPass.getFirstSelectedOption().getText();
        Assert.assertEquals(valuePass, "5");

        WebElement dropDownElement = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropDown = new Select(dropDownElement);
        dropDown.selectByValue("INR");
        String value = dropDown.getFirstSelectedOption().getText();
        Assert.assertEquals(value, "INR");

        driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
        Assert.assertTrue(driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected());

        driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
    }
}
