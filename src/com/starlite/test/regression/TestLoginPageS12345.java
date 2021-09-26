package com.starlite.test.regression;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.starlite.lib.ui.LoginPage;
import com.starlite.lib.utils.CreateDriver;
import com.starlite.lib.utils.DataHandlers;

public class TestLoginPageS12345 
{
	WebDriver driver;
	LoginPage loginPage;
	
	@BeforeMethod
	public void preCondition()
	{
		driver = CreateDriver.getDriverInstance();
		loginPage = new LoginPage(driver);
	}
	@AfterMethod
	public void postCondition()
	{
		driver.quit();
	}
	@Test
	public void testUserNameAndPasswordTextboxTC13579()
	{
		boolean status = false;
		String un = DataHandlers.getDataFromExcel("S12345", "TC13579", 0, 1);
		String pwd = DataHandlers.getDataFromExcel("S12345", "TC13579", 1, 1);
		// 1. Go to Login page
		loginPage.WaitForLoginPageToLoad();
		// 2. Without Entering UN ad PWD check login Button is Enabled
		status = loginPage.getLoginButton().isEnabled();
		Assert.assertTrue(status);
		// 3. Enter UN and Check Login Button is Enabled
		loginPage.getUsernameTextbox().sendKeys(un);
		status = loginPage.getLoginButton().isEnabled();
		Assert.assertTrue(status);
		// 4. Enter PWD and check login Button is Enabled
		loginPage.getPasswordTextbox().sendKeys(pwd);
		status = loginPage.getLoginButton().isEnabled();
		Assert.assertTrue(status);
	}
}
