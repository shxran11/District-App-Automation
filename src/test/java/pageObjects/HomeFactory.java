package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeFactory extends BaseFactory{
	
	public HomeFactory(WebDriver driver) {
		super(driver);
	}
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	@FindBy(linkText="Activities")
	WebElement activitiesLink;
	
	@FindBy(linkText="Movies")
	WebElement moviesLink;
	
	@FindBy(xpath="//div[contains(@class, 'dds-w-[42px]')]")
	WebElement signInLink;
	
	public void clickActivities() {
		wait.until(ExpectedConditions.elementToBeClickable(activitiesLink)).click();
	}
	
	public void clickMovies() {
		wait.until(ExpectedConditions.visibilityOf(moviesLink)).click();
	}
	
	public void clickSignIn() {
		signInLink.click();
	}
	
}
