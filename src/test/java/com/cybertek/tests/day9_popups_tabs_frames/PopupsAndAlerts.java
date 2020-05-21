package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopupsAndAlerts {

    WebDriver driver;

    @BeforeMethod
    public void open(){
        driver = WebDriverFactory.getDriver("chrome");
    }

    @Test
    public void test() throws InterruptedException {
        Thread.sleep(2000);
        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");

        // locate and click Destroy the World button(lazy way)
        driver.findElement(By.xpath("//button[. = 'Destroy the World']")).click();

        // locate and click No button
        driver.findElement(By.cssSelector("//span[. = 'No']")).click();

    }

    @Test
    public void Alerts() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/javascript_alerts");

        // click the click for JS alert buton
        driver.findElement(By.xpath("(// button)[1]")).click();

        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);

        // click OK button on the alert
        alert.accept();

        // click on Click For JS Confirm
        driver.findElement(By.xpath("(// button)[2]")).click();
        Thread.sleep(2000);

        // click on Cancel button
        alert.dismiss();

        // click on Click for JS Prompt
        driver.findElement(By.xpath("(// button)[3]")).click();
        Thread.sleep(2000);

        // send keys to alert and click OK
        alert.sendKeys("Mike Smith");
        alert.accept();

    }

    @AfterMethod
    public void close(){
        driver.quit();
    }


}
