package com.hrms.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hrms.pages.AddEmployeePageElements;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.Constants;
import com.hrms.utils.ExcelUtility;
public class AddEmployeTest extends CommonMethods {
	//groups = {"regression" }
	@Test(dataProvider = "userDataFromExcel",groups="regression")
	public void addEmployee(String firstName, String lastName, String username, String password) {
		// login into HRMS
		login.login();
		// navigate to Add Employee page
		dashboard.navigateToAddEmployee();
		sleep(1);
		// add employee information
		test.info("Adding new employee with name: "+firstName+" "+lastName);
		sendText(addEmp.firstName, firstName);
		sendText(addEmp.lastName, lastName);
		// get EmployeeID
		//String expectedEmpId = addEmp.empId.getAttribute("value");
		// click on Create Login Details
		WaitandClick(addEmp.checkLogn);
	sleep(1);
		sendText(addEmp.username, username);
		sendText(addEmp.password, password);
		sendText(addEmp.confirmPasswrd, password);
		sleep(1);;
		jsClick(addEmp.btnSave);
		sleep(3);
		// validation
		//waitForVisibility(pdetails.empID);
		String actualName=firstName+" "+lastName;
		String expectedName=pdetails.profilePic.getText();
		//String actualEmpId = pdetails.empID.getAttribute("value");
		Assert.assertEquals(actualName, expectedName, "Employee Name did not match!");
		test.info("Validated that employee with name "+firstName+" "+lastName+" is successfully added");
		// take screenshot
		//Assert.assertEquals(actualEmpId, expectedEmpId);
		takeScreenshot(firstName + "_" + lastName);
	}
	private void sleep(int i) {
		// TODO Auto-generated method stub
		
	}
	//@DataProvider(name = "userData")
	public Object[][] getData() {
		Object[][] data = { { "Rajma", "Capoora", "raj1234353452", "AmirKhan_@123" },
							{ "John", "Smith", "john123", "AmirKhan_@123" },
							{ "Mary", "Ann", "mary123", "AmirKhan_@123" },
							{ "Rohani", "Sakhi", "rohani123", "AmirKhan_@123" },
							{ "Ali", "Tarlaci", "ali123", "AmirKhan_@123" }, };
		return data;
	}
	@DataProvider(name = "userDataFromExcel")
	public Object[][] getData2() {
		return ExcelUtility.excelIntroArray(Constants.TESTDATA_FILEPATH, "Sheet1");
	}
}