package com.hrms.testbase;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {
	
	public void onStart(ITestContext context) {//this listener executes on <test> from xml file
		System.out.println("FunctionalityTesting start");

}
	
	public void onFinish(ITestContext context) {
		System.out.println("FunctionalityTesting finished");
	}
	
	public void onTestStart(ITestResult result) {//this listenerexecutes whwn @test method stars
		System.out.println("test started"+result.getName());
		BaseClass.report.createTest(result.getName());
		
	}
	public void onTestSuccess(ITestResult result){
		System.out.println("Test passed"+result.getName());
	}
	
	public void onTestFailure(ITestResult result) {
		System.out.println("Test failled"+result.getName());
	}


}
