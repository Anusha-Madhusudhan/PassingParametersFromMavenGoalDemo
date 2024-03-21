/**
 * 
 */
package tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

/**
 * 
 */
public class DockerDemoWithChrome {
	
	@Test
	void testDockerDemoWithChrome() throws MalformedURLException {
		ChromeOptions options=new ChromeOptions();
		
		RemoteWebDriver driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
		
		driver.get("https://www.google.com/");
		
		System.out.println(driver.getTitle());
		
		driver.quit();
		
	}
	
	@Test
	void testDockerDemoWithFirefox() throws MalformedURLException {
		FirefoxOptions options=new FirefoxOptions();
		
		RemoteWebDriver driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
		
		driver.get("https://www.google.com/");
		
		System.out.println(driver.getTitle());
		
		driver.quit();
		
	}

}
