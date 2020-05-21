package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SelectClassTest {

    WebDriver driver;

    @BeforeMethod
    public void open(){
        driver = WebDriverFactory.getDriver("chrome");
    }

    @Test
    public void test1(){

        driver.get("http://practice.cybertekschool.com/dropdown");

        // 1. locate your dropdown just like any other webelement with unique locator
        WebElement dropDownElement = driver.findElement(By.id("state"));

        // 2. create Select object by passing that element as a constructor
        Select stateDropdown = new Select(dropDownElement);

        // getOptions --> returns all the available options from the dropdown list
        List<WebElement> options = stateDropdown.getOptions();

        // print size of the options
        System.out.println(options.size());

        for (WebElement option : options) {
            System.out.println(option.getText());
        }

    }

    @Test
    public void test2() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/dropdown");

        // 1. locate your dropdown just like any other WebElement with unique locator
        WebElement dropDownElement = driver.findElement(By.id("state"));

        // 2. create Select object by passing that element as a constructor
        Select stateDropdown = new Select(dropDownElement);

        // verify that first selection is Select a state
        String expectedOption = "Select a State";

                                                // returns WebElement
        String actualSelection = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualSelection, expectedOption, "verify first selection");


        //  how to select options from dropdown
        // 1. select using visible text
        Thread.sleep(2000);
        stateDropdown.selectByVisibleText("California");


        expectedOption = "California";
        String actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption, expectedOption);

        // 2. select using index
        Thread.sleep(2000);
        stateDropdown.selectByIndex(51);

        expectedOption = "Wyoming";
        actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption, expectedOption);

        // 3. select by value
        Thread.sleep(2000);
        stateDropdown.selectByValue("DC");
        expectedOption = "District Of Columbia";
        actualOption = stateDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualOption, expectedOption);


    }

    @AfterMethod
    public void close() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

}
