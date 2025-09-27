package org.example.testCases;

import io.qameta.allure.*;
import org.example.pageObjects.HomePage;
import org.example.pageObjects.LoginPage;
import org.example.pageObjects.MyAccountPage;
import org.example.testBase.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC002_LoginTest extends BaseClass {

    @Test(groups = {"Sanity", "Master"})
    @Description("Verify Login")
    @Epic("EP002")
    @Feature("Feature 2")
    @Story("Login Story")
    @Step("Verify Login")
    @Severity(SeverityLevel.CRITICAL)
    public void verify_login(){
        logger.info("**********  Starting TC_002_LoginTest ********");
        try{
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            hp.clickLogin();

            LoginPage lp = new LoginPage(driver);
            lp.setEmail(prop.getProperty("email"));
            Thread.sleep(1000);
            lp.setPassword(prop.getProperty("password"));
            Thread.sleep(1000);
            lp.clickLogin();
            Thread.sleep(1000);

            MyAccountPage macc = new MyAccountPage(driver);
            boolean targetPage =  macc.isMyAccountPageExists();

            Assert.assertTrue(targetPage, "Login Failed");
        } catch (Exception e) {
           Assert.fail();
        }
        logger.info("**********  Finished TC_002_LoginTest ********");
    }

}
