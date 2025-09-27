package org.example.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

    // Constructor
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    // Locator
    @FindBy(xpath = "//h2[text()='My Account']")
    private WebElement msgHeading;

    @FindBy(xpath = "//a[@class='list-group-item' and text()='Logout']")
    private WebElement lnkLogout;

    public void clickLogout() {
        lnkLogout.click();
    }


    // Action / Validation
    public boolean isMyAccountPageExists() {
        try {
            return msgHeading.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}

