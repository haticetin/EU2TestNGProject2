package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AttributeTest {

    WebDriver driver;

    @BeforeMethod
    public void openBrowser(){
        driver = WebDriverFactory.getDriver("chrome");
    }

    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        WebElement radioButton = driver.findElement(By.id("blue"));

        // get the value of type attribute
        System.out.println(radioButton.getAttribute("type"));

        // get the value of name attribute
        System.out.println(radioButton.getAttribute("name"));

        // get the value of checked attribute
        // since checked attribute does not keep any value it will return true or false based on the condition
        System.out.println(radioButton.getAttribute("checked"));

        // get the value of href attribute
        // trying to get attribute not existing
        // when we use non existing attribute it will return NULL to us
        System.out.println(radioButton.getAttribute("href"));

        System.out.println(radioButton.getAttribute("outerHTML"));

        System.out.println(radioButton.getAttribute("value"));

        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        WebElement button2 = driver.findElement(By.name("button2"));
        System.out.println(button2.getAttribute("outerHTML"));

        Assert.assertTrue(radioButton.isSelected(), "verify radioButton is selected");


    }

    @AfterMethod
    public void close(){
        driver.quit();
    }


}
