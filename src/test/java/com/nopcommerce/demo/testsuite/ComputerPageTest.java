package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.*;
import com.nopcommerce.demo.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import resources.testdata.TestData;

public class ComputerPageTest extends TestBase {
    HomePage homePage;
    LogInPage loginPage;
    ComputerPage computerPage;
    DesktopsPage deskTopPage;
    BuildYourOwnComputerPage buildYourOwnComputerPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
        loginPage = new LogInPage();
        computerPage = new ComputerPage();
        deskTopPage = new DesktopsPage();
        buildYourOwnComputerPage = new BuildYourOwnComputerPage();
    }

    @Test(groups = {"sanity","smoke","regression"})
    public void verifyUserShouldNavigateToComputerPageSuccessfully() {
        homePage.clickOnComputerPage();
        String expectedMessage = "ComputerText";
        String actualMessage = computerPage.getComputerText();
        Assert.assertEquals(expectedMessage, actualMessage, "Login page not displayed");
    }

    @Test(groups = {"smoke","regression"})
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        homePage.clickOnComputerPage();
        computerPage.clickOnDeskTopLink();
        String expectedMessage = "DesktopsText";
        String actualMessage = deskTopPage.getDesktopText();
        Assert.assertEquals(expectedMessage, actualMessage, "Login page not displayed");

    }

    @Test(dataProvider = "selectOwnBuildComputer",dataProviderClass = TestData.class,groups = {"regression"})
    public void verifyThatUserShouldBuildYouOwnComputerAndAddThemToCartSuccessfully(String processor, String ram, String hdd, String os, String software) {
        SoftAssert softAssert = new SoftAssert();
        homePage.clickOnComputerPage();
        computerPage.clickOnDeskTopLink();
        deskTopPage.selectProductBuildYourOwnComputer("Build your own computer");
        String expectedBuildYourOwnComputerText = "Build your own computer";
        String actualBuildYourOwnComputerText = buildYourOwnComputerPage.getVerifyBuildYourComputerText();
        softAssert.assertEquals(actualBuildYourOwnComputerText,expectedBuildYourOwnComputerText,"buildYourOwnComputer test is not match");
        buildYourOwnComputerPage.selectProcessorFromDropDown(processor);
        buildYourOwnComputerPage.selectRamFromDropDown(ram);
        buildYourOwnComputerPage.clickOnHddFormRadioButton(hdd);
        buildYourOwnComputerPage.clickOnOsFormRadioButton(os);
        buildYourOwnComputerPage.selectSoftwareCheckBox(software);
        buildYourOwnComputerPage.clickOnAddToCartButton();
        String expectedAddToCartText = "The product has been added to your shopping cart";
        String actualAddToCartText = buildYourOwnComputerPage.getVerifyAddToCartText();
        softAssert.assertEquals(actualAddToCartText,expectedAddToCartText,"AddToCart test is not match");
        softAssert.assertAll();
    }


}
