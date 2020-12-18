

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Autoitsample {
	
	public void main(String args[]) {
	//System.setProperty("webdriver.chrome.driver","C:\\Users\\Sridevi\\Downloads\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("http://toolsqa.com/automation-practice-form");
	
	}
}
