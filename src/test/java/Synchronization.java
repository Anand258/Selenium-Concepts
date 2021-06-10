import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Developed by Anand Singh on 07/Jun/2021, 11:25 PM.
 * Copyright (c) 2021. All rights reserved.
 */
public class Synchronization {
    static WebDriver driver = new ChromeDriver();
    WebDriverWait w = new WebDriverWait(driver, 5);

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // implicit wait
        // Pros : Readable code
        // Cons : Performance issue not get caught
    }

    @Test
    public void eCommerceSiteOperations() {
        String[] itemNeeded = {"Brocolli","Beetroot","Tomato"};
        List<String> itemNeededList = Arrays.asList(itemNeeded);
        addItem(itemNeededList);
        driver.findElement(By.xpath("//img[@alt='Cart']")).click();
        driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='promoCode']"))); // explicit wait
        // Pros : Performance issue get caught
        // Cons : Need to write more code
        driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='promoInfo']"))); // explicit wait
        String codeStatus = driver.findElement(By.xpath("//span[@class='promoInfo']")).getText();
        Assert.assertEquals(codeStatus, "Code applied ..!");
    }

    public static void addItem(List<String> itemNeededList){
        int counter = 0;
        List<WebElement> productsList = driver.findElements(By.xpath("//h4[@class='product-name']"));
        for(int loop=0; loop<productsList.size(); loop++){
            String product = productsList.get(loop).getText().split("-")[0].trim();
            if(itemNeededList.contains(product)){
                counter++;
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(loop).click();
            }
            if(counter==itemNeededList.size()){
                break;
            }
        }
    }
}
