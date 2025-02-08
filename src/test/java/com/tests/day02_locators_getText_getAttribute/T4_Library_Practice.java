package com.tests.day02_locators_getText_getAttribute;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T4_Library_Practice {
    /*
    1. Open Chrome browser
2. Go to http://library2.cybertekschool.com/login.html
3. Enter username: “incorrect@email.com”
4. Enter password: “incorrect password”
5. Verify: visually “Sorry, Wrong Email or Password”

     */
    public static void main(String[] args) throws InterruptedException {
        // 1. Open Chrome browser
        WebDriver driver=new ChromeDriver();
        Thread.sleep(1000);
        //2. Go to http://library2.cybertekschool.com/login.html
        driver.get("http://library2.cybertekschool.com/login.html");
        Thread.sleep(1000);
        //3. Enter username: “incorrect@email.com”
        WebElement userName = driver.findElement(By.className("form-control"));
        userName.sendKeys("incorrect@email.com");
        Thread.sleep(1000);
        //4. Enter password: “incorrect password”
        WebElement userPassword=driver.findElement(By.id("inputPassword"));
        userPassword.sendKeys("incorrect password");
        Thread.sleep(1000);
        //press Sign in
        WebElement button = driver.findElement(By.tagName("button"));
        button.click();
        Thread.sleep(1000);
        //5. Verify: visually “Sorry, Wrong Email or Password”
        //verified

        //close the browser
        driver.close();
    }
}
