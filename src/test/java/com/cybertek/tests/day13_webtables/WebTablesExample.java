package com.cybertek.tests.day13_webtables;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTablesExample {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/tables");
    }

    @AfterMethod
    public void close() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
    }

    @Test
    public void printTable(){
        WebElement table = driver.findElement(By.cssSelector("table[id='table1']"));

        System.out.println(table.getText());
        Assert.assertTrue(table.getText().contains("jsmith@gmail.com"));

    }

    @Test
    public void getAllHeaders(){
        // how many columns we have?
        List<WebElement> headers = driver.findElements(By.cssSelector("#table1 th"));
        System.out.println("headers = " + headers.size());
        // print each column name one by one
        for (WebElement header : headers) {
            System.out.println(header.getText());
        }

    }

    @Test
    public void printTableSize(){
        // how many columns we have?
        List<WebElement> headers = driver.findElements(By.cssSelector("#table1 th"));
        System.out.println("headers.size() = " + headers.size());

        // number of rows with header
        List<WebElement> allRowsWithHeader = driver.findElements(By.cssSelector("#table1 tr"));
        System.out.println("allRowsWithHeader.size() = " + allRowsWithHeader.size());

        // number of rows without header
        List<WebElement> allRowsWithoutHeader = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        System.out.println("allRowsWithoutHeader.size() = " + allRowsWithoutHeader.size());

    }

    @Test
    public void getRow(){
        // print the second row information
        WebElement secondRow = driver.findElement(By.cssSelector("#table1 tbody tr:nth-of-type(2)"));
        System.out.println(secondRow.getText());

        // get all the rows dynamically
        List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        for (int i=0; i<allRows.size(); i++){
            System.out.println(allRows.get(i).getText());
        }

    }

    @Test
    public void getAllCellInOneRow(){
        List<WebElement> allCellsInOneRow = driver.findElements(By.cssSelector("#table1 tbody tr:nth-of-type(1) td"));

        for (WebElement cell : allCellsInOneRow) {
            System.out.println(cell.getText());
        }

    }

    @Test
    public void getASingleCellByIndex(){
        WebElement singleCell = driver.findElement(By.cssSelector("#table1 tbody tr:nth-of-type(4) td:nth-of-type(5)"));

        System.out.println(singleCell.getText());

    }

    @Test
    public void printAllCellsByIndex(){

        int rowNumber = getNumberOfRows();
        int columnNumber = getNumberOfColumns();

        System.out.println("columnNumber = " + columnNumber);
        System.out.println("rowNumber = " + rowNumber);

        for(int i=1; i<=rowNumber; i++){
            for(int j=1; j<=columnNumber; j++){
                String cellXpath = "//table[@id='table1']/tbody/tr[" + i + "]/td[" + j + "]";
                System.out.print(driver.findElement(By.xpath(cellXpath)).getText() + " ");
            }
            System.out.println();
        }

    }

    @Test
    public void printCellWebElement(){
        for (WebElement webElement : cell(getNumberOfColumns(), getNumberOfRows())) {
            System.out.println(webElement);
        }
    }

    @Test
    public void getCellInRelationToanotherCellInSameRow(){

        String firstname = "John";
        String xpath ="//table[@id='table1']//td[.='" + firstname + "']/../td[3]";
        WebElement email = driver.findElement(By.xpath(xpath));
        System.out.println(email.getText());


    }

    private int getNumberOfColumns() {
        List<WebElement> headers = driver.findElements(By.cssSelector("#table1 th"));

        return headers.size();
    }

    private int getNumberOfRows() {
        List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));

        return allRows.size();
    }

    // create a method that accepts row and column number, and returns the cell as a webelement

    public List<WebElement> cell(int column, int row){

        List<WebElement> cell = new ArrayList<>();

        for(int i=1; i<=row; i++){
            for(int j=1; j<=column; j++){
               cell.add(driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + row + "]/td[" + column + "]")));
            }
        }

        return cell;
    }


}
