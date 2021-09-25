package com.starlite.lib.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class CreateDriver 
{
	public static WebDriver getDriverInstance()
	{
		WebDriver driver = null;
		String browser = DataHandlers.getDataFromExcel("Config-data", "sheet1", 0, 1).toLowerCase();
		String url = DataHandlers.getDataFromExcel("Config-data", "sheet1", 1, 1);
		if(browser.contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./browser-servers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.contains("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver", "./browser-servers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browser.contains("ie"))
		{
			System.setProperty("webdriver.ie.driver", "./browser-servers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else
		{
			System.err.println("<-----Invalid Option Please check Config-data.xlsx Row 1 and Cell 1 data----->");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
		return driver;
	}
}
