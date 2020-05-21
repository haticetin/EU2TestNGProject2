package com.cybertek.tests.day12_actions_jsexecuter;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class HoverTest {

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

    /*
        1. hover over each image in the website
        2. verify each name:user text is displayed
     */

    @Test
    public void test() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");
        List<WebElement> users = driver.findElements(By.tagName("img"));
        String expectedResult = "name: user";
        String actualResult;

        Actions actions = new Actions(driver);

        // 1st way
        for (int i=0; i<users.size(); i++) {
            actions.moveToElement(users.get(i)).perform();
            actualResult = driver.findElement(By.xpath("(//h5)[" + (i+1) + "]")).getText();
            Assert.assertEquals(actualResult, "name: user" + (i+1), "verify users are same");
        }

        // 2nd way
        for (int i=0; i<users.size(); i++) {
            actions.moveToElement(users.get(i)).perform();
            actualResult = driver.findElement(By.xpath("(//h5)[" + (i+1) + "]")).getText();
            expectedResult += (i+1);
            Assert.assertEquals(actualResult, expectedResult, "verify users are same");
            expectedResult = expectedResult.substring(0, expectedResult.length()-1);
        }
    }



}
