package com.tests.day02_locators_getText_getAttribute;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T5_getText_getAttribute {
    /*
    TC #5: getText() and getAttribute() method practice
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/registration_form
3- Verify header text is as expected:
Expected: Registration form
4- Locate “First name” input box
5- Verify placeholder attribute’s value is as expected:
Expected: first name
     */
    public static void main(String[] args) throws InterruptedException {
        //1- Open a chrome browser
        WebDriver driver=new ChromeDriver();

        //2- Go to: https://practice.cydeo.com/registration_form
        driver.get("https://practice.cydeo.com/registration_form");
        Thread.sleep(1000);

        //3- Verify header text is as expected:
        WebElement header = driver.findElement(By.tagName("h2"));

        String expectedText="Registration form";
        String actualText=header.getText();

        if (actualText.equals(expectedText)){
            System.out.println("Header text verification PASSED!!!");
        }
        else{
            System.out.println("Header text verification FAILED!!!");
        }

        Thread.sleep(1000);
        //4- Locate “First name” input box
        WebElement firstNameInput = driver.findElement(By.className("form-control"));

        //5- Verify placeholder attribute’s value is as expected:
        String expectedValue="first name";
        String actualValue = firstNameInput.getAttribute("placeholder");

        if (actualText.equals(expectedText)){
            System.out.println("Placeholder verification PASSED!!!");
        }
        else{
            System.out.println("Placeholder verification FAILED!!!");
        }

        Thread.sleep(1000);
        //close the browser
        driver.close();



    }
}
