package com.cybertek.tests.day7_testng_radioButton.testng;

import org.testng.annotations.*;

public class BeforeAfterTests {


    @Test
    public void test1(){
        System.out.println("This is my test 1");
    }

    @Ignore
    @Test
    public void test2(){
        System.out.println("This is my test 2");
    }

    @Test
    public void test3(){
        System.out.println("This is my test 3");
    }

    @BeforeMethod
    public void setUp(){
        // WebDriver part
        System.out.println("Before method here");
        System.out.println("Webdriver Part");
    }


    @AfterMethod
    public void tearDown(){
        System.out.println("After method here");
        System.out.println("Driver quit");
    }

    @BeforeClass
    public void setUpClass(){
        System.out.println("--Before Class--");
        System.out.println("Runs only one in the class");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("--After Class--");
        System.out.println("Runs only one in the class");
        System.out.println("Generate Report");
    }



}
