package org.ecomm.tests;

import org.ecomm.Baseclass.BaseClass;
import org.ecomm.pages.Homepage;
import org.ecomm.pages.Loginpage;
import org.ecomm.pages.MyAccountpage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseClass {

	public Homepage homepage;
	public Loginpage loginpage;
	public MyAccountpage myaccounthomepage;

	@Test(priority = 1)
	public void LaunchAppandValidatepage() {
		homepage = new Homepage(driver);
		homepage.ClickDismissButton();
		Assert.assertTrue(homepage.ValidateLogo());
	}

	@Test(priority = 2)
	public void Navigatetologinpage() {
		loginpage = homepage.ClickMyAccountLink();
		Assert.assertTrue(loginpage.ValidateLoginHeader());
	}

	@Test(priority = 3)
	public void LogintoApplication() {

		myaccounthomepage = loginpage.performLogin(GetProperty("useremail"), GetProperty("userpassword"));
		Assert.assertTrue(myaccounthomepage.ValidateContent());
		Assert.assertTrue(myaccounthomepage.ValidateMyAccountMenu());
		homepage = myaccounthomepage.Clickhomeicon();
		// captureScreenshot();

	}

}
