package org.example.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    // Constructor
    public HomePage(WebDriver driver) {
        super(driver);  // Call BasePage constructor
        PageFactory.initElements(driver, this);
    }

    // Locators
    @FindBy(xpath = "//a[@title='My Account']")
    private WebElement lnkMyAccount;

    @FindBy(xpath = "//a[normalize-space()='Register']")
    private WebElement lnkRegister;

    @FindBy(linkText = "Login")
    private WebElement linkLogin;

    // Action Methods
    public void clickMyAccount() {
        lnkMyAccount.click();
    }

    public void clickRegister() {
        lnkRegister.click();
    }

    public void clickLogin(){
        linkLogin.click();
    }
}
