package com.cydeo.tests.day02_locators_getText_getAttribute;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_CydeoVerification {
    /*
    TC #1: Cydeo practice tool verifications
        1. Open Chrome browser
        2. Go to https://practice.cydeo.com
        3. Verify URL contains
            Expected: cydeo
        4. Verify title:
            Expected: Practice
     */
    public static void main(String[] args) throws InterruptedException {
        //Open Chrome browser
        WebDriver driver = new ChromeDriver();
        //driver.manage().window().maximize();

        //Go to https://practice.cydeo.com
        driver.get("https://practice.cydeo.com/");

        //Verify URL contains
        String expectedInURL = "cydeo";
        String actualURL=driver.getCurrentUrl();

        if (actualURL.contains(expectedInURL)){
            System.out.println("URL verification is PASSED!!");
        }
        else {
            System.out.println("URL verification is FAILED!!");
        }
        Thread.sleep(1000);
        //Verify title:
        String expectedTitle="Practice";
        String actualTitle=driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title verification is PASSED!!");
        }
        else {
            System.out.println("Title verification is FAILED!!");
        }
        Thread.sleep(1000);

        //close browser
        driver.close();

    }
}
