package com.cydeo.tests.day04_findelements_checkbox_radiobutton;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_Xpath_CssSelector_Practices {
    /*
    TC #1: XPATH and cssSelector Practices
1. Open Chrome browser
2. Go to https://practice.cydeo.com/forgot_password
3. Locate all the WebElements on the page using XPATH and/or CSS
locator only (total of 6)
a. “Home” link
b. “Forgot password” header
c. “E-mail” text
d. E-mail input box
e. “Retrieve password” button
f. “Powered by Cydeo text
4. Verify all web elements are displayed.
     */

    public static void main(String[] args) throws InterruptedException {
        //1. Open Chrome browser
        WebDriver driver=new ChromeDriver();

        //2. Go to https://practice.cydeo.com/forgot_password
        driver.get("https://practice.cydeo.com/forgot_password");

        //3. Locate all the WebElements on the page using XPATH and/or CSS
        //locator only (total of 6)

        //a. “Home” link

        //Locate "Home" link,using cssSelector, syntax#1, class attribute value
        WebElement homeLink_ex1 = driver.findElement(By.cssSelector("a[class='nav-link']"));

        //Locate "Home" link,using cssSelector, syntax#2, class attribute value
        WebElement homeLink_ex2 = driver.findElement(By.cssSelector("a.nav-link"));

        //Locate "Home" link,using cssSelector, syntax#1, href attribute value
        WebElement homeLink_ex3 = driver.findElement(By.cssSelector("a[href='/']"));


        //b. “Forgot password” header

        //Locate header, using xpath, using text of h2
        WebElement header_ex1 = driver.findElement(By.xpath("//h2[.='Forgot Password']"));

        //Locate header, using cssSelector, syntax#1, locate parent element and move down to h2
        WebElement header_ex2 = driver.findElement(By.cssSelector("div[class='example'] > h2"));
        //Locate header, using cssSelector, syntax#2, locate parent element and move down to h2
        WebElement header_ex3 = driver.findElement(By.cssSelector("div.example > h2"));

        //c. “E-mail” text
        //locate the 'email' table using xpath
        WebElement eMail_ex1=driver.findElement(By.xpath("//label[@for='email']"));
       WebElement eMail_ex2=driver.findElement(By.xpath("//label[.='E-mail']"));


        //d. E-mail input box
        //locate the 'email' input box using xpath
        WebElement eMailInput_ex1=driver.findElement(By.xpath("//input[@name='email']"));

        //locate the 'email' input box using xpath contains method
        //tagName[contains(@attribute, 'value)]
        WebElement eMailInput_ex2=driver.findElement(By.xpath("//input[contains(@pattern, 'a-z')]"));

        //e. “Retrieve password” button
        //locate it using xpath
        WebElement retrievePasswordButton_ex1=driver.findElement(By.xpath("//button[@id='form_submit']"));

        //f. “Powered by Cydeo text
        WebElement retrievePasswordButton=driver.findElement(By.xpath("//div[@style='text-align: center;']") );

        //4. Verify all web elements are displayed.
        System.out.println("homeLink_ex1.isDisplayed() = " + homeLink_ex1.isDisplayed());
        System.out.println("homeLink_ex2.isDisplayed() = " + homeLink_ex2.isDisplayed());
        System.out.println("homeLink_ex3.isDisplayed() = " + homeLink_ex3.isDisplayed());
        System.out.println("header_ex1.isDisplayed() = " + header_ex1.isDisplayed());
        System.out.println("header_ex2.isDisplayed() = " + header_ex2.isDisplayed());
        System.out.println("header_ex3.isDisplayed() = " + header_ex3.isDisplayed());
        System.out.println("eMail_ex1.isDisplayed() = " + eMail_ex1.isDisplayed());
        System.out.println("eMail_ex2.isDisplayed() = " + eMail_ex2.isDisplayed());
        System.out.println("eMailInput_ex1.isDisplayed() = " + eMailInput_ex1.isDisplayed());
        System.out.println("eMailInput_ex2.isDisplayed() = " + eMailInput_ex2.isDisplayed());
        System.out.println("retrievePasswordButton_ex1.isDisplayed() = " + retrievePasswordButton_ex1.isDisplayed());
        System.out.println("retrievePasswordButton.isDisplayed() = " + retrievePasswordButton.isDisplayed());
        //wait 2 second before closing the browser
        Thread.sleep(2000);
        driver.close();
    }
}
