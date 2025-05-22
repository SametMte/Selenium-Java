package com.cydeo.tests.day06_alert_iframs_windows;

import com.cydeo.utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Dropdowns_T6_T7_T8 {
    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        //1. Open Chrome browser
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");

    }

    @AfterMethod
    public void tearDown(){

       //driver.quit();
    }

    @Test

    public void test1() throws InterruptedException {
        //3. Select “December 1st, 1933” and verify it is selected.
        Select yearDropdown=new Select(driver.findElement(By.xpath("//select[@id='year']")));
        Select monthDropdown =new Select(driver.findElement(By.xpath("//select[@id='month']")));
        Select dayDropdown =new Select(driver.findElement(By.xpath("//select[@id='day']")));

        //Select year using : visible text
        Thread.sleep(2000);
        yearDropdown.selectByVisibleText("1933");
        //Select month using : value attribute
        Thread.sleep(2000);
        monthDropdown.selectByValue("11");
        //Select day using : index number
        Thread.sleep(2000);
        dayDropdown.selectByIndex(0);

        //getting expected values from browser
        String expectedYear="1933";
        String expectedMonth="December";
        String expectedDay="1";

        //getting actual values from browser
        String actualYear=yearDropdown.getFirstSelectedOption().getText();
        String actualMonth=monthDropdown.getFirstSelectedOption().getText();
        String actualDay=dayDropdown.getFirstSelectedOption().getText();

        //create Assertions
        Assert.assertTrue(actualYear.equals(expectedYear));
        Assert.assertTrue(actualMonth.equals(expectedMonth));
        Assert.assertTrue(actualDay.equals(expectedDay));
    }

    @Test
    public void test2() throws InterruptedException {
        //locate the dropdown and create select object
        Select stateDropdown=new Select(driver.findElement(By.xpath("//select[@id='state']")));

        //3. Select Illinois
        Thread.sleep(2000);
        stateDropdown.selectByVisibleText("Illinois");

        //4. Select Virginia
        Thread.sleep(2000);
        stateDropdown.selectByValue("VA");

        //5. Select California
        Thread.sleep(2000);
        stateDropdown.selectByIndex(5);

        //6. Verify final selected option is California.
        String expectedState="California";
        String actualState=stateDropdown.getFirstSelectedOption().getText();

        //Assertion
        Assert.assertTrue(actualState.equals(expectedState));
    }

    @Test
    public void test3() throws InterruptedException {
        //3. Click to non-select dropdown
        //locate the non-select dropdown
        WebElement nonSelectDropdown = driver.findElement(By.xpath("//a[@id='dropdownMenuLink']"));
        nonSelectDropdown.click();
        Thread.sleep(2000);

        //4. Select Facebook from dropdown
        WebElement facebook = driver.findElement(By.linkText("Facebook"));
        facebook.click();
        Thread.sleep(2000);

        //5. Verify title is “Facebook - Giriş Yapın veya Kaydolun"
        String expectedTitle="Facebook - Giriş Yap veya Kaydol";
        String actualTitle=driver.getTitle();

        //assertion
        Assert.assertTrue(actualTitle.equals(expectedTitle));
    }

}
