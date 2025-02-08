package com.tests.day02_locators_getText_getAttribute;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T2_LinkText_Practice {
    /*
        TC #2: Back and forth navigation
               1- Open a chrome browser
               2- Go to: https://practice.cydeo.com
               3- Click to A/B Testing from top of the list.
               4- Verify title is:
                    Expected: No A/B Test
               5- Go back to home page by using the .back();
               6- Verify title equals:
                    Expected: Practice
     */
    public static void main(String[] args) throws InterruptedException {
        //1- Open a chrome browser
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        //2- Go to: https://practice.cydeo.com
        driver.get("https://practice.cydeo.com");
        Thread.sleep(3000);

        //3- Click to A/B Testing from top of the list.
        //driver.findElement(By.linkText("A/B Testing")).click();
        WebElement abTestLink= driver.findElement(By.linkText("A/B Testing"));

        abTestLink.click();

        Thread.sleep(3000);

        //4- Verify title is:
        String expectedTitle="No A/B Test";
        String actualTitle= driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title verification PASSED!!!");
        }
        else{
            System.out.println("Title verification FAILED!!!");
        }
        Thread.sleep(3000);

        //5- Go back to home page by using the .back();
        driver.navigate().back();
        Thread.sleep(3000);

        //6- Verify title equals:
        String expectedTitle2="Practice";
        String actualTitle2 = driver.getTitle();

        if (actualTitle2.equals(expectedTitle2)){
            System.out.println("Title verification PASSED!!!");
        }
        else{
            System.out.println("Title verification FAILED!!!");
        }
        Thread.sleep(3000);

        //close the browser
        driver.close();

    }
}
