package com.cybertek.tests.day2_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class getTitleandUrl {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com");
        driver.get("http://facebook.com");
        // getTitle() --> get you title of the page
        // getting title with selenium
        String title = driver.getTitle();
        System.out.println("title = " + title);     // soutv --> shortcut

        String currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);

        // getPageSource  --> gets the page source code
        String pageSource = driver.getPageSource();
        System.out.println("pageSource = " + pageSource);




    }
}
