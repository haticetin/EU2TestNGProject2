package com.cybertek.tests.day1_intro;

import io.github.bonigarcia.wdm.ChromiumDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenBrowser {

    public static void main(String[] args) {

        // we have to enter this line every time we want to open chrome
        // hey WebDriverManager, can you make chrome ready for me for automation
        WebDriverManager.chromedriver().setup();

        // WebDriver represents the browser
        // we are creating driver for chrome browser
        // new ChromeDriver() --> this part will open chrome browser
        WebDriver chrome = new ChromeDriver();
        chrome.get("https://www.youtube.com");

        // firefox navigation
        WebDriverManager.firefoxdriver().setup();

        WebDriver firefox = new FirefoxDriver();
        firefox.get("https://wwww.amazon.com");

    }
}
