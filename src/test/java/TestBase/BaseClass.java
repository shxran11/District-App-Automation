package TestBase;
 
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
 
public class BaseClass{
	
	public WebDriver driver;
	public Logger logger;
	public Properties p;
	
	@BeforeMethod
	@Parameters({"Browser"})
	public void setUp(String browser) throws IOException {
		//loading config.properties file
		FileInputStream file=new FileInputStream("./src/test/resources/config.properties");
		p=new Properties();
		p.load(file);
		
		//loading log4j file
		logger = LogManager.getLogger(this.getClass());
		
		if (p.getProperty("execution_env").equals("remote")) {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			
			switch(browser.toLowerCase()) {
				case "chrome": capabilities.setBrowserName("chrome"); break;
				case "edge": capabilities.setBrowserName("MicrosoftEdge"); break;
				default: System.out.println("No matching browser.."); return;
			}
			
			driver = new RemoteWebDriver(new URL("http://localhost:4444/"), capabilities);
		}
		
		else if (p.getProperty("execution_env").equals("local")) {
			switch(browser.toLowerCase()) {
				case "chrome": driver=new ChromeDriver(); break;
				case "edge": driver=new EdgeDriver(); break;
				default:System.out.println("Invalid browser name.."); return;
			}	
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		driver.get(p.getProperty("AppUrl"));
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}