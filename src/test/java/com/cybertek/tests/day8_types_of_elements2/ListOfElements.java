package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ListOfElements {

    WebDriver driver;

    @BeforeMethod
    public void open(){
        driver = WebDriverFactory.getDriver("chrome");
    }

    @Test
    public void test1(){

        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        System.out.println("buttons.size() = " + buttons.size());

        // verify we have 6 buttons
        Assert.assertEquals(buttons.size(), 6, "verify we have 6 button");

        for (WebElement button : buttons) {     // iter --> shortcut for for each loop
            System.out.println(button.getText());
        }

        // get only second button from the list
        buttons.get(1).click();
//        buttons.add(driver.findElement(By.id("content")));        // oluyo mu diye denedim ve oluyo
//        System.out.println(buttons.get(buttons.size() - 1));

    }

    @Test
    public void test2(){

        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        List<WebElement> buttons = driver.findElements(By.tagName("ksjlsajxlajl"));
        System.out.println("buttons.size() = " + buttons.size());
        WebElement button = driver.findElement(By.tagName("sdiajsdaodkao"));
    }

    @AfterMethod
    public void close(){
        driver.quit();
    }



}
