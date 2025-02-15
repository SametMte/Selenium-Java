package com.cydeo.tests.day03_cssSelector_xpath;

import com.cydeo.utility.VerifyTest;
import com.cydeo.utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC2_locators_getText_getAttribute {
    /*
    TC #2: NextBaseCRM, locators, getText(), getAttribute() practice
        1- Open a chrome browser
        2- Go to: https://login1.nextbasecrm.com/
        3- Verify “remember me” label text is as expected:
            Expected: Remember me on this computer
        4- Verify “forgot password” link text is as expected:
            Expected: Forgot your password?
        5- Verify “forgot password” href attribute’s value contains expected:
            Expected: forgot_password=yes
     */
    public static void main(String[] args) {
        //1- Open a chrome browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");

        //2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        //3- Verify “remember me” label text is as expected:
        //Expected: Remember me on this computer
        String expectedLabelText="Remember me on this computer";
        String actualLabelText= driver.findElement(By.className("login-item-checkbox-label")).getText();

        VerifyTest.verify(expectedLabelText,actualLabelText,"Label");

        //4- Verify “forgot password” link text is as expected:
        //Expected: Forgot your password?
        String expectedForgotPasswordText="FORGOT YOUR PASSWORD?";
        WebElement forgotPasswordLink= driver.findElement(By.className("login-link-forgot-pass"));
        String actualForgotPasswordText =forgotPasswordLink.getText();

        VerifyTest.verify(expectedForgotPasswordText,actualForgotPasswordText,"FPT");

        //5- Verify “forgot password” href attribute’s value contains expected:
        //Expected: forgot_password=yes
        String expectedInHref="forgot_password=yes";
        String actualInHref=forgotPasswordLink.getAttribute("href");

        if (actualInHref.contains(expectedInHref)){
            System.out.println("HREF attribute value is as EXPECTED. PASS!");
        }
        else {
            System.out.println("HREF attribute value is NOT  as EXPECTED. FAIL!");
        }

    }
}
