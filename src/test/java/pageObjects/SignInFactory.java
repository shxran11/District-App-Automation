package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInFactory extends BaseFactory{

	public SignInFactory(WebDriver driver) {
		super(driver);
	}
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	@FindBy(xpath="//input[@placeholder='Enter mobile number']")
	WebElement mobileInput;
	
	@FindBy(xpath="//button[text()='Continue']")
	WebElement continueButton;
	
	@FindBy(xpath="//p[contains(@class, 'dds-text-red-500')]")
	WebElement errorText;
	
	public void setMobile(String number) {
		mobileInput.sendKeys(number);
	}
	
	public void clickContinue() {
		continueButton.click();
	}
	
	public String getErrorText() {
		return errorText.getText();
	}
}

