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
	    	logger.info("*****Starting TC003_InvalidSignIn*****");
	    	String errorMsg = "";
	    	
	    	try 
	    	{
		        HomeFactory home = new HomeFactory(driver);
		        SignInFactory signIn = new SignInFactory(driver);
	 
		        home.clickSignIn();
		        logger.info("Sign in icon is clicked");
		        signIn.setMobile(p.getProperty("Inval_Mobile"));
		        logger.info("Invalid mobile number is entered");
		        signIn.clickContinue();
		        logger.info("Continue button is clicked to get the error message");
		        
		        
		        errorMsg = signIn.getErrorText();
		        
		        Assert.assertTrue(errorMsg.toLowerCase().contains("valid"), "Error message should indicate invalid input");
		        logger.info("Test passed");
    	    }
	    	
	    	catch(Exception e)
	    	{
	    		logger.error("Test failed: "+e.getMessage());
	    		Assert.fail("Test failed: "+e.getMessage());
    	    }
	    	
	    	finally {
	    		logger.info("-----Finished TC003_InvalidSignIn-----");
	    		System.out.println("Error Signin Message: " + errorMsg);
	    	}
	    }
	}
}