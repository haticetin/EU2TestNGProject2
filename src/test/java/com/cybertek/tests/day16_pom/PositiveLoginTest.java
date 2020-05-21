package com.cybertek.tests.day16_pom;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTest extends TestBase {



    @Test
    public void loginAsSalesManager(){

        LoginPage loginPage = new LoginPage();

        String username = ConfigurationReader.get("salesmanager_username");
        String password = ConfigurationReader.get("salesmanager_password");

        loginPage.login(username, password);

        String expectedUrl = ConfigurationReader.get("url");

        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "verify login successfully");

    }

    @Test
    public void loginAsStoreManager(){

        LoginPage loginPage = new LoginPage();

        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");

        loginPage.login(username, password);

        String expectedUrl = ConfigurationReader.get("url");

        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "verify login successfully");


    }




}
