package com.tests.day02_locators_getText_getAttribute.HWTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HWP1_Etsy_Search_Title {
    /*
    HWP #1: Etsy Title Verification
1. Open Chrome browser
2. Go to https://www.etsy.com
3. Search for “wooden spoon”
4. Verify title:
Expected: “Wooden spoon - Etsy”
     */
    public static void main(String[] args) throws InterruptedException {
        //1. Open Chrome browser
        WebDriver driver=new ChromeDriver();

        //2. Go to https://www.etsy.com
        driver.get("https://www.etsy.com");
        Thread.sleep(1000);

        //3. Search for “wooden spoon”
        WebElement search = driver.findElement(By.id("global-enhancements-search-query"));
        search.sendKeys("wooden spoon");
        //4. Verify title:
        String expectedTitle="Wooden spoon - Etsy";
        String actualTitle=driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Etsy title verification PASSED!!!");
        }
        else{
            System.out.println("Etsy title verification FAILED!!!");
        }
        Thread.sleep(1000);
        //Close the browser
        driver.close();
    }
}
