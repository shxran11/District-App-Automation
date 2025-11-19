package pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MoviesFactory extends BaseFactory {
	
	public MoviesFactory(WebDriver driver) {
		super(driver);
	}
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	@FindBy(xpath="//span[text()='Filters']")
	WebElement filtersButton;
	
	@FindBy(xpath="//span[text()='Language']")
	WebElement languageButton;
	
	@FindBy(xpath="//span[contains(@class, 'dds-text-base dds-font-semibold ')]")
	List<WebElement> languageList;
	
	public void clickFiltersButton() {
		wait.until(ExpectedConditions.visibilityOf(filtersButton)).click();
	}
	
	public void clickLanguageButton() {
		wait.until(ExpectedConditions.visibilityOf(languageButton)).click();
	}
	
	public List<String> getLanguageList() {
		List<String> langList = new ArrayList<>();
		
		for (WebElement lang : languageList) {
			langList.add(lang.getText());
		}
		
		return langList;
	}
}
