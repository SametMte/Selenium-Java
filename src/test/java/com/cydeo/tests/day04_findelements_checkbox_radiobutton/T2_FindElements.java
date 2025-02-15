package com.cydeo.tests.day04_findelements_checkbox_radiobutton;

import com.cydeo.utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class T2_FindElements {
    //TC #2: FindElements Task
    //1- Open a chrome browser
    //2- Go to: https://practice.cydeo.com/abtest
    //3- Locate all the links in the page.
    //4- Print out the number of the links on the page.
    //5- Print out the texts of the links.
    //6- Print out the HREF attribute values of the links
    public static void main(String[] args) {
        //1- Open a chrome browser
        WebDriver driver=WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //2- Go to: https://practice.cydeo.com/abtest
        driver.get("https://practice.cydeo.com/abtest");

        //3- Locate all the links in the page.
        List<WebElement> listOfLinks = driver.findElements(By.tagName("a"));
        //4- Print out the number of the links on the page.
        System.out.println("allLink.size() = " + listOfLinks.size());
        //5- Print out the texts of the links.
        //6- Print out the HREF attribute values of the links
        for (WebElement each: listOfLinks){
            System.out.println("Text of links: " + each.getText());
            System.out.println("HREF attributes' values: "+each.getAttribute("href"));
        }


    }
}
