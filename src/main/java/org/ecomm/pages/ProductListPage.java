package org.ecomm.pages;

import org.ecomm.Baseclass.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductListPage {

	public WebDriver driver;
	public String resulttext;
	
	@FindBy(xpath = "//div[@class='noo-catalog']")
	private WebElement ResultlistHeader;

	@FindBy(xpath = "//div[@class='noo-catalog']//p")
	private WebElement Resulttext;

	@FindBy(xpath = "//p[@class='woocommerce-info']")
	private WebElement Noitemsfound;
	
	@FindBy(xpath = "(//div[@class='noo-product-inner']//h3)[2]")
	private WebElement Seconditem;
	

	public ProductListPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public boolean Validatesearchresult() {

		return ResultlistHeader.isDisplayed();
	}

	public String Getsearchresulttext() {

		if (Resulttext.isDisplayed()) {
			resulttext = Resulttext.getText();
		} else if(Noitemsfound.isDisplayed()) {
			resulttext = Noitemsfound.getText();
		}
		return resulttext;
	}
	
	public Productdetailpage Selectseconditem() {
		
		Seconditem.click();
		return new Productdetailpage(driver);

		
	}

	public boolean seconditemexist() {
		// TODO Auto-generated method stub
		return Seconditem.isDisplayed();
	}

}
