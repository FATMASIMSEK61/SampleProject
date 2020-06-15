package com.hrms.testbase;

import com.hrms.pages.DashboardPageElements;
import com.hrms.pages.LoginPageElements;
import com.hrms.pages.PersonalDetailsPageElements;

//Initialize all pages classes and stores reference in static variables
	//that will called /used in test classes
	public class PageInitializer extends BaseClass{
		public static LoginPageElements login;
		public static PersonalDetailsPageElements pdetails;
		public static DashboardPageElements dashboard;
		
		public static void initialize() {
			
			login=new LoginPageElements();
			pdetails=new PersonalDetailsPageElements();
			dashboard=new DashboardPageElements();
		}
		
	}


