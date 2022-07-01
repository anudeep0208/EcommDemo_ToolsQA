package org.ecomm.pages;

import org.ecomm.Baseclass.BaseClass;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class Homepage extends BaseClass {

	public WebDriver driver;
	
	//constructor implementation
	
		public Homepage(WebDriver driver) {
			
			this.driver = driver;
			PageFactory.initElements(driver, this);

		}
	
	@FindBy(xpath = "//a[normalize-space()='Dismiss']") 
	private WebElement Dismiss;

	@FindBy(xpath = "//a[normalize-space()='My Account']") 
	private WebElement MyAccount;
	
	@FindBy(xpath = "//a[@class='custom-logo-link']//img[@alt='ToolsQA Demo Site']") 
	private WebElement Logo;

	@FindBy(xpath = "//a[@class='noo-search']") 
	private WebElement Searchicon;
	
	@FindBy(xpath = "//input[@name='s' and @class='form-control'] ") 
	private WebElement Searchinput;		

	
	public void ClickDismissButton() {
		Dismiss.click();
		Reporter.log("Clicked on the Dismiss button on the top banner");
	}
	
	public Loginpage ClickMyAccountLink() {
		 MyAccount.click();
		 Reporter.log("Clicked on the myaccount button on the top");
		 return new Loginpage(driver);
	}
	
	public boolean ValidateLogo() {
		 boolean flag = Logo.isDisplayed();
		 if(flag) {
			 Reporter.log("Verified the Logo on the application homepage");
			 }
		 else {
			 Reporter.log("Failed to verify the Logo on the application homepage");	 
		 }
		 return flag;	 
	}

	public void ClickSearchicon() {
		Searchicon.click();
	}
	
	public ProductListPage Enterproductname(String Pname) {
		Searchinput.sendKeys(Pname);
		Searchinput.sendKeys(Keys.ENTER);
		return new ProductListPage(driver);
	}
	
}
