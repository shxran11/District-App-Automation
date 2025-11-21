package TestCases;
 
import org.testng.Assert;
import org.testng.annotations.Test;
 
import TestBase.BaseClass;
import pageObjects.ActivitiesFactory;
import pageObjects.HomeFactory;
 
public class TC001_SportsActivities extends BaseClass {
 
		
	    @Test(priority=1)
	    public void displayCheapestActivity() {
	    	logger.info("*****Starting TC001_SportsActivities*****");
	    	
	    	try 
	    	{
		        HomeFactory home = new HomeFactory(driver);
		        ActivitiesFactory activities = new ActivitiesFactory(driver);
	 
		        home.clickActivities();
		        logger.info("Clicked on Activities button");
		        activities.clickGamesZone();
		        logger.info("Clicked on Games Zone");
		        activities.clickDayFilter();
		        logger.info("Clicked on day filter");
		        activities.clickFiltersButton();
		        logger.info("Filter is selected");
		        activities.clickSortOption();
		        activities.clickApplyFilters();
		        logger.info("Price is selected from Low to High range");
		        
	 
		        String gameName = activities.getCheapestGame();
		        String gameTime = activities.getCheapestGameTime();
	 
		        System.out.println("Cheapest Activity This Weekend: " + gameName);
		        System.out.println("Date/Time: " + gameTime);
		        Assert.assertTrue(gameName != null && !gameName.isEmpty(), "Game name should be displayed");
		        logger.info("Test passed");
	    	}
	    	
	    	catch(Exception e)
	    	{
	    		logger.error("Test failed: "+e.getMessage());
	    		Assert.fail("Test failed: "+e.getMessage());
	    	}
	    	
	    	finally {
	    		logger.info("-----Finished TC001_SportsActivities-----");
	    	}
	    }
	}