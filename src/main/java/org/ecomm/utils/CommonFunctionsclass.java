package org.ecomm.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.ecomm.Baseclass.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

public class CommonFunctionsclass extends BaseClass implements CommonFunctions {

	public String timestampstring() {
		String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

		return timestamp;

	}

	public String setScreenshotfilenameandpath(String Testname) {
		String screenshotfilename = Testname+"_"+ timestampstring() + ".png";
		String ssfilepath = userdirectory + "//ScreenshotsFolder//" + screenshotfilename;
		return ssfilepath;

	}

	@Override
	public void captureScreenshot(String Testname) {
		// TODO Auto-generated method stub

		TakesScreenshot capturesshot = ((TakesScreenshot) driver);
		File screenshotfile = capturesshot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshotfile, new File(setScreenshotfilenameandpath(Testname)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public JavascriptExecutor CreateJSexecutor() {
		jsexecutor = (JavascriptExecutor) driver;
		return jsexecutor;
	}

	@Override
	public void jsScrollwindowbypixel(int Xvalue, int Yvalue) {
		CreateJSexecutor().executeScript("window.scrollBy(" + Xvalue + "," + Yvalue + ")");
	}

	@Override
	public void jsScrolltillElement(WebElement Ele) {

		CreateJSexecutor().executeScript("arguments[0].scrollIntoView(true);", Ele);

	}

	@Override
	public void jsScrolltillEnd() {

		CreateJSexecutor().executeScript("window.scrollBy(0,document.body.scrollHeight)");

	}

}
