package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

public class WebDriverFactory {

    // write a static method that takes a string parameter name: browserType
    // based on the value of parameter
    // it will setup the browser and
    // the method must return chromedriver or firefoxdriver object
    // name: getDriver

    public static WebDriver getDriver(String browserType){

        WebDriver driver = null;

        switch(browserType.toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "opera":
                WebDriverManager.operadriver().setup();
                driver = new OperaDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "internet explorer": case "ie": case "internetexplorer":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
        }

        return driver;
    }
}
