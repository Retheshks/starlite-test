package com.starlite.test.smoke;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.starlite.lib.ui.LoginPage;
import com.starlite.lib.utils.CreateDriver;

public class TestSample
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
	public void testSample()
	{
		loginPage.WaitForLoginPageToLoad();
	}
}
