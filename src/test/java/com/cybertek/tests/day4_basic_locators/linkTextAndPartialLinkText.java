package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class linkTextAndPartialLinkText {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/dynamic_loading");

        WebElement link6 = driver.findElement(By.linkText("Example 6: Loading overlay that disappears and disappears again"));
        WebElement link5 = driver.findElement(By.linkText("Example 5: Loading overlay that disappears after time"));

        WebElement link1 = driver.findElement(By.partialLinkText("Example 1"));
        link1.click();

        driver.quit();
    }
}
