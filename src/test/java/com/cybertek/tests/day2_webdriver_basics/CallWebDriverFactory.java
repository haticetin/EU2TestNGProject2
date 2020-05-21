package com.cybertek.tests.day2_webdriver_basics;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class CallWebDriverFactory {

    public static void main(String[] args) {

        // not a good way
        WebDriverFactory.getDriver("FiRefox").get("http://www.google.com");

        // better way; we will need object later on
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://google.com");

    }

}
