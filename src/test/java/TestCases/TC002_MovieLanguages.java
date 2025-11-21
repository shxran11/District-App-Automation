package TestCases;
 
import java.util.List;
 
import org.testng.Assert;
import org.testng.annotations.Test;
 
import TestBase.BaseClass;
import pageObjects.HomeFactory;
import pageObjects.MoviesFactory;
 
public class TC002_MovieLanguages extends BaseClass {
	
	
 
	    @Test(priority=2)
	    public void displayMovieLanguages() {
	    	logger.info("*****Starting TC002_MovieLanguages*****");
	    	
	    	try 
	    	{
		        HomeFactory home = new HomeFactory(driver);
		        MoviesFactory movies = new MoviesFactory(driver);
	 
		        home.clickMovies();
		        logger.info("Clicked on Movies button");
		        movies.clickFiltersButton();
		        logger.info("Selected filters");
		        movies.clickLanguageButton();
		        logger.info("Selected language");
	 
		        List<String> languages = movies.getLanguageList();
		        System.out.println("Available Languages for Movies: " + languages);
		        Assert.assertTrue(languages.size() > 0, "Languages list should not be empty");
		        logger.info("Test passed");
	    	}
	    	
	    	catch(Exception e)
	    	{
	    		logger.error("Test failed: "+e.getMessage());
	    		Assert.fail("Test failed: "+e.getMessage());
	    	}
	    	
	    	finally {
	    		logger.info("-----Finished TC002_MovieLanguages-----");
	    	}
	    }
	}