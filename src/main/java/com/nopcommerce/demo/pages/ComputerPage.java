package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComputerPage extends Utility {

    public ComputerPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[contains(text(),'Computers')]")
    WebElement computerText;
    @FindBy(xpath = "//li[@class=\"inactive\"]/child::a[contains(text(),'Desktops')]")
    WebElement deskTopLink;
    @FindBy(xpath = "//li[@class=\"inactive\"]/child::a[contains(text(),'Notebooks')]")
    WebElement noteBooksLink;
    @FindBy(xpath = "//li[@class=\"inactive\"]/child::a[contains(text(),'Software')]")
    WebElement softwareLink;


    public String getComputerText() {
        return getTextFromElement(computerText);
    }

    public void clickOnDeskTopLink() {
        clickOnElement(deskTopLink);
    }

    public void clickOnNoteBookLink() {
        clickOnElement(noteBooksLink);
    }

    public void clickOnSoftwareLink() {
        clickOnElement(softwareLink);
    }

}