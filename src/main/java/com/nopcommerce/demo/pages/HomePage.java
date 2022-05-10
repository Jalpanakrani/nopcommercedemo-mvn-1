package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Utility {

    public HomePage() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(linkText = "Log in")
    WebElement loginLink;
    @FindBy(linkText = "Log in")
    WebElement LogInLinkText;

    @FindBy(linkText = "Register")
    WebElement registerLink;

    @FindBy(xpath = "//h1[contains(text(),'Welcome, Please Sign In!')]")
    WebElement welcomeText;

    @FindBy(linkText = "Computers")
    WebElement computerTab;



    public void clickOnLoginLink() {
        clickOnElement(loginLink);
    }
    public String getLogInLinkText() {
        return getTextFromElement(LogInLinkText);
    }
    public void clickOnRegisterLink() {
        clickOnElement(registerLink);
    }

    public String clickOnWelcomeText(){
        return getTextFromElement(welcomeText);
    }

    public String getVerifyLogInText(){
        return getTextFromElement(loginLink);
    }

    public void clickOnComputerPage(){
        clickOnElement(computerTab);
    }

}