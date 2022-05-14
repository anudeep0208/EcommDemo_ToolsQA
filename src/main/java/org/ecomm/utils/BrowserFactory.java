package org.ecomm.utils;

import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {

	public static WebDriver driver;

	public static WebDriver browserfactory(String Browsername) {

		if (Browsername.equalsIgnoreCase("Chrome")) {
			driver = WebDriverManager.chromedriver().create();
		} else if (Browsername.equalsIgnoreCase("Firefox")) {
			driver = WebDriverManager.firefoxdriver().create();
		} else if (Browsername.equalsIgnoreCase("Edge")) {
			driver = WebDriverManager.edgedriver().create();
		} else {
			System.out.println("This Browser is not supported");
		}
		return driver;

	}

}
