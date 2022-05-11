package org.ecomm.Baseclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccounthome {
	
	public WebDriver driver;
	
	@FindBy(xpath = "//a[normalize-space()='Logout']") 
	private WebElement Logoutlink;
	
	@FindBy(xpath = "//div[@class='woocommerce-MyAccount-content']") 
	private WebElement Content;
	

	
	public MyAccounthome(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	public WebElement Logoutlink() {
		return Logoutlink;
	}
	
	public WebElement Content() {
		return Content;
	}
	

}
