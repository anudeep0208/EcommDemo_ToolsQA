package org.ecomm.pages;

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
	
	@FindBy(xpath = "//a[@class='custom-logo-link']//img[@alt='ToolsQA Demo Site']") 
	private WebElement Logo;
	
//constructor implementation
	
	public Homepage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	public void ClickDismissButton() {
		Dismiss.click();
	}
	
	public Loginpage ClickMyAccountLink() {
		 MyAccount.click();
		 return new Loginpage(driver);
	}
	
	public boolean ValidateLogo() {
		 return Logo.isDisplayed();
	}
	
}
