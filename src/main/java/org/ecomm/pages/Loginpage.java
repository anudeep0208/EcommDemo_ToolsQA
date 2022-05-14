package org.ecomm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {

	private WebDriver driver;

	public Loginpage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h2[normalize-space()='Login']") 
	private WebElement LoginHeader;

	@FindBy(xpath = "//input[@id='username']") 
	private WebElement Username;

	@FindBy(xpath = "//input[@id='password']") 
	private WebElement Password;
	
	@FindBy(xpath = "//button[normalize-space()='Log in']") 
	private WebElement LoginButton;
	
	public boolean ValidateLoginHeader() {
		return LoginHeader.isDisplayed();
	}
	
	public WebElement Username() {
		return Username;
	}
	
	public WebElement Password() {
		return Password;
	}
	
	public WebElement LoginButton() {
		return LoginButton;
	}
	
	public MyAccountpage performLogin(String Cust_username, String Cust_password) {
		
		Username.sendKeys(Cust_username);
		Password.sendKeys(Cust_password);
		LoginButton.click();
		return new MyAccountpage(driver);
	}
	
	
	
}
