import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;



/**
 * Developed by Anand Singh on 15/Jun/2021, 11:43 PM.
 * Copyright (c) 2021. All rights reserved.
 */
public class CertificationHandling {

    @Test
    public void certificationConcepts(){
        //SSL Certification handling

        // general chrome profile
        DesiredCapabilities ch = new DesiredCapabilities();

        // accept certificates
        ch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        ch.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

        // local browser
        ChromeOptions c = new ChromeOptions();
        c.merge(ch);

        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver(c);

        driver.get("https://confluence.corporate.local/display/DSGENG/Minor%2C+HotFix%2C+Emergency+Release+Instructions+for+2019");
    }
}
