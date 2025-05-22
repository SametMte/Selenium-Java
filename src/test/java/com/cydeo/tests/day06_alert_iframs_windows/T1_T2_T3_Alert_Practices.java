package com.cydeo.tests.day06_alert_iframs_windows;

import com.cydeo.utility.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T1_T2_T3_Alert_Practices {
    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        //1. Open browser
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2. Go to website: http://practice.cydeo.com/javascript_alerts
        driver.get("http://practice.cydeo.com/javascript_alerts");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        //3. Click to “Click for JS Alert” button
        WebElement informationAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        informationAlertButton.click();
        Thread.sleep(2000);

        //4. Click to OK button from the alert
        Alert alert=driver.switchTo().alert();
        alert.accept();
        Thread.sleep(2000);

        //5. Verify “You successfully clicked an alert” text is displayed
        WebElement resultText=driver.findElement(By.xpath("//p[@id='result']"));

        //assertion
        Assert.assertTrue(resultText.isDisplayed(),"Result text is NOT displayed!");

        String expectedText="You successfully clicked an alert";
        String actualText=resultText.getText();

        Assert.assertEquals(actualText,expectedText,"Actual result text is NOT as expected!");
    }

    @Test
    public void test2() throws InterruptedException {
        //3. Click to “Click for JS Confirm” button
        WebElement confirmationAlert = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        confirmationAlert.click();
        Thread.sleep(1000);

        //4. Click to OK button from the alert
        Alert alert=driver.switchTo().alert();
        alert.accept();
        Thread.sleep(1000);

        //5. Verify “You clicked: Ok” text is displayed
        WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));

        //assertion
        Assert.assertTrue(resultText.isDisplayed(),"Result text is NOT displayed!");

        String expectedText="You clicked: Ok";
        String actualText=resultText.getText();

        Assert.assertEquals(actualText,expectedText,"Actual result text is NOT as expected!");

    }

    @Test
    public void test3() throws InterruptedException {
        //3. Click to “Click for JS Prompt” button
        WebElement promptAlert = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        promptAlert.click();
        Thread.sleep(2000);

        //4. Send “hello” text to alert,
        Alert alert=driver.switchTo().alert();
        alert.sendKeys("hello");
        Thread.sleep(2000);

        //5. Click to OK button from the alert
        alert.accept();
        Thread.sleep(2000);

        //6. Verify “You entered: hello” text is displayed
        WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));

        //assertion
        Assert.assertTrue(resultText.isDisplayed(),"Result text is NOT displayed!");

        String expectedText="You entered: hello";
        String actualText=resultText.getText();

        Assert.assertEquals(actualText,expectedText,"Actual result text is NOT as expected!");

    }
}
