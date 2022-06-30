package org.ecomm.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public interface CommonFunctions {
	
	public void captureScreenshot(String Testname);
	public JavascriptExecutor CreateJSexecutor();
	public void jsScrollwindowbypixel(int Xvalue, int Yvalue);
	public void jsScrolltillElement(WebElement Ele);
	public void jsScrolltillEnd();
	

}
