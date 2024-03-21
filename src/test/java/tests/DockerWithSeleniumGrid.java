/**
 * 
 */
package tests;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * 
 */
public class DockerWithSeleniumGrid {
	
	
	@BeforeClass
	void startDockerGrid() throws IOException, InterruptedException {
		Runtime.getRuntime().exec("cmd /c start start_dockergrid.bat");
		Thread.sleep(15000);
	}
	
	@AfterClass
	void stopDockerGrid() throws IOException, InterruptedException {
		Thread.sleep(15000);
		Runtime.getRuntime().exec("cmd /c start stop_dockergrid.bat");
		Thread.sleep(15000);
		
//		Runtime.getRuntime().exec("taskkill /f /im cmd.exe"); // closes all cmd prompt
//		Thread.sleep(15000);
	}

	@Test
	void testChrome(Method method) throws MalformedURLException {
		System.out.println(Thread.currentThread().getName());
		System.out.println(method.getName());
		
		ChromeOptions options = new ChromeOptions();

		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);

		driver.get("https://www.google.com/");

		System.out.println(driver.getTitle());

		driver.quit();
	}
	
	@Test
	void testEdge(Method method) throws MalformedURLException {
		System.out.println(Thread.currentThread().getName());
		System.out.println(method.getName());
		
		EdgeOptions options = new EdgeOptions();

		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);

		driver.get("https://www.google.com/");

		System.out.println(driver.getTitle());

		driver.quit();
	}
	
	@Test
	void testFirefox(Method method) throws MalformedURLException {
		System.out.println(Thread.currentThread().getName());
		System.out.println(method.getName());
		
		FirefoxOptions options = new FirefoxOptions();

		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);

		driver.get("https://www.google.com/");

		System.out.println(driver.getTitle());

		driver.quit();
	}

}
