package com.cydeo.tests.day04_findelements_checkbox_radiobutton;

import com.cydeo.utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class T4_StaleElementReferenceException {
    //TC #4: StaleElementReferenceException Task
    //1- Open a chrome browser
    //2- Go to: https://practice.cydeo.com/abtest
    //3- Locate “CYDEO” link, verify it is displayed.
    //4- Refresh the page.
    //5- Verify it is displayed, again

    public static void main(String[] args) {
        //1- Open a chrome browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2- Go to: https://practice.cydeo.com/abtest
        driver.get("https://practice.cydeo.com/abtest");

        //3- Locate “CYDEO” link, verify it is displayed.
        WebElement cydeoLink = driver.findElement(By.xpath("//a[.='CYDEO']"));
        System.out.println("before refresh: cydeoLocator.isDisplayed() = " + cydeoLink.isDisplayed());
        //4- Refresh the page.
        driver.navigate().refresh();
        System.out.println("Refreshing the page...");
        //5- Verify it is displayed, again
        //reassign again web element for fix StaleElementReferenceException expection
        cydeoLink = driver.findElement(By.xpath("//a[.='CYDEO']"));
        System.out.println("after refresh: cydeoLocator.isDisplayed() = " + cydeoLink.isDisplayed());
    }
}
