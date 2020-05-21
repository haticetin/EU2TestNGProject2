package com.cybertek.pages;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    //same with driver.findElement(By.id("prependedInput"));
    @FindAll({
            @FindBy(id = "prependedInput"),
            @FindBy(name = "_username"),
    })
    public List<WebElement> usernameInput;

    @FindBy(id = "prependedInput2")
    public WebElement passwordInput;

    @FindBy(id = "_submit")
    public WebElement loginBtn;

    public void login(String usernameStr, String passwordStr){

        usernameInput.get(0).sendKeys(usernameStr);
        passwordInput.sendKeys(passwordStr);
        loginBtn.click();

    }

    public void login(String user){
        switch (user.toLowerCase().replace(" ", "")){
            case "driver":
                usernameInput.get(0).sendKeys(ConfigurationReader.get("driver_username"));
                passwordInput.sendKeys(ConfigurationReader.get("driver_password"));
                loginBtn.click();
                break;
            case "storemanager":
                usernameInput.get(0).sendKeys(ConfigurationReader.get("storemanager_username"));
                passwordInput.sendKeys(ConfigurationReader.get("storemanager_password"));
                loginBtn.click();
                break;
            case "salesmanager":
                usernameInput.get(0).sendKeys(ConfigurationReader.get("salesmanager_username"));
                passwordInput.sendKeys(ConfigurationReader.get("salesmanager_password"));
                loginBtn.click();
                break;
        }
    }



}

