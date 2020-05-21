package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckBoxDemo {

    WebDriver driver;

    @BeforeMethod
    public void openBrowser(){
        driver = WebDriverFactory.getDriver("chrome");
    }


    @Test
    public void test1(){

        driver.get("http://practice.cybertekschool.com/checkboxes");
        WebElement checkBox1 = driver.findElement(By.xpath("//input[1]"));
        WebElement checkBox2 = driver.findElement(By.xpath("//input[2]"));


        // how to verify checkBox is selected or not?

        System.out.println("checkBox1.isSelected() = " + checkBox1.isSelected());
        System.out.println("checkBox2.isSelected() = " + checkBox2.isSelected());

        // how to click checkbox?
        checkBox1.click();
        checkBox2.click();

        // verify checkbox1 is not selected, checkbox2 is selected
        Assert.assertFalse(checkBox2.isSelected(), "Verify checkbox 1 is selected");
        Assert.assertTrue(checkBox1.isSelected(), "Verify checkbox 2 is NOT selected");
        
    }

    @AfterMethod
    public void close(){
        driver.quit();
    }
}
