package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class nameLocatorTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        Faker faker = new Faker();

        //make browser fullscreen
        driver.manage().window().maximize();
        driver.manage().window().fullscreen();

        driver.get("http://practice.cybertekschool.com/sign_up");

        // put some email and click sign up button
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys(faker.internet().emailAddress());

        // proper way
//        WebElement signUp = driver.findElement(By.name("wooden_spoon"));
//        signUp.click();


        // lazy way
        driver.findElement(By.name("wooden_spoon")).click();

        // verify "Thank you for signing up. Click the button below to return to the home page."
        WebElement signUpMessage = driver.findElement(By.name("signup_message"));
        String expectedMessage = "Thank you for signing up. Click the button below to return to the home page.";
        String actualMessage = signUpMessage.getText();

        if(actualMessage.equals(expectedMessage)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("expectedMessage = " + expectedMessage);
            System.out.println("actualMessage = " + actualMessage);
        }

        Thread.sleep(2000);
        driver.quit();

    }
}
