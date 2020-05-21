package com.cybertek.tests.day7_testng_radioButton;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class cihatBeyinOrnegi {

    WebDriver driver;
    @Test
    public void testAmazonPage(){
        driver.get("http://www.amazon.com");
        String searchWord = "samsung";
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(searchWord);
        driver.findElement(By.cssSelector("input[value='Go']")).click();
        String actualTitle = driver.getTitle();
        Assert.assertNotEquals(actualTitle,searchWord);
        Assert.assertTrue(actualTitle.contains(searchWord),"verify the searchword is in the title");
    }
    @Test
    public void testYouTube(){
        driver.get("http://www.youtube.com");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("input[type='text']")).sendKeys("whats on your mind");
        driver.findElement(By.cssSelector("button#search-icon-legacy>yt-icon")).click();
        driver.findElement(By.xpath("//yt-formatted-string[text()=\"Madrugada - What's on your mind?\"]")).click();
    }
    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
