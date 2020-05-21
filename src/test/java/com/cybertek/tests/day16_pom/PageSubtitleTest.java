package com.cybertek.tests.day16_pom;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import static com.cybertek.utilities.BrowserUtils.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageSubtitleTest extends TestBase {

    /*
        #Test Case#
        Open browser
        Login as a driver
        Verify that page subtitle is Quick Launchpad
        Go to Activities -> Calendar Events
        Verify that page subtitle is Calendar Events
     */

    @Test
    public void test1(){

        LoginPage loginpage = new LoginPage();

        loginpage.login("Driver");
        // Same thing with thread.sleep(3000);
        waitFor(3);

        DashboardPage dashboardPage = new DashboardPage();

        String expectedSubtitle = "Quick Launchpad";

        String actualSubtitle = dashboardPage.getPageSubTitle();

        Assert.assertEquals(actualSubtitle, expectedSubtitle, "Verify that page subtitle is Quick Launchpad");

        dashboardPage.navigateToModule("Activities", "Calendar Events");

        waitFor(2);

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        Assert.assertEquals(calendarEventsPage.getPageSubTitle(), "Calendar Events", "Verify that page subtitle is Calendar Events");

    }

}
