package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage extends Utility {
    public void inIt() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[contains(text(),'Welcome, Please Sign In!')]")
    WebElement welcomeText;
    @FindBy(id = "Email")
    WebElement emailField;
    @FindBy(name = "Password")
    WebElement passwordField;
    @FindBy(xpath = "//button[contains(text(),'Log in')]")
    WebElement loginButton;
    @FindBy(xpath = "//div[@class='message-error validation-summary-errors']")
    WebElement errorMessage;
    @FindBy(xpath = "//a[contains(text(),'Log out')]")
    WebElement logOutBtn;

    public void enterEmailId(String email) {
        sendTextToElement(emailField,email);
    }

    public void enterPassword(String password) {
        sendTextToElement(passwordField, password);
    }

    public void clickOnLoginButton() {
        clickOnElement(loginButton);
    }

    public String getErrorMessage() {
        return getTextFromElement(errorMessage);
    }

    public String getVerifyWelcomeText(){
        return getTextFromElement(welcomeText);
    }

    public void clickOnLogOutLink(){
        clickOnElement(logOutBtn);
    }

    public String getVerifyLogOutText(){
        return getTextFromElement(logOutBtn);
    }

}