package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BuildYourOwnComputerPage extends Utility {
        public void inIt() {
            PageFactory.initElements(driver, this);
        } @FindBy(xpath = "//h1[contains(text(),'Build your own computer')]")
    WebElement buildYourComputerText;
    @FindBy(xpath = "//h1[contains(text(),'Build your own computer')]")
    WebElement TheproducthasbeenaddedtoyourshoppingcartText;
    @FindBy(xpath = "//select[@id='product_attribute_1']")
    WebElement processorDropDown;
    @FindBy(xpath = "//select[@id='product_attribute_2']")
    WebElement ramDropDown;
    @FindBy(xpath = "//dd[@id='product_attribute_input_3']/descendant::li/child::label")
    List<WebElement> hddRadioButton;
    @FindBy(xpath = "//dd[@id='product_attribute_input_4']/descendant::li/child::label")
    List<WebElement> osRadioButton;
    @FindBy(xpath = "//dd[@id='product_attribute_input_5']/descendant::li")
    List<WebElement> softwareCheckBox;
    @FindBy(xpath = "//button[@id='add-to-cart-button-1']")
    WebElement addToCartButton;
    @FindBy(xpath = "//body/div[@id='bar-notification']/div[1]/p[1]")
    WebElement addToCartText;

    public String getVerifyBuildYourComputerText(){
        return getTextFromElement(buildYourComputerText);
    }
    public String getTheproducthasbeenaddedtoyourshoppingcartText() {
        return getTextFromElement(TheproducthasbeenaddedtoyourshoppingcartText);
    }
    public void selectProcessorFromDropDown(String processor){
        selectByVisibleTextFromDropDown(processorDropDown,processor);
    }

    public void selectRamFromDropDown(String ram){
        selectByVisibleTextFromDropDown(ramDropDown,ram);
    }
    public void clickOnHddFormRadioButton(String hdd){
        for(WebElement element : hddRadioButton){
            if(element.getText().equalsIgnoreCase(hdd)){
                element.click();
                break;
            }
        }
    }

    public void clickOnOsFormRadioButton(String os){
        for(WebElement element : osRadioButton){
            if(element.getText().equalsIgnoreCase(os)){
                element.click();
                break;
            }
        }
    }

    public void selectSoftwareCheckBox(String software) {
        for (WebElement element : softwareCheckBox)
            if (element.getText().equalsIgnoreCase(software)) {
                element.click();
                break;
            }
    }



    public void clickOnAddToCartButton(){
        clickOnElement(addToCartButton);
    }

    public String getVerifyAddToCartText(){
        return getTextFromElement(addToCartText);
    }
}