import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Developed by Anand Singh on 05/Jun/2021, 11:16 PM.
 * Copyright (c) 2021. All rights reserved.
 */
public class Assignments {
    @Test
    public void assignment1() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.id("checkBoxOption1")).click();
        Assert.assertTrue(driver.findElement(By.id("checkBoxOption1")).isSelected());

        driver.findElement(By.id("checkBoxOption1")).click();
        Assert.assertFalse(driver.findElement(By.id("checkBoxOption1")).isSelected());
    }

    @Test
    public void assignment2() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        List<WebElement> checkboxList = driver.findElements(By.xpath("//input[@type='checkbox']"));
        System.out.println(checkboxList.size());
    }

    @Test
    public void assignment3() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.itgeared.com/demo/1506-ajax-loading.html");
        WebDriverWait w = new WebDriverWait(driver, 5);
        driver.findElement(By.linkText("Click to load get data via Ajax!")).click();
        w.until(ExpectedConditions.visibilityOfElementLocated(By.id("results")));
        System.out.println(driver.findElement(By.id("results")).getText());
    }

    @Test
    public void assignment4(){
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/windows");
        driver.findElement(By.cssSelector("div[class='example'] a")).click();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it =  windows.iterator();
        String parentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);
        System.out.println(driver.findElement(By.cssSelector("div[class='example'] h3")).getText());
        driver.switchTo().window(parentId);
        System.out.println(driver.findElement(By.cssSelector("div[class='example'] h3")).getText());
    }

    @Test
    public void assignment5(){
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.linkText("Nested Frames")).click();
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
        System.out.println(driver.findElement(By.xpath("//div[@id='content']")).getText());
    }

    @Test
    public void assignment6(){
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // gives the count of all the links
        System.out.println(driver.findElements(By.tagName("a")).size());

        // gives the count of all the footer links
        WebElement footerDriver = driver.findElement(By.id("gf-BIG")); // limiting driver scope
        System.out.println(footerDriver.findElements(By.tagName("a")).size());

        // gives the count of all the column links
        WebElement columnDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        System.out.println(columnDriver.findElements(By.tagName("a")).size());

        // open all the column links
        int size = columnDriver.findElements(By.tagName("a")).size();
        WebDriverWait w = new WebDriverWait(driver, 10);

        /*Actions a = new Actions(driver); // using actions
        for(int loop = 1; loop < size; loop++){
            a.moveToElement(columnDriver.findElements(By.tagName("a")).get(loop)).keyDown(Keys.COMMAND).click().build().perform();
        }*/

        String rightClickOpen = Keys.chord(Keys.COMMAND, Keys.ENTER); // using keyboard keys
        for(int loop = 1; loop < size; loop++){
            columnDriver.findElements(By.tagName("a")).get(loop).sendKeys(rightClickOpen);
            w.until(ExpectedConditions.visibilityOf(columnDriver.findElements(By.tagName("a")).get(loop)));
        }

        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        while (it.hasNext()){
            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());
        }
    }

    @Test
    public void assignment7(){
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // select any checkbox
        driver.findElement(By.xpath("//label[@for='honda']/input")).click();

        // grab the label of the selected checkbox
        String selectedOption = driver.findElement(By.xpath("//label[@for='honda']")).getText().trim();
        System.out.println(selectedOption);

        // select same option in the drop down. Do not hardcode.
        WebElement dropDown = driver.findElement(By.id("dropdown-class-example"));
        Select s = new Select(dropDown);
        s.selectByVisibleText(selectedOption);

        // enter the same option in alert editbox
        driver.findElement(By.id("name")).sendKeys(selectedOption);

        // click alert and verify the text grabbed from above step is present in the pop up msg
        driver.findElement(By.id("alertbtn")).click();
        String alertMsg = driver.switchTo().alert().getText();
        if(alertMsg.contains(selectedOption)) {
            System.out.println(selectedOption + " is present in alertMsg.");
        } else {
            System.out.println(selectedOption + " is not present in alertMsg.");
        }
    }

    @Test
    public void assignment8(){
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");

        // print no of rows
        List<WebElement> rows = driver.findElements(By.cssSelector(".table-display tr"));
        System.out.println(rows.size());

        // print no of columns
        List<WebElement> columns = driver.findElements(By.cssSelector(".table-display th"));
        System.out.println(columns.size());

        // print second row
        System.out.println(rows.get(2).getText());
    }

    @Test
    public void assignment9(){
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        WebDriverWait w = new WebDriverWait(driver, 10);
        String wantedCon = "United States (USA)";
        driver.findElement(By.id("autocomplete")).sendKeys("Uni");
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ui-menu-item div")));
        List<WebElement> list = driver.findElements(By.cssSelector(".ui-menu-item div"));
        for(int loop = 0; loop < list.size(); loop++){
            if(wantedCon.equalsIgnoreCase(list.get(loop).getText())){
                list.get(loop).click();
                break;
            }
        }
    }
}
