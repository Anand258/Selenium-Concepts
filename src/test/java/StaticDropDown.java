import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

/**
 * Developed by Anand Singh on 04/Jun/2021, 3:52 PM.
 * Copyright (c) 2021. All rights reserved.
 */
public class StaticDropDown {

    @Test
    public void staticDropDownConcept() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        WebElement dropDownElement = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));

        Select dropDown = new Select(dropDownElement); // static drop down have select tag.
        dropDown.selectByIndex(3);  // select using index
        String indexValue = dropDown.getFirstSelectedOption().getText(); // to get the selected option
        System.out.println(indexValue);

        dropDown.selectByVisibleText("AED"); // select using visible text
        String visibleValue = dropDown.getFirstSelectedOption().getText();
        System.out.println(visibleValue);

        dropDown.selectByValue("INR"); // select using value attribute
        String value = dropDown.getFirstSelectedOption().getText();
        System.out.println(value);


        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(1000L);
        int counter = 1;
        while(counter<5){
            driver.findElement(By.id("hrefIncAdt")).click();
            counter++;
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
    }
}
