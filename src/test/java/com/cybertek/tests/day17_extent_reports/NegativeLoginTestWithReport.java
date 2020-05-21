package com.cybertek.tests.day17_extent_reports;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTestWithReport extends TestBase {


    @Test
    public void wrongPasswordTest(){

        LoginPage loginPage = new LoginPage();

        extentLogger = report.createTest("Wrong Password Test");

        loginPage.usernameInput.get(1).sendKeys(ConfigurationReader.get("driver_username"));
        extentLogger.info("Enter Username: User1");
        String password = faker.internet().password();
        loginPage.passwordInput.sendKeys(password);
        extentLogger.info("Enter Password: " + password);
        loginPage.loginBtn.click();
        extentLogger.info("Click login button");
        extentLogger.info("verify page url");
        Assert.assertEquals(driver.getCurrentUrl(), ConfigurationReader.get("qa1_url"));

        // we put after assertion so if the assertion fails, it will not send pass to report
        extentLogger.pass("Wrong Password Test is passed");

    }

    @Test
    public void wrongUsernameTest(){

        LoginPage loginPage = new LoginPage();

        // name of the test for report
        extentLogger = report.createTest("Wrong Username Test");

        String username = faker.name().username();
        loginPage.usernameInput.get(0).sendKeys(username);
        extentLogger.info("Enter username: " + username);

        loginPage.passwordInput.sendKeys(ConfigurationReader.get("driver_password"));
        extentLogger.info("Enter password: UserUser123");

        loginPage.loginBtn.click();
        extentLogger.info("Click login button");

        extentLogger.info("verify page url");
        Assert.assertEquals(driver.getCurrentUrl(), ConfigurationReader.get("qa1_url")+"n");

        extentLogger.pass("Pass: Wrong Password Test");


    }


}
