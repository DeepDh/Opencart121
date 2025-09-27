package org.example.testCases;

import io.qameta.allure.*;
import org.example.pageObjects.AccountRegistrationPage;
import org.example.pageObjects.HomePage;
import org.example.testBase.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC001_AccountRegistrationClass extends BaseClass {

    @Test(groups = {"Regression", "Master"})
    @Description ("Verify Account Registration")
    @Epic("EP001")
    @Feature("Feature 1")
    @Story("Account Story")
    @Step("Verify Account")
    @Severity(SeverityLevel.CRITICAL)
    public void verify_account_registration() throws InterruptedException {
        try{
            logger.info("************ Starting TC001_AccountRegistrationTest **************");
            HomePage hp = new HomePage(driver);
            TimeUnit.SECONDS.sleep(5);
            hp.clickMyAccount();
            logger.info("************ Clicked On MyAccount link **************");
            TimeUnit.SECONDS.sleep(5);
            hp.clickRegister();
            logger.info("************ Clicked On Register link **************");

            AccountRegistrationPage regpage = new AccountRegistrationPage(driver);

            logger.info("************ Providing customer details **************");
            regpage.setFirstName(randomeString().toUpperCase());
            regpage.setLastName(randomeString().toUpperCase());
            regpage.setEmail(randomeString()+ "@gmail.com");
            regpage.setTelephone(randomeNumber());

            String password = randomePassword();
            regpage.setPassword(password);
            regpage.setConfirmPassword(password);

            regpage.setPrivacyPolicy();
            regpage.clickContinue();

            logger.info("************ Validating expected message **************");
            String confmsg = regpage.getConfirmationMsg();

            Assert.assertEquals(confmsg, "Your Account Has Been Created!");
        }catch (Exception e){
            logger.error("Test Failed ..");
            logger.debug("Debug Logs");
            Assert.fail();
        }
        logger.info("************ Finished TC001_AccountRegistrationTest **************");
    }

}

