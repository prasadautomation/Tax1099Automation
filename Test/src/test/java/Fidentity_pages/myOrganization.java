package Fidentity_pages;




import java.sql.SQLException;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Common.Fid_base;

public class myOrganization extends Fid_base {
	
	@Test(enabled=true)
	public void billingMgmt() throws InterruptedException, ClassNotFoundException, SQLException  {
		//System.out.print("billing managemnt started");
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		ChromeOptions options = new ChromeOptions();
		options.setCapability(CapabilityType.HAS_NATIVE_EVENTS,false);
		
		 WebElement element =driver.findElement(By.xpath("//ul[@class='w-menu-two']//li//a[@data-tooltip='My Organisation']"));
			Actions actions = new Actions(driver);
			actions.moveToElement(element).click().perform();
	
			//WebDriverWait wait = new WebDriverWait(driver, 120);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='show_org']//div/span[3]//a")));
		/*	WebElement element2 = driver.findElement(By.xpath("//div[@id='show_org']//a[contains(text(),'Billing Management')]"));
			Actions actions2 = new Actions(driver);
			 actions2.moveToElement(element2).click(element2).perform();*/
			// driver.findElement(By.xpath("//div[@id='show_org']//a[contains(text(),'Billing Management')]")).click();
		
		WebElement billicon=driver.findElement(By.xpath("//div[@id='show_org']//a[contains(text(),'Billing Management')]"));
		 WebDriverWait wait4 = new WebDriverWait(driver, 30);
		wait4.until(ExpectedConditions.elementToBeClickable(billicon));
		billicon.click();
		System.out.print("billing managemnt clicked");
		Thread.sleep(5000);
		// driver.findElement(By.xpath("//div//span//a[contains(text(),'Manage Subscription')]")).click();
	
		
		driver.findElement(By.xpath("//div[@id='billing_features']//a[contains(text(),'Manage Subscription')]")).click();
		//driver.navigate().refresh();
		//choose different plan
		Thread.sleep(3000);
	WebElement diffplan=driver.findElement(By.xpath("//form[@id='license_form']/div/div[1]/div/div[2]/div[2]/a"));
		 WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(diffplan));
		diffplan.click();
		
		
			
		
		driver.findElement(By.xpath("//form[@id='license_form']/div/div[1]/div/div[2]/div[2]/a")).click();

	/*	JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", diffplan);
		Thread.sleep(3000);*/
		System.out.println("Choose different plan clicked");
	//	String myWindowHandle = driver.getWindowHandle();
		Thread.sleep(1000);
	//	driver.switchTo().window(myWindowHandle);
		
		WebDriverWait wait3 = new WebDriverWait(driver, 30);   
		wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("div//h1[contains(text(),'Visitor Management')]")));
	//	System.out.print("window switched");
	
		
		
		Select standardplans= new Select(driver.findElement(By.xpath("//div[@class='plans-container']/table/thead/tr/td[3]/div/select")));
		standardplans.selectByVisibleText("Annually - £ 309.86");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='standard-box']//a[contains(text(),'Choose Plan')]")).click();
		// Wait and check element visibility

		/* wait.until(ExpectedConditions.visibilityOf(planelement));
		Actions actions2 = new Actions(driver);
		actions2.moveToElement(planelement).click().perform();
		
		
		//driver.findElement(By.xpath("//div[@id='premium-box']/select")).click();

		//driver.findElement(By.xpath("//a[contains(text(),'Choose Different Plan')]")).click();
		//a[contains(text(),'Choose Different Plan')]
		// Wait and check element invisibility

	//	wait.until(ExpectedConditions.invisibilityOf(planelement));
		
		// driver.findElement(By.xpath("//div[contains(@class,'choose-another-plan')]//a[contains(text(),'Choose Different Plan')]")).click();
	/*	WebDriverWait wait2 = new WebDriverWait(driver, 120);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'choose-another-plan')]//a[contains(text(),'Choose Different Plan')]")));
		WebElement diffplan =driver.findElement(By.xpath("//div[contains(@class,'choose-another-plan')]//a[contains(text(),'Choose Different Plan')]"));
			Actions actions2 = new Actions(driver);
		actions2.moveToElement(diffplan).click().perform();
driver.findElement(By.xpath("//*[@id='premium-box']/select")).click();

System.out.println("Choose different plan clicked");
*/
			
	/*	WebElement diffplan =driver.findElement(By.xpath("//form[@id='license_form']//div[@class='licences-summary']//a[contains(text(),'Choose Different Plan')]"));
			String my_attribute = diffplan.getAttribute("innerHTML");
				    if (my_attribute == "Choose Different Plan");
				    diffplan.click();*/
			
		
		
			
			
			
	
		
		//span[contains(text(),'Standard')]//following-sibling::select[@class='browser-default']
		
	/*	Select standardplans= new Select(driver.findElement(By.xpath("//span[contains(text(),'Standard')]//following-sibling::select[@class='browser-default']")));
		standardplans.selectByVisibleText("Monthly - $ 34.99");
		driver.findElement(By.xpath("//div[@id='standard-box']//a[contains(text(),'Choose Plan')]")).click();
		
		System.out.println("Due to bug 523 im unable to proceed to change the plan from current plan");*/
		
		
		/*DataBase_connection db=new DataBase_connection();
		 db.dbconnection();
				
		ResultSet rs=db.stmt.executeQuery("SELECT * FROM test_checkon_central.customer_subscriptions_v2;");
		System.out.print(rs);    
		
		while (rs.next()){
			String code=rs.getString(1);
		System.out.println(code);*/
		
		/*if(code==sms_notification) {
			System.out.print("correct gatepass recieved by vivistor");
		}else {System.out.print("wrong sms recieved by visitor");}*/
		
		//Assert.assertEquals(true,code.contains(sms_gatepass_notification));
		//System.out.println("recieved correct genearte gatepass sms");
	 }
		
		//SELECT * FROM test_checkon_central.customer_subscriptions_v2
		
		//----------continue the same plan-----------------//
	/*	driver.findElement(By.xpath("//input[@id='cardholdername']")).sendKeys("Sree");
		//driver.findElement(By.xpath("//div[@id='card-number' and @class='field empty StripeElement']")).sendKeys("4242424242424242");
			//driver.findElement(By.xpath("//input[@class='__PrivateStripeElement-input']")).sendKeys("4242424242424242");
		//driver.switchTo().frame(driver.findElement(By.xpath("//div[@id='card-number']")));
		driver.findElement(By.xpath("//span[@class='InputContainer']//input[@name='cardnumber']")).sendKeys("4242424242424242");*/
		
		
	}

			
		
		
	


