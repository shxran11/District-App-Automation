package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import testBase.BaseClass;
import pageObjects.ActivitiesFactory;
import pageObjects.HomeFactory;

public class TC001_SportsActivities extends BaseClass {

		
	    @Test(priority=1)
	    public void displayCheapestActivity() {
	        HomeFactory home = new HomeFactory(driver);
	        ActivitiesFactory activities = new ActivitiesFactory(driver);

	        home.clickActivities();
	        activities.clickGamesZone();
	        activities.clickDayFilter();
	        activities.clickFiltersButton();
	        activities.clickSortOption();
	        activities.clickApplyFilters();
	        

	        String gameName = activities.getCheapestGame();
	        String gameTime = activities.getCheapestGameTime();

	        System.out.println("Cheapest Activity This Weekend: " + gameName);
	        System.out.println("Date/Time: " + gameTime);
	        Assert.assertTrue(gameName != null && !gameName.isEmpty(), "Game name should be displayed");
	    }
	}



