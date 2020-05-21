package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class tagNameLocator {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        Faker faker = new Faker();

        driver.get("http://practice.cybertekschool.com/sign_up");

        driver.findElement(By.tagName("input")).sendKeys("Mike Smith");

        driver.findElement(By.name("email")).sendKeys(faker.internet().emailAddress());

//        driver.findElement(By.tagName("button")).click();

        driver.findElement(By.className("radius")).click();

        driver.quit();





    }
}
