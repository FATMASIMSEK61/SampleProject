package com.hrms.testbase;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {
	
	public void onStart(ITestContext context) {
		System.out.println("FunctionalityTesting start");

}
	
	public void onFinish(ITestContext context) {
		System.out.println("FunctionalityTesting finished");
	}
	
	public void onTestStart(ITestResult result) {
		System.out.println("test started"+result.getName());
		
		
	}
	public void onTestSuccess(ITestResult result){
		System.out.println("Test passed"+result.getName());
	}
	public void onTestFailure(ITestResult result) {
		System.out.println("Test failled"+result.getName());
	}
}
