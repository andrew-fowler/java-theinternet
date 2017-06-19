package com.testautomationlabs.Tests;

import com.testautomationlabs.Model.CheckboxesPage;
import com.testautomationlabs.Model.LandingPage;
import com.testautomationlabs.Model.LoginPage;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.rmi.UnexpectedException;
import java.util.UUID;

public class LandingPageTest extends TestBase {

    @org.testng.annotations.Test(dataProvider = "hardCodedBrowsers")
    public void checkLandingPageIsAccessible(String browser, String version, String os, Method method)
            throws MalformedURLException, InvalidElementStateException, UnexpectedException {
    	
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        
        Assert.assertTrue(LandingPage.visitPage(driver).isLoaded());
    }
}