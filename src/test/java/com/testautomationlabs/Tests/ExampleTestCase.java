package com.testautomationlabs.Tests;

import com.testautomationlabs.Model.LandingPage;
import com.testautomationlabs.Model.LoginPage;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.rmi.UnexpectedException;
import java.util.UUID;

public class ExampleTestCase extends TestBase {

    @org.testng.annotations.Test(dataProvider = "hardCodedBrowsers")
    public void goToLandingPage(String browser, String version, String os, Method method)
            throws MalformedURLException, InvalidElementStateException, UnexpectedException {
    	
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        
        Assert.assertTrue(LandingPage.visitPage(driver).isLoaded());
    }

    @org.testng.annotations.Test(dataProvider = "hardCodedBrowsers")
    public void goToLoginPage(String browser, String version, String os, Method method)
            throws MalformedURLException, InvalidElementStateException, UnexpectedException {
    	
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        
        LandingPage.visitPage(driver).loginPageLink.click();
        
        Assert.assertTrue(LoginPage.visitPage(driver).isLoaded());
    }    
    
    @org.testng.annotations.Test(dataProvider = "hardCodedBrowsers")
    public void loginWithValidCredentials(String browser, String version, String os, Method method)
            throws MalformedURLException, InvalidElementStateException, UnexpectedException {
    	
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();

        LandingPage.visitPage(driver).loginPageLink.click();
        
        LoginPage loginPage = new LoginPage(driver);
        loginPage.attemptLogin("tomsmith", "SuperSecretPassword!");
        Assert.assertTrue(loginPage.isSuccessMessageDisplayed());
    }

}