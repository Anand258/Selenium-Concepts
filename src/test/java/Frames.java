import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

/**
 * Developed by Anand Singh on 11/Jun/2021, 1:54 AM.
 * Copyright (c) 2021. All rights reserved.
 */
public class Frames {
    @Test
    public void framesConcept(){
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://jqueryui.com/droppable/");
        //int num = driver.findElements(By.tagName("iframe")).size();
        //driver.switchTo().frame(num-1);
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']"))); // to move the control to frame
        Actions a = new Actions(driver);
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        a.dragAndDrop(source, target).build().perform();
        driver.switchTo().defaultContent(); // to move back the control to html page
        System.out.println(driver.findElement(By.xpath("//div[@class='demo-list']/h2")).getText());
    }
}
