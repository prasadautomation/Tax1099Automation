package com.demo.pages;

import com.demo.Base.base;

public class Db extends base{
	    public String GetCurrentURL() {
		String DashboardPageURL=driver.getCurrentUrl();
		return  DashboardPageURL;
	}

}
