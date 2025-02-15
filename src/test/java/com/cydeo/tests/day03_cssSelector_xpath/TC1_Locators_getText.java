package com.cydeo.tests.day03_cssSelector_xpath;

import com.cydeo.utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC1_Locators_getText {
    /*
    1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/
3- Enter incorrect username: “incorrect”
4- Enter incorrect password: “incorrect”
5- Click to login button.
6- Verify error message text is as expected:
Expected: Incorrect login or password
     */

    public static void main(String[] args) {
        // 1- Open a chrome browser
        //WebDriver driver=new ChromeDriver();
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //2- Go to: https://login1.nextbasecrm.com/ //http://library2.cybertekschool.com/login.html
        driver.get("http://library2.cybertekschool.com/login.html");

        //3- Enter incorrect username: “incorrect”
        WebElement inputUsername= driver.findElement(By.className("login-inp"));
        inputUsername.sendKeys("incorrect");

        //4- Enter incorrect password: “incorrect”
        WebElement inputPassword = driver.findElement(By.name("USER_PASSWORD"));
        inputPassword.sendKeys("incorrect");

        //5- Click to login button.
        WebElement loginButton = driver.findElement(By.className("login-btn"));
        loginButton.click();

        //6- Verify error message text is as expected:
        //Expected: Incorrect login or password
        String expectedErrorText="Incorrect login or password";
        String actualErrorText=driver.findElement(By.className("errortext")).getText();

        if (actualErrorText.equals(expectedErrorText)){
            System.out.println("Error text verification PASSED!!!");
        }
        else{
            System.out.println("Error text verification FAILED!!!");
        }

    }
}
