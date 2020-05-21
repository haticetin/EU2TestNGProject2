package com.cybertek.tests.day12_actions_jsexecuter;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptExecutorDemo {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void close() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
    }

    @Test
    public void clickWithJS(){
        driver.get("http://practice.cybertekschool.com/");

        WebElement dropDownLink = driver.findElement(By.linkText("Dropdown"));

        // clicking with JavaScriptExecutor
        // create js executor object
        JavascriptExecutor jse = (JavascriptExecutor)driver;

        // use executeScript
        // click with js using selenium
        jse.executeScript("arguments[0].click();", dropDownLink);

    }

    @Test
    public void type(){
        driver.get("http://practice.cybertekschool.com/dynamic_controls");
        WebElement inputbox = driver.findElement(By.cssSelector("#input-example>input"));

//        inputbox.sendKeys("Some Text");

        JavascriptExecutor jse = (JavascriptExecutor)driver;

        // type to disabled input box with js using selenium
        String value = "Some Text";
        jse.executeScript("arguments[0].value='"+ value +"';", inputbox);

    }

    @Test
    public void scrollDownandUp() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        driver.manage().window().maximize();
        JavascriptExecutor jse = (JavascriptExecutor)driver;


        // scroll down and up with js using selenium

        // scrolling down once
        jse.executeScript("scroll(0, 250);");

        Thread.sleep(1000);

        // scrolling up once
        jse.executeScript("scroll(0, -250);");

        // scrolling down 10 times
        for(int i=0; i<10; i++){
            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0, 250);");
        }

        // scrolling up 10 times
        for(int i=0; i<10; i++){
            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0, -250);");
        }

    }




}
