import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * Developed by Anand Singh on 16/Jun/2021, 12:37 AM.
 * Copyright (c) 2021. All rights reserved.
 */
public class BrokenLink {

    @Test
    public void brokenLinkConcept() throws IOException {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        SoftAssert softAssert = new SoftAssert();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        List<WebElement> list = driver.findElements(By.cssSelector("div[id='gf-BIG'] a"));
        for(int loop = 0; loop < list.size(); loop++){
            String url = list.get(loop).getAttribute("href");
            HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
            con.setRequestMethod("HEAD");
            con.connect();
            int statusCode = con.getResponseCode();
            System.out.println(url +"\t"+ statusCode);
            softAssert.assertTrue(statusCode<400, "broken url : " + url + "with status code : " +statusCode);
        }
        softAssert.assertAll();
    }
}
