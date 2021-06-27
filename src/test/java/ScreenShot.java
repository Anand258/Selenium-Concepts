import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

/**
 * Developed by Anand Singh on 16/Jun/2021, 12:14 AM.
 * Copyright (c) 2021. All rights reserved.
 */
public class ScreenShot {

    @Test
    public void screenShotConcept() throws IOException {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("/Users/anasingh/IdeaProjects/Selenium-Concepts/screenshots/test.png"));
    }
}
