package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class iframes {

    WebDriver driver;

    @BeforeMethod
    public void open(){
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void close(){
        driver.quit();
    }

    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/frames");

        // how to switch frames
        // 1. Switch by using name or id attribute of iframe
        driver.switchTo().frame("msdskjdsj");

        // clear before sendKeys
        driver.findElement(By.id("tinymce")).clear();
        driver.findElement(By.id("tinymce")).sendKeys("Mike Smith");






    }




}
