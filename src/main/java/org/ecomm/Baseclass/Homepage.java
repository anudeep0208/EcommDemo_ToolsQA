package org.ecomm.Baseclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {

	public WebDriver driver;
	
	@FindBy(xpath = "//a[normalize-space()='Dismiss']") 
	private WebElement Dismiss;

	@FindBy(xpath = "//a[normalize-space()='My Account']") 
	private WebElement MyAccount;
	
	public Homepage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	public WebElement DismissButton() {
		return Dismiss;
	}
	
	public WebElement MyAccountLink() {
		return MyAccount;
	}
	
}
