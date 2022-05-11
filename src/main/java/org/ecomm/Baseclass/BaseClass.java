//Created by : Anudeep K
//Created on : 10 May 2022
//Base Class for New Demo Framework


package org.ecomm.Baseclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public WebDriver driver;
	public Properties prop;
	public String userdirectory = System.getProperty("user.dir");
	public String expectedTitle = "ToolsQA Demo Site – ToolsQA – Demo E-Commerce Site";

	@BeforeSuite
	public void launchWebDriver() {
		
		//launch WebDriver
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		
	}
	@BeforeSuite
	public void loadProperties() {
		
		prop = new Properties();
		
		try {
			FileInputStream fis = new FileInputStream(userdirectory+ "\\Propertiesfile\\config.properties");
			prop.load(fis);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@BeforeTest
	public void launchapp(){
		
		driver.get(prop.getProperty("Application_url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//String pageTitle = driver.getTitle();

		//return home;
	}
	
	public void takescreenshots() {
		//takesscreenshot
	}

	public void createimgfile() {
		
		//imgfile
	}
	@AfterSuite
	public void closebrowser() {
		driver.quit();
	}
	
	//this is the last change for today 
	//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
	//do not remove this code here 

}
