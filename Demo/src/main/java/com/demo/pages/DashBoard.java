package com.demo.pages;

import com.demo.Base.base;

public class DashBoard extends base{
	
	public String GetCurrentURL() {
		String DashboardPageURL=driver.getCurrentUrl();
		return DashboardPageURL;
	}

}
