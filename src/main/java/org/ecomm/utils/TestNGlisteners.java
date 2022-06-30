package org.ecomm.utils;

import org.ecomm.Baseclass.BaseClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGlisteners extends BaseClass implements ITestListener{
	
	public CommonFunctions commonfuncs = new CommonFunctionsclass();

	@Override
	public void onTestStart(ITestResult result) {
		
		System.out.println("The Test "+result.getName()+" Started");
		
	}
	

	@Override
	public void onTestSuccess(ITestResult result) {
		
		System.out.println("The Test "+result.getName()+" Passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String TestcaseName = result.getName();
		System.out.println("The Test "+result.getName()+" failed and screenshot captured");
		commonfuncs.captureScreenshot(TestcaseName);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		System.out.println("The Test "+result.getName()+" skipped");
	}


	@Override
	public void onStart(ITestContext context) {
	}

	@Override
	public void onFinish(ITestContext context) {
		}

}
