package com.testautomationlabs.Model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {

    @FindBy(xpath = "//a[@href='/login']")
    public WebElement loginPageLink;

    @FindBy(xpath = "//h1[contains(.,'Welcome to the Internet')]")
    private WebElement header;
    
    public WebDriver driver;
    public static String url = "https://the-internet.herokuapp.com/";

    public static LandingPage visitPage(WebDriver driver) {
    	LandingPage page = new LandingPage(driver);
        page.visitPage();
        return page;
    }

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void visitPage() {
        this.driver.get(url);
    }
    
    public boolean isLoaded(){
    	return header.isDisplayed();
    }
}