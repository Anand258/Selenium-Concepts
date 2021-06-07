import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Developed by Anand Singh on 07/Jun/2021, 11:25 PM.
 * Copyright (c) 2021. All rights reserved.
 */
public class EcommerceSite {
    @Test
    public void eCommerceSiteOperations() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        Thread.sleep(3000L);
        String[] itemNeeded = {"Brocolli","Beetroot","Tomato"};
        List<String> itemNeededList = Arrays.asList(itemNeeded);
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
