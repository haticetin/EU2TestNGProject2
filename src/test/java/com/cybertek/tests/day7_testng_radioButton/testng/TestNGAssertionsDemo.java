package com.cybertek.tests.day7_testng_radioButton.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssertionsDemo {

    @Test
    public void test1(){

        System.out.println("First Assertion");
        Assert.assertEquals("title".toUpperCase(), "TITLE");

        System.out.println("Second Assertion");
        Assert.assertEquals(1, 1);

    }

    @Test
    public void test2(){

        System.out.println("Test 2 is run");
        Assert.assertEquals("url", "url");
    }

    @Test
    public void test3(){

        String expectedResult = "Cyb";
        String actualResult = "Cybertek";

        Assert.assertTrue(actualResult.startsWith(expectedResult), "Verify result starts with Cyb");
        Assert.assertTrue(2>1, "I am checking if 2 is greater than 1");

    }

    @Test
    public void test4(){

        String email = "mikeSmith.com";

        Assert.assertTrue(email.contains("@"), "verify email contains @ sign");

    }

    @Test
    public void test5(){
        // verify something is false
        Assert.assertFalse(0>1, "verify that 0 is not greater than 1");
    }

    @Test
    public void test6(){
        Assert.assertNotEquals("one", "two");
    }

}
