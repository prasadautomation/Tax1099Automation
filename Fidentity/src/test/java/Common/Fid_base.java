package Common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class Fid_base {

	public static WebDriver driver;
	public String assistedurl = "http://test-assisted.fidentity.com";
//	public String assisted=driver.getWindowHandle();

	public String packagekioskurl = "http://test-pickups.fidentity.com";
	public String testurl = "https://test-zengames.fidentity.com/";
	public String signupurl = "https://test-onboard.fidentity.com/signup.php?currency=gbp";

	public String configFileReader(String key) {
		BufferedReader reader;
		File file = new File("//Fidentity//src//test//java//paths.properties");

		String value = null;
		try {

			reader = new BufferedReader(new FileReader(file));
			Properties properties = new Properties();
			try {
				properties.load(reader);

				value = properties.getProperty(key);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + file);

		}
		return value;

	}

}
