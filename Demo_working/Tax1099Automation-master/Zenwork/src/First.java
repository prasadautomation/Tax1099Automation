import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;

public class First {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.print("Test");
		WebDriver driver= new ChromeDriver();
		//System.setProperty("webdriver.chrome.driver","D:\List_of_Jar\chromedriver.exe");
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sridevi\\Desktop\\chromedriver_win32.exe");
		
		//WebDriver driver= new ChromeDriver();
		
		driver.get("http://toolsqa.com/automation-practice-form");
		Thread.sleep(5000);

	}

}
