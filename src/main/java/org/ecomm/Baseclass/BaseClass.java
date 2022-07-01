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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;
	public static FileInputStream FIS;
	public static JavascriptExecutor jsexecutor;
	public String userdirectory = System.getProperty("user.dir");

	@BeforeSuite
	public void loadProperties() {

		prop = new Properties();

		try {
			FIS = new FileInputStream(userdirectory + "\\Propertiesfile\\config.properties");
			prop.load(FIS);
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
		driver = BrowserFactory.getBrowserDriver(GetProperty("BrowserName"));

	}

	@BeforeSuite(dependsOnMethods = "launchWebDriver")
	public void launchapp() {

		driver.get(GetProperty("Application_url"));
		Reporter.log("The application has launched succesfully");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(GetProperty("Timeout"))));
		driver.manage().timeouts()
				.pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(GetProperty("Pageloadtimeout"))));

	}

	@AfterSuite
	public void closebrowser() {
		driver.quit();
	}

	// before suite

}


