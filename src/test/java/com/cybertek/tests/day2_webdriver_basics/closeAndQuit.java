package com.cybertek.tests.day2_webdriver_basics;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class closeAndQuit {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com");

        // wait 2 sec
        Thread.sleep(2000);

        // close() --> close the current tab/window
        driver.close();

        driver = new ChromeDriver();    // bu line olmazsa onceki tab kapanacak ve obje kaybolmus olacak o yuzden kodun kalan kismini run edemeyecek
                                        // cok yapilan bir sey degil genelde close() ve quit() en sonda kullanilir

        driver.get("http://practice.cybertekschool.com/open_new_tab");
        Thread.sleep(5000);

        // quit() --> close all tabs doesnt matter one or more
        driver.quit();



    }
}
