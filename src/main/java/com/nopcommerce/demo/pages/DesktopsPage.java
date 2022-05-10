package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DesktopsPage extends Utility {
    public void inIt() {
        PageFactory.initElements(driver, this);

    }
    @FindBy(xpath = "//h1[contains(text(),'Desktops')]")
    WebElement desktopText;
    @FindBy(xpath = "//select[@id='products-orderby']")
    WebElement shortByDropDown;
    @FindBy(xpath = "//select[@id='products-pagesize']")
    WebElement displayDorpDown;
    @FindBy(xpath = "//div[@class='item-box']/child::div/descendant::h2/child::a")
    List<WebElement> selectProductList;

    public String getDesktopText(){
        return getTextFromElement(desktopText);
    }

    public void selectShortByFilterFromDropDown(String text){
        selectByVisibleTextFromDropDown(shortByDropDown,text);
    }

    public void selectDisplayFilterFromDropDown(String text){
        selectByVisibleTextFromDropDown(displayDorpDown,text);
    }

    public void selectProductBuildYourOwnComputer(String productName){
        for (WebElement element:selectProductList){
            if(element.getText().equalsIgnoreCase(productName)){
                element.click();
                break;
            }
        }
    }
}
