package org.ecomm.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountpage {

	public WebDriver driver;

	@FindBy(xpath = "(//nav[@class='woocommerce-MyAccount-navigation']//ul//li)[6]")
	private WebElement Logoutlink;

	@FindBy(xpath = "//div[@class='woocommerce-MyAccount-content']")
	private WebElement Content;

	@FindBy(xpath = "//nav[@class='woocommerce-MyAccount-navigation']")
	private WebElement MyaccountMenu;
	
	@FindBy(xpath = "//a[@rel='home']")
	private WebElement Homeicon;
	
	

	public MyAccountpage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void ClickLogoutlink() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,250)");
		Logoutlink.click();
	}

	public boolean ValidateContent() {
		return Content.isDisplayed();
	}

	public boolean ValidateMyAccountMenu() {

		return MyaccountMenu.isDisplayed();
	}
	
	public Homepage Clickhomeicon() {
		Homeicon.click();
		return new Homepage(driver);
	}
}
