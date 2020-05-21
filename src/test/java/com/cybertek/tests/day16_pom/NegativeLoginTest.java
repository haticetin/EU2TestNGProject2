package com.cybertek.tests.day16_pom;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.WebDriverFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestBase {

    @Test
    public void wrongPasswordTest(){

        LoginPage loginPage = new LoginPage();

        loginPage.usernameInput.get(1).sendKeys(ConfigurationReader.get("driver_username"));
        loginPage.passwordInput.sendKeys(faker.internet().password());
        loginPage.loginBtn.click();

        Assert.assertEquals(driver.getCurrentUrl(), ConfigurationReader.get("qa1_url"));

    }

    @Test
    public void wrongUsernameTest(){

        LoginPage loginPage = new LoginPage();

        loginPage.usernameInput.get(0).sendKeys(faker.name().username());
        loginPage.passwordInput.sendKeys(ConfigurationReader.get("driver_password"));
        loginPage.loginBtn.click();

        Assert.assertEquals(driver.getCurrentUrl(), ConfigurationReader.get("qa1_url"));

    }


}
