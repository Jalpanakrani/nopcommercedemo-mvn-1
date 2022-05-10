package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LogInPage;
import com.nopcommerce.demo.pages.RegisterPage;
import com.nopcommerce.demo.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class RegisterPageTest extends TestBase {
    HomePage homePage;
    LogInPage loginPage;
    RegisterPage registerPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
        loginPage = new LogInPage();
        registerPage = new RegisterPage();
    }

    @Test(groups = {"sanity","smoke","regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        homePage.clickOnRegisterLink();
        String expectedRegisterText = "Register";
        String actualRegisterText = registerPage.getVerfiyRegisterText();
        Assert.assertEquals(actualRegisterText,expectedRegisterText,"welcome test is not match");
    }

    @Test(groups = {"smoke","regression"})
    public void verifyThatFirstNameLastNameEmailPasswordAndConfirmPasswordFieldsAreMandatory() {
        homePage.clickOnRegisterLink();
        registerPage.clickOnRegistrationButton();
        SoftAssert softAssert = new SoftAssert();
        String expectedFirstNameIsRequiredText = "First name is required.";
        String actualFirstNameIsRequiredText = registerPage.getVerifyFirstNameIsRequiredText();
        softAssert.assertEquals(actualFirstNameIsRequiredText,expectedFirstNameIsRequiredText,"text is not match");

        String expectedLastNameIsRequiredText = "Last name is required.";
        String actualLastNameIsRequiredText = registerPage.getVerifyLastNameIsRequiredText();
        softAssert.assertEquals(actualLastNameIsRequiredText,expectedLastNameIsRequiredText,"text is not match");

        String expectedEmailIsRequiredText = "Email is required.";
        String actualEmailIsRequiredText = registerPage.getVerifyEmailIsRequiredText();
        softAssert.assertEquals(actualEmailIsRequiredText,expectedEmailIsRequiredText,"text is not match");

        String expectedPasswordIsRequiredText = "Password is required.";
        String actualPasswordIsRequiredText = registerPage.getVerifyPasswordIsRequiredText();
        softAssert.assertEquals(actualPasswordIsRequiredText,expectedPasswordIsRequiredText,"text is not match");

        String expectedConfirmPasswordIsRequiredText = "Password is required.";
        String actualConfirmPasswordIsRequiredText = registerPage.getVerifyConfirmPasswordIsRequiredText();
        softAssert.assertEquals(actualConfirmPasswordIsRequiredText,expectedConfirmPasswordIsRequiredText,"text is not match");

        softAssert.assertAll();
    }

    @Test(groups = {"regression"})
    public void verifyThatUserShouldCreateAccountSuccessfully() {
        homePage.clickOnRegisterLink();
        registerPage.clickOnMaleOrFemaleRadioButton("F");
        registerPage.enterFirstName("abc");
        registerPage.enterLastName("xyz");
        registerPage.selectDateOfBirthDay("26");
        registerPage.selectDateOfBirthMonth("July");
        registerPage.selectDateOfBirthYear("1998");
        registerPage.enterEmailAddress("abc55@gmail.com");
        registerPage.enterPassword("123456");
        registerPage.enterConfirmPassword("123456");
        registerPage.clickOnRegistrationButton();

        String expectedRegisterText = "Your registration completed";
        String actualRegisterText = registerPage.getVerifyRegisterCompletedText();
        Assert.assertEquals(actualRegisterText,expectedRegisterText,"registration text is not match");
    }


}