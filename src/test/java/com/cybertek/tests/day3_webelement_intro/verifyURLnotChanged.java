package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyURLnotChanged {

    public static void main(String[] args) {

        /*
            open chrome browser
            go to http://practice.cybertekschool.com/forgot_password links to an external site
            click on retrieve password
            verify that URL did not change
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/forgot_password");

        String expectedURL = driver.getCurrentUrl();

        // click on Retrieve password
        // WebElement --> Interface that represent elements on the webpage
        // findElement --> method used to find element on a webpage
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));

        // click() --> clicking web element
        retrievePasswordButton.click();

        // verify that URL did not change
        String actualURL = driver.getCurrentUrl();

        if(actualURL.equals(expectedURL)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

        driver.quit();

    }
}
