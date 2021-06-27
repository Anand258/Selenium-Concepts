import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Developed by Anand Singh on 20/Jun/2021, 12:35 AM.
 * Copyright (c) 2021. All rights reserved.
 */
public class WebTableSorting {

    public String getPrice(WebElement s){
        return s.findElement(By.xpath("following-sibling::td[1]")).getText();
    }

    @Test
    public void checkSortedItem(){
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.xpath("//tr/th[1]")).click();
        String wantedItem = "Rice";
        List<WebElement> items = driver.findElements(By.xpath("//tr/td[1]"));

        List<String> originalList = items.stream().map(s->s.getText()).collect(Collectors.toList());
        List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
        System.out.println(originalList);
        System.out.println(sortedList);
        //Assert.assertEquals(sortedList, originalList);

        List<String> price;
        do{
            List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
            price = rows.stream()
                    .filter(s->s.getText().equalsIgnoreCase(wantedItem))
                    .map(s->getPrice(s)).collect(Collectors.toList());
            if(price.size()<1){
                driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
            }
        } while (price.size()<1);

        System.out.println(price);
    }

    @Test
    public void checkSearchFunction(){
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        driver.findElement(By.id("search-field")).sendKeys("Rice");
        List<WebElement> searchList = driver.findElements(By.xpath("//tr/td[1]"));

        List<WebElement> filterList = searchList.stream().filter(s->s.getText().contains("Rice")).collect(Collectors.toList());

        Assert.assertEquals(searchList.size(), filterList.size());
    }


    @Test
    public void test(){
/*        Integer [] list = {2,5,6,1,8,3};
        List<Integer> listed = new ArrayList<Integer>(Arrays.asList(list));
        listed.stream().sorted().forEach(s->System.out.print(s));

        for(int i =0; i < list.length-1; i++) {
            for(int j=i; j<list.length-i-1; j++){
                if(list[j]>list[j+1]){
                    int temp = list[j];
                    list[j] = list[j+1];
                    list[j+1] = temp;
                }
            }
        }
        for(int k =0; k<list.length; k++)
            System.out.println(list[k]);*/
    }
}
