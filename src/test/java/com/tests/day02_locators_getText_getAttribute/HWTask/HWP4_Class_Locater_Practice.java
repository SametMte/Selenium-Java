package com.tests.day02_locators_getText_getAttribute.HWTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HWP4_Class_Locater_Practice {
    /*
    TC #4: Practice Cydeo – Class locator practice
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/inputs
3- Click to “Home” link
4- Verify title is as expected:
Expected: Practice
     */
    public static void main(String[] args) throws InterruptedException {
        //1- Open a chrome browser
        WebDriver driver=new ChromeDriver();

        //2- Go to: https://practice.cydeo.com/inputs
        driver.get("https://practice.cydeo.com/inputs");

        //3- Click to “Home” link
        //Locating the "Home" link web element
        WebElement home = driver.findElement(By.className("nav-link"));

        //Click to the home link
        home.click();

        //4- Verify title is as expected:
        String expectedTitle="Practice";
        String actualTitle=driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title verification PASSED!!!");
        }
        else{
            System.out.println("Title verification FAILED!!!");
        }
        Thread.sleep(1000);
        //close the browser
        driver.close();

    }
}
