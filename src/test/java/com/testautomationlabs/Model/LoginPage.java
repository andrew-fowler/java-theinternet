package com.testautomationlabs.Model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    @FindBy(xpath = "//input[@id='username']")
    public WebElement usernameTextbox;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordTextbox;
    
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButton;    

    @FindBy(xpath = "//i[@class='icon-2x icon-signout']")
    public WebElement logoutButton;
    
    @FindBy(xpath = "//div[@id='flash']")
    public WebElement flash;
    
    public WebDriver driver;
    public static String url = "https://the-internet.herokuapp.com/login";

    public static LoginPage visitPage(WebDriver driver) {
    	LoginPage page = new LoginPage(driver);
        page.visitPage();
        return page;
    }

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void attemptLogin(String username, String password){
    	usernameTextbox.sendKeys(username);
    	passwordTextbox.sendKeys(password);
    	submitButton.click();
    }
    
    public boolean isFailureMessageDisplayed(){
    	return flash.getText().contains("Your username is invalid!");
    }
    
    public boolean isSuccessMessageDisplayed(){
    	return flash.getText().contains("You logged into a secure area!");
    }
    
    public void visitPage() {
        this.driver.get(url);
    }
    
    public boolean isLoaded(){
    	return usernameTextbox.isDisplayed() && passwordTextbox.isDisplayed();
    }
}