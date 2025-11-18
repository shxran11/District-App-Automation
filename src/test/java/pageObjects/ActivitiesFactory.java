package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActivitiesFactory extends BaseFactory {
	
	public ActivitiesFactory(WebDriver driver) {
		super(driver);
	}
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	@FindBy(xpath="//img[@alt='Game Zones Activity V2 [Taxonomy]']")
	WebElement gamesZone;
	
	@FindBy(xpath="//button/span[text()='This Weekend']")
	WebElement day_filter;
	
	@FindBy(xpath="//div/span[text()='Filters']")
	WebElement filtersButton;
	
	@FindBy(xpath="//div/label[@for='event_price_sort_Price : Low to High']")
	WebElement sortOption;
	
	@FindBy(xpath="//button/span[text()='Apply Filters']")
	WebElement applyFiltersButton;
	
	@FindBy(xpath="//h5[contains(@class, 'dds-tracking-tight dds-text-lg dds-font-semibold dds-o')]")
	List<WebElement> gamesList;
	
	@FindBy(xpath="//span[@class='dds-text-quaternary dds-text-sm dds-font-medium']")
	List<WebElement> timeList;
	
	public void clickGamesZone() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", gamesZone); 
		wait.until(ExpectedConditions.elementToBeClickable(gamesZone)).click();
	}
	
	public void clickDayFilter() {
		wait.until(ExpectedConditions.elementToBeClickable(day_filter)).click();
	}
	
	public void clickFiltersButton() {
		filtersButton.click();
	}
	
	public void clickSortOption() {
		sortOption.click();
	}
	
	public void clickApplyFilters() {
		applyFiltersButton.click();
	}
	
	public String getCheapestGame() {
		return gamesList.get(0).getText();
	}
	
	public String getCheapestGameTime() {
		return timeList.get(0).getText();
	}

}
