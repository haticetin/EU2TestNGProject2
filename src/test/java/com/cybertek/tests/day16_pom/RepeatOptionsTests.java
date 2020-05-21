package com.cybertek.tests.day16_pom;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.CreateCalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

import static com.cybertek.utilities.BrowserUtils.waitFor;

public class RepeatOptionsTests extends TestBase {

    /*
        #Veriy radio buttons#
        Open browser
        Login as a driver
        Go to Activities -> Calendar Events
        Click on create calendar events
        Click on repeat
        Verify that repeat every days is checked
        Verify that repeat weekday is not checked
     */

    @Test
    public void test1(){

        LoginPage loginpage = new LoginPage();

        loginpage.login("Driver");

        waitFor(3);

        DashboardPage dashboardPage = new DashboardPage();

        dashboardPage.navigateToModule("Activities", "Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();

        BrowserUtils.waitFor(2);

        calendarEventsPage.waitUntilLoaderScreenDisappear();

        createCalendarEventsPage.repeat.click();

        Assert.assertTrue(createCalendarEventsPage.days.isSelected(), "Verify that repeat every days is checked");

        Assert.assertFalse(createCalendarEventsPage.weekday.isSelected(), "Verify that repeat weekday is not checked");
    }

    /*
        #Verify Repeat Options#
        Open browser
        Login as Driver
        Go to Activities -> Calendar Events
        Click on Create Calendar Events
        Click on repeat
        Verify that repeat options are Daily, Weekly, Monthly, Yearly (in this order)
     */

    @Test
    public void test2() {

        new LoginPage().login("driver");

        new DashboardPage().navigateToModule("Activities","Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        BrowserUtils.waitFor(2);

        calendarEventsPage.waitUntilLoaderScreenDisappear();

        BrowserUtils.clickWithJS(calendarEventsPage.createCalendarEvent);

        //calendarEventsPage.createCalendarEvent.click();
        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();

        //BrowserUtils.waitFor(2);
        createCalendarEventsPage.waitUntilLoaderScreenDisappear();

        BrowserUtils.clickWithJS(createCalendarEventsPage.repeat);

        //createCalendarEventsPage.repeat.click();
        Select repeatDropdown = createCalendarEventsPage.repeatOptionsList();

        List<String> expectedList = Arrays.asList("Daily","Weekly", "Monthly","Yearly");

        List<WebElement> actualOptions = repeatDropdown.getOptions();

        List<String> actualList = new ArrayList<>();

        for (WebElement option : actualOptions) {
            //get the text of each webelement and add to list of string
            actualList.add(option.getText());
        }

        //getting list with ready method
        List<String> actualList2 = BrowserUtils.getElementsText(actualOptions);

        Assert.assertEquals(actualList,expectedList,"verify dropdown options");
    }


}
