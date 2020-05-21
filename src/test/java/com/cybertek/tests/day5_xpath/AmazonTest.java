package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://www.amazon.com");

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("selenium");

        driver.findElement(By.xpath("//input[@type='submit']")).click();

        Thread.sleep(1000);

        System.out.println(driver.findElement(By.xpath("//span[@dir='auto']")).getText());

        driver.quit();
    }
}
