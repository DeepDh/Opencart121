package org.example.testCases;

import org.example.pageObjects.HomePage;
import org.example.pageObjects.LoginPage;
import org.example.pageObjects.MyAccountPage;
import org.example.testBase.BaseClass;
import org.example.utilities.DataProvidersUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC003_LoginDDT extends BaseClass {

    @Test(dataProvider = "LoginData", dataProviderClass = DataProvidersUtils.class, groups = "Datadriven")
    public void verify_loginDDT(String email, String pwd, String exp) {
        logger.info("**********  Starting TC_003_LoginTestDDT ********");
       try{
           // HomePage
           HomePage hp = new HomePage(driver);
           hp.clickMyAccount();
           hp.clickLogin();

           // Login
           LoginPage lp = new LoginPage(driver);
           lp.setEmail(email);
           lp.setPassword(pwd);
           lp.clickLogin();

           // MyAccount
           MyAccountPage macc = new MyAccountPage(driver);
           boolean targetPage = macc.isMyAccountPageExists();

           // Validation
           if (exp.equalsIgnoreCase("Valid")) {
               if (targetPage) {
                   macc.clickLogout(); // optional - logout after success
                   Assert.assertTrue(true);

               } else {
                   Assert.assertTrue(false);
               }
           } else if (exp.equalsIgnoreCase("Invalid")) {
               if (targetPage) {
                   macc.clickLogout(); // optional cleanup
                   Assert.fail();

               } else {
                   Assert.assertTrue(true);
               }
           }
       }catch (Exception e){
           Assert.fail();
       }
        logger.info("**********  Starting TC_003_LoginTestDDT ********");
    }

}
