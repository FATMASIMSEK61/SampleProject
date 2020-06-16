package com.hrms.testbase;

import com.hrms.pages.AddEmployeePageElements;
import com.hrms.pages.DashboardPageElements;
import com.hrms.pages.LoginPageElements;
import com.hrms.pages.PersonalDetailsPageElements;

//Initialize all pages classes and stores reference in static variables
	//that will called /used in test classes
	public class PageInitializer extends BaseClass{
		
		public static LoginPageElements login;
		public static PersonalDetailsPageElements pdetails;
		public static DashboardPageElements dashboard;
		public static AddEmployeePageElements addEmp;
		//public static sauceDemoLoginPage demosauce;
		//public static EmployeeListPage empList;
		//public static PredefinedReportPage reports;
		
		public static void initialize() {
			
			login=new LoginPageElements();
			pdetails=new PersonalDetailsPageElements();
			dashboard=new DashboardPageElements();
			addEmp = new AddEmployeePageElements();
			//demosauce = new sauceDemoLoginPage();
			//empList=new EmployeeListPage();
			//reports=new PredefinedReportPage();
		}
		
	}


