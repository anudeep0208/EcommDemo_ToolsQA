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

public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;
	public String userdirectory = System.getProperty("user.dir");	

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

	@BeforeSuite(dependsOnMethods = "launchWebDriver")
	public void launchapp() {

		driver.get(GetProperty("Application_url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(GetProperty("Timeout"))));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(GetProperty("Pageloadtimeout"))));
	
	}

	@AfterSuite
	public void closebrowser() {
		driver.quit();
	}

}

// this is the last change for today
// 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
// do not remove this code here
