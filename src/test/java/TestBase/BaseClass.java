package testBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass{
	
	public WebDriver driver;
	public Properties p;
	
	@BeforeMethod
	public void setUp() throws IOException {
		//loading config.properties file
		FileInputStream file=new FileInputStream("./src/test/resources/config.properties");
		p=new Properties();
		p.load(file);
		
		//getting browser from confgi.properties file
		String browser = p.getProperty("Browser").toLowerCase();
		switch(browser) {
		case "chrome": driver=new ChromeDriver(); break;
		case "edge": driver=new EdgeDriver(); break;
		default:System.out.println("Invalid browser name.."); return;
			
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("AppUrl"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}