package org.ecomm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountpage {

	public WebDriver driver;

	@FindBy(xpath = "//a[normalize-space()='Logout']")
	private WebElement Logoutlink;

	@FindBy(xpath = "//div[@class='woocommerce-MyAccount-content']")
	private WebElement Content;
	
	@FindBy(xpath = "//nav[@class='woocommerce-MyAccount-navigation']") 
	private WebElement MyaccountMenu;

	public MyAccountpage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void ClickLogoutlink() {
		Logoutlink.click();
	}

	public boolean ValidateContent() {
		return Content.isDisplayed();
	}

	public boolean ValidateMyAccountMenu() {

		return MyaccountMenu.isDisplayed();
	}

}
