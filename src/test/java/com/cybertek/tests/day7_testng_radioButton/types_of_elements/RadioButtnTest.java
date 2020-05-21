package com.cybertek.tests.day7_testng_radioButton.types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class RadioButtnTest {

    @Test
    public void radioBtnTest1(){

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement blueRadioButton = driver.findElement(By.id("blue"));
        WebElement redRadioButton = driver.findElement(By.id("red"));

        // how to check is radio button selected?
        System.out.println("blueRadioButton.isSelected() = " + blueRadioButton.isSelected());
        System.out.println("redRadioButton.isSelected() = " + redRadioButton.isSelected());

        // verify blue is selected red is not selected
        Assert.assertTrue(blueRadioButton.isSelected(), "verify Blue is selected");
        Assert.assertFalse(redRadioButton.isSelected(), "verify Red is NOT selected");

        // how to select radio button?
        // we use click method to select radio button
        redRadioButton.click();

        // verify blue is NOT selected red is selected
        Assert.assertFalse(blueRadioButton.isSelected(), "verify Blue is NOT selected");
        Assert.assertTrue(redRadioButton.isSelected(), "verify Red is selected");

        driver.quit();
        
    }

}
