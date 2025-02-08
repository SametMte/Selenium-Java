package com.tests.day02_locators_getText_getAttribute.HWTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HWP3_Gmail_Title_Verification {
    /*
    1- Open a chrome browser
2- Go to: https://google.com
3- Click to Gmail from top right.
4- Verify title contains:
Expected: Gmail
5- Go back to Google by using the .back();
6- Verify title equals:
Expected: Google
     */
    public static void main(String[] args) throws InterruptedException {
        //1- Open a chrome browser
        WebDriver driver= new ChromeDriver();

        //2- Go to: https://google.com
        driver.get("https://google.com");

        //3- Click to Gmail from top right.

        //Locate the Gmail link using "LinkText" locator
        WebElement gmailLink = driver.findElement(By.linkText("Gmail"));

        //Click to the gmail link
        gmailLink.click();

        //4- Verify title contains:
        String expectedGmailTitle="Gmail";
        String actualGmailTitle = driver.getTitle();

        if (actualGmailTitle.contains(expectedGmailTitle)){
            System.out.println("Gmail title verification PASSED!!!");
        }
        else{
            System.out.println("Gmail title verification FAILED!!!");
        }

        Thread.sleep(1000);
        //5- Go back to Google by using the .back();
        driver.navigate().back();
        //6- Verify title equals:
        String expectedTitle="Google";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Google title verification PASSED!!!");
        }
        else{
            System.out.println("Google title verification FAILED!!!");
        }
        Thread.sleep(1000);
        //close the browser
        driver.close();
    }
}
