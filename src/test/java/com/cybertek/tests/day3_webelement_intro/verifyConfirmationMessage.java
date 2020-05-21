package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyConfirmationMessage {

    public static void main(String[] args) throws InterruptedException {

        /*
         * Verify confirmation message
         * open browser
         * go to http://practice.cybertekschool.com/forgot_password Links to an external site.
         * enter "test@cybertekschool.com" email
         * verify that email is displayed in the input box
         * click on Retrieve password
         * verify that confirmation message says 'Your e-mail's been sent!'
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        Faker faker = new Faker();

        driver.get("http://practice.cybertekschool.com/forgot_password");

        WebElement emailInputBox = driver.findElement(By.name("email"));

        String expectedEmail = faker.internet().emailAddress();

        emailInputBox.sendKeys(expectedEmail);

        // somehow we should get text from webelements
        // two main ways to get text frm web elements
        // 1. getText() --> it will work %99 and it will return String
        // 2. getAttribute("value") --> second way of getting text especially inputboxes
        String actualEmail = emailInputBox.getAttribute("value");

        // verify email is displayed
        if(actualEmail.equals(expectedEmail)){
            System.out.println("Pass");
        }else{
            System.out.println("FAIL");
            System.out.println("actualEmail = " + actualEmail);
            System.out.println("expectedEmail = " + expectedEmail);
        }

        // click on retrieve password button
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));

        // click() --> clicking web element
        retrievePasswordButton.click();

        // verify confirmation message
        WebElement actualConfirmationMessage = driver.findElement(By.name("confirmation_message"));

        // save expected message that is coming from faker
        String expectedMessage = "Your e-mail's been sent!";

        // save actual message that is coming from browser
        String actualMessage = actualConfirmationMessage.getText();

        // verify
        if(actualMessage.equals(expectedMessage)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("actualMessage = " + actualMessage);
            System.out.println("expectedMessage = " + expectedMessage);
        }

        Thread.sleep(1000);
        driver.quit();


    }
}
