//Created by : Anudeep K
//Created on : 10 May 2022
//Base Class for New Demo Framework

package org.ecomm.Baseclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.ecomm.utils.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseClass {

	public WebDriver driver;
	public static Properties prop;
	public String userdirectory = System.getProperty("user.dir");
	// public String expectedTitle = "ToolsQA Demo Site – ToolsQA – Demo E-Commerce
	// Site";

	@BeforeSuite
	public void loadProperties() {

		prop = new Properties();

		try {
			FileInputStream fis = new FileInputStream(userdirectory + "\\Propertiesfile\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static String GetProperty(String Propertyname) {
		
		return prop.getProperty(Propertyname);
	}

	@BeforeSuite(dependsOnMethods = "loadProperties")
	public void launchWebDriver() {

		// launch WebDriver
		driver = BrowserFactory.browserfactory(GetProperty("BrowserName"));

	}

	@BeforeTest
	public void launchapp() {

		driver.get(GetProperty("Application_url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(GetProperty("Timeout"))));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(GetProperty("Pageloadtimeout"))));
		// String pageTitle = driver.getTitle();

		// return home;
	}

	public void takescreenshots() {
		// takesscreenshot
	}

	public void createimgfile() {

		// imgfile
	}

	@AfterSuite
	public void closebrowser() {
		driver.quit();
	}

	// this is the last change for today
	// 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
	// do not remove this code here

}
