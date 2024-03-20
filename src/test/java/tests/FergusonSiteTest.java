/**
 * 
 */
package tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 */
public class FergusonSiteTest {

	@Test
	void captureAllCategory() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.ferguson.com/category/3m-2/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		System.out.println("All products");
		
		List<WebElement> proList=driver.findElements(By.cssSelector(".plp-name-rating-container h3"));
	    int	size=proList.size();
		proList.stream().forEach(pro->System.out.println(pro.getText()));
		
		
		
		boolean flag=true;
//		int i=1;
		while(flag) {
		
		
			
		
		WebElement button=driver.findElement(By.cssSelector(".show-more button"));
		
		
		
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", button);
		
		if(button.isDisplayed()) {
			button.click();
			Thread.sleep(3000);
			System.out.println("Products after Show More Button clicked**************");
			proList=driver.findElements(By.cssSelector(".plp-name-rating-container h3"));
			System.out.println(proList.size());
			System.out.println(proList.size()-size);
			for(int i=1;i<=proList.size()-size;i++) {
				WebElement ele=driver.findElement(By.xpath("(//div[@class='pdp-link']//a//h3)["+(size+i)+"]"));
				System.out.println(ele.getText());
			}
		}
		else {
			flag=false;
			break;
		}
//		i++;
		}
	}
}
