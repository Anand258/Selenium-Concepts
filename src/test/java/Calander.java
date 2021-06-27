import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Developed by Anand Singh on 05/Jun/2021, 11:30 PM.
 * Copyright (c) 2021. All rights reserved.
 */
public class Calander {
    @Test
    public void calanderConcepts(){
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.spicejet.com/");
        driver.findElement(By.id("ctl00_mainContent_view_date1")).click();
        driver.findElement(By.cssSelector("a.ui-state-default.ui-state-highlight.ui-state-active")).click();

        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1")){
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void specificDateSelection(){
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.spicejet.com/");

        String targetDate = "23";
        String targetMonth = "December";
        WebDriverWait w = new WebDriverWait(driver, 10);
        driver.findElement(By.id("ctl00_mainContent_view_date1")).click();
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-handler='selectDay']")));
        while(!driver.findElement(By.cssSelector("div[class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-left'] span[class='ui-datepicker-month']")).getText().equalsIgnoreCase(targetMonth)){
            driver.findElement(By.cssSelector("span[class='ui-icon ui-icon-circle-triangle-e']")).click();
        }

        List<WebElement> dates = driver.findElements(By.cssSelector("td[data-handler='selectDay']"));
        for(int loop = 0; loop<dates.size(); loop++){
            String gotDate = dates.get(loop).getText();
            if(gotDate.equalsIgnoreCase(targetDate)){
                dates.get(loop).click();
                break;
            }
        }
    }
}
