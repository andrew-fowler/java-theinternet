package com.testautomationlabs.Model;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckboxesPage {

    @FindBy(xpath = "//input[@type='checkbox']")
    public List<WebElement> checkboxes;
    
    public WebDriver driver;
    public static String url = "https://the-internet.herokuapp.com/checkboxes";

    public static CheckboxesPage visitPage(WebDriver driver) {
    	CheckboxesPage page = new CheckboxesPage(driver);
        page.visitPage();
        return page;
    }

    public CheckboxesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void visitPage() {
        this.driver.get(url);
    }
    
    public boolean isLoaded(){
    	return checkboxes.size() == 2;
    }
}