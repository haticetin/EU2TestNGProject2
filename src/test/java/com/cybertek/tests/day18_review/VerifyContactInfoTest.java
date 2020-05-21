package com.cybertek.tests.day18_review;

import com.cybertek.pages.ContactInfoPage;
import com.cybertek.pages.ContactsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.security.auth.login.Configuration;

public class VerifyContactInfoTest extends TestBase {

    @Test
    public void contactDetailsTest(){

        extentLogger = report. createTest("Contact Info Verification");

        LoginPage loginPage = new LoginPage();

        loginPage.login("saLes maNager");
        extentLogger.info("Username: " + ConfigurationReader.get("salesmanager_username"));
        extentLogger.info("Password: " + ConfigurationReader.get("salesmanager_password"));

        extentLogger.info("Navigate to Customers -- Contacts");
        new DashboardPage().navigateToModule("Customers", "Contacts");

        ContactsPage contactsPage = new ContactsPage();

        extentLogger.info("Click on mbrackstone9@example.com email");
        contactsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(5);

        contactsPage.GetContactEmail("mbrackstone9@example.com").click();

        ContactInfoPage contactInfoPage = new ContactInfoPage();

        String expectedFullName = "Mariam Brackstone";
        String actualFullName = contactInfoPage.fullName.getText();

        extentLogger.info("Verify full name is " + expectedFullName);
        Assert.assertEquals(actualFullName, expectedFullName, "Verify full name");

        extentLogger.info("Verify email is mbrackstone9@example.com");
        Assert.assertEquals(contactInfoPage.email.getText(), "mbrackstone9@example.com", "Verify email");

        extentLogger.info("Verify phone number is +18982323434");
        Assert.assertEquals(contactInfoPage.phone.getText(), "+18982323434", "Verify phone");

        extentLogger.pass("PASS: Contact Info Test");


    }



}
