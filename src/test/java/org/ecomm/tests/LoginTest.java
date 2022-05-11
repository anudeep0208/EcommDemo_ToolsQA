package org.ecomm.tests;

import org.ecomm.Baseclass.BaseClass;
import org.ecomm.Baseclass.Homepage;
import org.ecomm.Baseclass.Loginpage;
import org.ecomm.Baseclass.MyAccounthome;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseClass {

	public Homepage homepage;
	public Loginpage loginpage;
	public MyAccounthome myaccounthomepage;
	
	@Test
	public void LoginTestmethod() {
		
		homepage = new Homepage(driver);
		homepage.DismissButton().click();
		homepage.MyAccountLink().click();
		
		loginpage = new Loginpage(driver);
		Assert.assertTrue(loginpage.LoginHeader().isDisplayed());
		loginpage.Username().sendKeys(prop.getProperty("useremail"));
		loginpage.Password().sendKeys(prop.getProperty("userpassword"));
		loginpage.LoginButton().click();
		
		myaccounthomepage = new MyAccounthome(driver);
		Assert.assertTrue(myaccounthomepage.Content().isDisplayed());
		myaccounthomepage.Logoutlink().click();
		Assert.assertTrue(loginpage.LoginHeader().isDisplayed());
	}
	
}
