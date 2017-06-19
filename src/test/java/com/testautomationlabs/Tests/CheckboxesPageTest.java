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

public class CheckboxesPageTest extends TestBase {

    @org.testng.annotations.Test(dataProvider = "hardCodedBrowsers")
    public void checkDefaultStateOfCheckboxes(String browser, String version, String os, Method method)
            throws MalformedURLException, InvalidElementStateException, UnexpectedException {
    	
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();

        LandingPage.visitPage(driver).checkboxPageLink.click();
        CheckboxesPage page = new CheckboxesPage(driver);
        
        Assert.assertFalse(page.checkboxes.get(0).isSelected(), "Expected the first checkbox to be unchecked");
        Assert.assertTrue(page.checkboxes.get(1).isSelected(), "Expected the second checkbox to be checked");
    }
    
    @org.testng.annotations.Test(dataProvider = "hardCodedBrowsers")
    public void checkCheckboxesCanBeModified(String browser, String version, String os, Method method)
            throws MalformedURLException, InvalidElementStateException, UnexpectedException {
    	
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();

        LandingPage.visitPage(driver).checkboxPageLink.click();
        CheckboxesPage page = new CheckboxesPage(driver);
        
        page.checkboxes.get(0).click();
        page.checkboxes.get(1).click();
        
        Assert.assertTrue(page.checkboxes.get(0).isSelected(), "Expected the first checkbox to be checked");
        Assert.assertFalse(page.checkboxes.get(1).isSelected(), "Expected the second checkbox to be unchecked");
    }
    
}