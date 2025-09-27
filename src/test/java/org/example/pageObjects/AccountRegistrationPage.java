package org.example.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountRegistrationPage extends BasePage {

    // Constructor
    public AccountRegistrationPage(WebDriver driver) {
        super(driver);

    }

    // Locators
    @FindBy(xpath = "//input[@id='input-firstname']")
    private WebElement txtFirstName;

    @FindBy(xpath = "//input[@id='input-lastname']")
    private WebElement txtLastName;

    @FindBy(xpath = "//input[@id='input-email']")
    private WebElement txtEmail;

    @FindBy(xpath = "//input[@id='input-telephone']")
    private WebElement txtTelephone;

    @FindBy(xpath = "//input[@id='input-password']")
    private WebElement txtPassword;

    @FindBy(xpath = "//input[@id='input-confirm']")
    private WebElement txtConfirmPassword;

    // Locators
    @FindBy(xpath = "//input[@name='agree']")
    private WebElement chkPolicy;

    @FindBy(xpath = "//input[@value='Continue']")
    private WebElement btnContinue;

    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    private WebElement msgConfirmation;

    // Action Methods
    public void setFirstName(String fname) {
        txtFirstName.sendKeys(fname);
    }

    public void setLastName(String lname) {
        txtLastName.sendKeys(lname);
    }

    public void setEmail(String email) {
        txtEmail.sendKeys(email);
    }

    // Action Methods
    public void setTelephone(String tel) {
        txtTelephone.sendKeys(tel);
    }

    public void setPassword(String pwd) {
        txtPassword.sendKeys(pwd);
    }

    public void setConfirmPassword(String pwd) {
        txtConfirmPassword.sendKeys(pwd);
    }

    public void setPrivacyPolicy() {
        chkPolicy.click();
    }

    public void clickContinue() {
        // Solution 1
        btnContinue.click();
        // Alternative solutions (if direct click fails):
        // Solution 2
        // btnContinue.submit();
        // Solution 3
        // Actions act = new Actions(driver);
        // act.moveToElement(btnContinue).click().perform();
        // Solution 4
        // JavascriptExecutor js = (JavascriptExecutor)driver;
        // js.executeScript("arguments[0].click();", btnContinue);
        // Solution 5
        //btnContinue.sendKeys(Keys.RETURN);
        // Solution 6
        //WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //mywait.until(ExpectedConditions.elementToBClickable(btnContinue)).click()
        // Solution 7
    }

    public String getConfirmationMsg() {
        try {
            return msgConfirmation.getText();
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}

