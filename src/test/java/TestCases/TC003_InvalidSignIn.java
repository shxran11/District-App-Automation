package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObjects.HomeFactory;
import pageObjects.SignInFactory;

public class TC003_InvalidSignIn {

	

	public class InvalidSignInTest extends BaseClass {

	    @Test(priority=3)
	    public void invalidSignIn() {
	        HomeFactory home = new HomeFactory(driver);
	        SignInFactory signIn = new SignInFactory(driver);

	        home.clickSignIn();
	        signIn.setMobile(p.getProperty("Inval_Mobile"));
	        signIn.clickContinue();
	        
	        String errorMsg = signIn.getErrorText();
	        System.out.println("Error Message: " + errorMsg);
	        
	        Assert.assertTrue(errorMsg.toLowerCase().contains("valid"), "Error message should indicate invalid input");
	    }
	}
}

	

