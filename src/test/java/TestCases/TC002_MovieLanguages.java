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
	        HomeFactory home = new HomeFactory(driver);
	        MoviesFactory movies = new MoviesFactory(driver);

	        home.clickMovies();
	        movies.clickFiltersButton();
	        movies.clickLanguageButton();

	        List<String> languages = movies.getLanguageList();
	        System.out.println("Available Languages: " + languages);
	        Assert.assertTrue(languages.size() > 0, "Languages list should not be empty");
	    }
	}



