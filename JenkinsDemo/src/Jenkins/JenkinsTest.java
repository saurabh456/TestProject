/**
 * 
 */
package Jenkins;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/**
 * @author saurabh
 *
 */
public class JenkinsTest 
{

	@Test
	public void test1() {
		System.out.println("welcome to Jenkins");
		
		System.setProperty("webdriver.chrome.driver", "c:\\chromedriver_win32(1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.quit();
		
	}
	
	
}
