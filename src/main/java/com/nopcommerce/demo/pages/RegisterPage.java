package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RegisterPage extends Utility {
    public void inIt() {
        PageFactory.initElements(driver, this);
    }

    public RegisterPage() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//h1[contains(text(),'Register')]")
    WebElement registerText;
    @FindBy(xpath = "//input[@type='radio']")
    List<WebElement> maleFemaleRadioBtn;
    @FindBy(name = "FirstName")
    WebElement firstNameField;
    @FindBy(id = "LastName")
    WebElement lastNameField;
    @FindBy(name = "DateOfBirthDay")
    WebElement selectDateOfDay;
    @FindBy(name = "DateOfBirthMonth")
    WebElement selectDateOfMonth;
    @FindBy(name = "DateOfBirthYear")
    WebElement selectDateOfYear;
    @FindBy(xpath = "//input[@id='Email']")
    WebElement emailAddressField;
    @FindBy(id = "Password")
    WebElement passwordField;
    @FindBy(id = "ConfirmPassword")
    WebElement confirmPasswordField;
    @FindBy(id="register-button")
    WebElement registerButton;
    @FindBy(id="FirstName-error")
    WebElement firstNameIsRequired;
    @FindBy(id="LastName-error")
    WebElement lastNameIsRequired;
    @FindBy(id="Email-error")
    WebElement emailIsRequired;
    @FindBy(id="Password-error")
    WebElement passwordIsRequired;
    @FindBy(id="ConfirmPassword-error")
    WebElement confirmPasswordIsRequired;
    @FindBy(css = "div.result")
    WebElement yourRegisterCompletedTest;
    @FindBy(xpath = "//div[@class='buttons']/child::a")
    WebElement continueButton;


    public String getVerfiyRegisterText() {

        return getTextFromElement(registerText);
    }

    public void clickOnMaleOrFemaleRadioButton(String maleOrFemale){
        for(WebElement element : maleFemaleRadioBtn){
            if(element.getAttribute("value").equalsIgnoreCase(maleOrFemale)){
                element.click();
                break;
            }
        }
    }


    public void enterFirstName(String text){

        sendTextToElement(firstNameField,text);
    }


    public void enterLastName(String text){
        sendTextToElement(lastNameField,text);
    }
    public void selectDateOfBirthDay(String text){

        selectByVisibleTextFromDropDown(selectDateOfDay,text);
    }
    //action use for selectDateOfBirthMonth
    public void selectDateOfBirthMonth(String text){
        selectByVisibleTextFromDropDown(selectDateOfMonth,text);
    }

    //action use for selectDateOfBirthYear
    public void selectDateOfBirthYear(String text){
        selectByVisibleTextFromDropDown(selectDateOfYear,text);
    }

    //action use for enterPassword
    public void enterEmailAddress(String text){
        sendTextToElement(emailAddressField,text);
    }

    //action use for enterPassword
    public void enterPassword(String text){
        sendTextToElement(passwordField,text);
    }

    //action use for enterConfirmPassword
    public void enterConfirmPassword(String text){
        sendTextToElement(confirmPasswordField,text);
    }

    //action use for enterConfirmPassword
    public void clickOnRegistrationButton(){
        clickOnElement(registerButton);
    }

    public String getVerifyFirstNameIsRequiredText(){
        return getTextFromElement(firstNameIsRequired);
    }
    public String getVerifyLastNameIsRequiredText(){
        return getTextFromElement(lastNameIsRequired);
    }
    public String getVerifyEmailIsRequiredText(){
        return getTextFromElement(emailIsRequired);
    }
    public String getVerifyPasswordIsRequiredText(){
        return getTextFromElement(passwordIsRequired);
    }
    public String getVerifyConfirmPasswordIsRequiredText(){
        return getTextFromElement(confirmPasswordIsRequired);
    }

    public String getVerifyRegisterCompletedText(){
        return getTextFromElement(yourRegisterCompletedTest);
    }

    public void clickOnContinueButton(){
        clickOnElement(continueButton);
    }
}