package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Set;

public class MulltipleWindows {

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
    public void switchWindowsTest() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/windows");

        // get title
        System.out.println("Title before new window: " + driver.getTitle());
        Thread.sleep(2000);

        // click click here Link
        driver.findElement(By.linkText("Click Here")).click();
        Thread.sleep(2000);

        // get title again
        System.out.println("Title after new window: " + driver.getTitle());

        String currentWindowHandle = driver.getWindowHandle();
        System.out.println(currentWindowHandle);

        // we will switch to new window
        Set<String> windowHandles = driver.getWindowHandles();

        System.out.println("windowHandles.size() = " + windowHandles.size());

        for (String handle : windowHandles) {
            if(!handle.equals(currentWindowHandle)){
                driver.switchTo().window(handle);
            }
        }

        System.out.println("Title after switching window: " + driver.getTitle());

//        ArrayList<String> sj = (ArrayList<String>) windowHandles;

//        driver.switchTo().window(sj.get(sj.size()-1));
//
//        System.out.println("Title after switching window: " + driver.getTitle());

    }

    @Test
    public void moreThan2Window(){

        driver.get("http://practice.cybertekschool.com/windows");
        driver.findElement(By.linkText("Click Here")).click();

        Set<String> windowHandles = driver.getWindowHandles();

        System.out.println("Before switch: " + driver.getTitle());

        // loop thru each window

        for (String handle : windowHandles) {
            // one by one change it
            driver.switchTo().window(handle);

            // whenever your title equals to your expected window title
            if(driver.getTitle().equals("New Window")){
                // stop on that window
                break;
            }
        }

        System.out.println("After switch: " + driver.getTitle());




    }



}
