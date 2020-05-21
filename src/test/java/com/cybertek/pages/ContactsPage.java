package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ContactsPage extends BasePage{

    // since we are extending BasePage we do not need explicit const. for this class

    // @FindBy ile concatenation yapamiyoruz
//    @FindBy(xpath = "//td[contains(text(),'abc@gmail.com') and @data-column-label='Email']")
//    public WebElement email;

    public WebElement GetContactEmail(String email){

        return Driver.get().findElement(By.xpath("//td[contains(text(),'" + email + "') and @data-column-label='Email']"));

    }



}
