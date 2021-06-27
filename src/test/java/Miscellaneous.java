import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/**
 * Developed by Anand Singh on 16/Jun/2021, 12:04 AM.
 * Copyright (c) 2021. All rights reserved.
 */
public class Miscellaneous {

    @Test
    public void misc(){
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); // to maximize the window
        driver.manage().deleteAllCookies(); // to delete all the cookies
        driver.manage().deleteCookieNamed("SecurityKey"); // to delete specific cookie

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
    }
}
