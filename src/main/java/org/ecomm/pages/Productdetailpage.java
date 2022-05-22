package org.ecomm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Productdetailpage {
	
	public WebDriver driver;
	public Productdetailpage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath = "//div[@class='summary entry-summary']//h1")
	private WebElement productnameheader;
	
	
	public boolean productnameheaderexist() {
		return productnameheader.isDisplayed();
	}
}
