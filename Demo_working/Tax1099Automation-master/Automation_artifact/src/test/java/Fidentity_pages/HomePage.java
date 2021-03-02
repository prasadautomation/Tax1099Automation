package Fidentity_pages;




import org.openqa.selenium.chrome.ChromeDriver;


//import org.openqa.selenium.chrome.ChromeDriver;

import Common.Fid_base;


public class HomePage  extends Fid_base {

		public void signIn() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Sridevi\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	
	 public void openhomemage() {
			driver.get("https://test.fidentity.com/");
		}
	
 

}
