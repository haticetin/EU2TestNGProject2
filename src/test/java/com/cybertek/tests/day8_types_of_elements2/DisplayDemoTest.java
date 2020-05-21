package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DisplayDemoTest {

    WebDriver driver;

    @BeforeMethod
    public void open(){
        driver = WebDriverFactory.getDriver("chrome");
    }

    @Test
    public void test1() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");
        WebElement userNameInput = driver.findElement(By.id("username"));
        System.out.println("userNameInput.isDisplayed() = " + userNameInput.isDisplayed());

        // verify that username not displayed in the screen
        Assert.assertFalse(userNameInput.isDisplayed(), "verify inputbox not displayed");

        // click start button
        WebElement startButton = driver.findElement(By.xpath("//button[.='Start']"));
        startButton.click();
        Thread.sleep(6000);

        // verify username displayed on the screen
        Assert.assertTrue(userNameInput.isDisplayed(), "verify username input displayed");

    }

    @AfterMethod
    public void close(){
        driver.quit();
    }



}
