package com.demo.pages;

import com.demo.Base.base;

public class Db extends base{
	    public static String GetCurrentURL() {
		String DashboardPageURL=driver.getCurrentUrl();
		return  DashboardPageURL;
	}

}
