package com.tests.day02_locators_getText_getAttribute;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T3_GoogleSearch {
    /*
    TC#3: Google search
1- Open a chrome browser
2- Go to: https://google.com
3- Write “apple” in search box
4- Press ENTER to search
5- Verify title:
Expected: Title should start with “apple” word
     */
    public static void main(String[] args) throws InterruptedException {
        //1- Open a chrome browser
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        //2- Go to: https://google.com
        driver.get("https://google.com");
        Thread.sleep(2000);
        //3- Write “apple” in search box
        //a. locate search box
        WebElement googleSearchBox = driver.findElement(By.name("q"));
        //enter "apple" key, and press ENTER
        googleSearchBox.sendKeys("apple"+Keys.ENTER);
        Thread.sleep(2000);
        //4- Press ENTER to search
        //googleSearchBox.sendKeys(Keys.ENTER);
        //Thread.sleep(2000);

        //5- Verify title
        String expectedTitleStartWith="apple";
        String actualTitle=driver.getTitle();

        if (actualTitle.startsWith(expectedTitleStartWith)){
            System.out.println("Title verification PASSED!!!");
        }
        else{
            System.out.println("Title verification FAILED!!!");
        }
        Thread.sleep(2000);
        //close the driver
        driver.close();



    }
}
