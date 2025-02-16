package com.cydeo.tests.day05_testNG_intro_dropdowns;

import com.cydeo.utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class T2_radio_buttons {
    //TC #2: Radiobutton handling
    //1. Open Chrome browser
    //2. Go to https://practice.cydeo.com/radio_buttons
    //3. Click to “Hockey” radio button
    //4. Verify “Hockey” radio button is selected after clicking

    public static void main(String[] args) throws InterruptedException {
        //1. Open Chrome browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //2. Go to https://practice.cydeo.com/radio_buttons
        driver.get("https://practice.cydeo.com/radio_buttons");
        //3. Click to “Hockey” radio button
        WebElement hockeyRadioBtn = driver.findElement(By.xpath("//input[@id='hockey']"));

        Thread.sleep(2000);
        hockeyRadioBtn.click();

        //4. Verify “Hockey” radio button is selected after clicking
        if (hockeyRadioBtn.isSelected()){
            System.out.println("Button is selected. Verification PASSED!");
        }
        else {
            System.out.println("Button is NOT selected. Verification FAILED!");
        }
        Thread.sleep(2000);
        //close driver
        driver.close();

    }
}
