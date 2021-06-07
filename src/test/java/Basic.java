/**
 * Developed by Anand Singh on 04/Jun/2021, 12:51 PM.
 * Copyright (c) 2021. All rights reserved.
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Basic {
    @Test
    public void basicConcepts(){
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.google.com");    // To open the url on browser

        System.out.println(driver.getTitle());  // To get the page title
                                                // validate if your page title is correct

        System.out.println(driver.getCurrentUrl()); // To get the current url
                                                    // validate if you are landed on the correct url

        System.out.println(driver.getPageSource()); // To get the page source

        driver.navigate().to("http://www.facebook.com"); // To navigate to other url

        driver.navigate().back(); // To navigate back to previous url

        driver.navigate().forward(); // To navigate again to the next url

        driver.close(); //close current browser

        driver.quit(); //close all the browser open by selenium
    }


}
