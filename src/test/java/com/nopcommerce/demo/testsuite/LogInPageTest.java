package com.nopcommerce.demo.testsuite;


import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LogInPage;
import com.nopcommerce.demo.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LogInPageTest extends TestBase {
    HomePage homePage;
    LogInPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
        loginPage = new LogInPage();
    }

    @Test(groups = {"sanity","smoke","regression"})
    public void userShouldNavigateToLoginPageSuccessFully() {
        homePage.clickOnLoginLink();
        String expectedWelcomeText = "Welcome, Please Sign In!";
        String actualWelcomeText = loginPage.getVerifyWelcomeText();
        Assert.assertEquals(actualWelcomeText,expectedWelcomeText,"welcome test is not match");
    }

    @Test(groups = {"smoke","regression"})
    public void verifyTheErrorMessageWithInValidCredentials() {
        homePage.clickOnLoginLink();
        loginPage.enterEmailId("patel123@gmail.com");
        loginPage.enterPassword("patel1234");
        loginPage.clickOnLoginButton();
        String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.\n"
                + "No customer account found";
        String actualErrorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage, "Error message not displayed");

    }

    @Test(groups = {"regression"})
    public void verifyThatUserShouldLogInSuccessFullyWithValidCredentials(){
        homePage.clickOnLoginLink();
        loginPage.enterEmailId("abc222@gmail.com");
        loginPage.enterPassword("123456");
        loginPage.clickOnLoginButton();
        String expectedLogOutText = "LogOut";
        String actualLogOutText = loginPage.getVerifyLogOutText();
        Assert.assertEquals(actualLogOutText,expectedLogOutText,"LogOut Text is not match");

    }

    @Test(groups = {"regression"})
    public void VerifyThatUserShouldLogOutSuccessFully(){
        homePage.clickOnLoginLink();
        loginPage.enterEmailId("abc222@gmail.com");
        loginPage.enterPassword("123456");
        loginPage.clickOnLoginButton();
        loginPage.clickOnLogOutLink();
        String expectedMessage = "LogInLinkText";
        String actualMessage = homePage.getLogInLinkText();
        Assert.assertEquals(expectedMessage, actualMessage, "Login page not displayed");

    }
}