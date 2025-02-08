package com.tests.day02_locators_getText_getAttribute.HWTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HWP2_Zerobank_Header {
    /*
    HWP #2: Zero Bank header verification
1. Open Chrome browser
2. Go to http://zero.webappsecurity.com/login.html
3. Verify header text
Expected: “Log in to ZeroBank”
     */
    public static void main(String[] args) throws InterruptedException {
        //1. Open Chrome browser
        WebDriver driver= new ChromeDriver();
        //2. Go to http://zero.webappsecurity.com/login.html
        driver.get("http://zero.webappsecurity.com/login.html");

        //3. Verify header text
        WebElement header = driver.findElement(By.tagName("h3"));
        String expectedHeader="Log in to ZeroBank";
        String actualHeader=header.getText();

        if (actualHeader.equals(expectedHeader)){
            System.out.println("Header verification PASSED!!!");
        }
        else{
            System.out.println("Header verification FAILED!!!");
        }
        Thread.sleep(1000);

        //close the browser
        driver.close();

    }
}
