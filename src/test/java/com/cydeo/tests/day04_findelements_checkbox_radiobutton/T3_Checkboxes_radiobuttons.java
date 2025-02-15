package com.cydeo.tests.day04_findelements_checkbox_radiobutton;

import com.cydeo.utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class T3_Checkboxes_radiobuttons {
    //TC#3: Checkboxes
    //1. Go to https://practice.cydeo.com/checkboxes
    //2. Confirm checkbox #1 is NOT selected by default
    //3. Confirm checkbox #2 is SELECTED by default.
    //4. Click checkbox #1 to select it.
    //5. Click checkbox #2 to deselect it.
    //6. Confirm checkbox #1 is SELECTED.
    //7. Confirm checkbox #2 is NOT selected.

    public static void main(String[] args) throws InterruptedException {
        //1. Go to https://practice.cydeo.com/checkboxes
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://practice.cydeo.com/checkboxes");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2. Confirm checkbox #1 is NOT selected by default

        //cssSellector version.
        //WebElement checkbox1 = driver.findElement(By.cssSelector("input#box1"));

       //xpath version
        WebElement checkbox1 = driver.findElement(By.xpath("//input[@id='box1']"));

        System.out.println("checkbox1.isSelected(), expecting false = " + checkbox1.isSelected());

        //3. Confirm checkbox #2 is SELECTED by default.

        //cssSellector version.
        //WebElement checkbox2 = driver.findElement(By.cssSelector("input#box2"));

        //xpath version
        WebElement checkbox2 = driver.findElement(By.xpath("//input[@id='box2']"));

        System.out.println("checkbox2.isSelected(), expecting true = " + checkbox2.isSelected());
        //4. Click checkbox #1 to select it.
        checkbox1.click();
        //5. Click checkbox #2 to deselect it.
        checkbox2.click();
        //6. Confirm checkbox #1 is SELECTED.
        System.out.println("checkbox1.isSelected(), expecting true = " + checkbox1.isSelected());
        //7. Confirm checkbox #2 is NOT selected.
        System.out.println("checkbox2.isSelected(), expecting false " + checkbox2.isSelected());

        //browser close
        Thread.sleep(2000);
        driver.close();

    }
}
