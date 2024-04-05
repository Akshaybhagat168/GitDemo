package rahulshettyacademy.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

//import com.sun.net.httpserver.Authenticator.Retry;

import rahulshettyacademy.TestComponents.Retry;

import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class ErrorValidationTest extends BaseTest{
	

    @Test(groups = {"ErrorHandling"},retryAnalyzer=Retry.class)
    
	public void LoginErrorValidation () throws IOException, InterruptedException
	{
   
    	
		landingPage.loginApplication("akshaybhagat168@gmail.com", "Akshay@0");
	    Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage() );                             	
		
		

	}
	
    @Test
	public void ProductErrorValidation () throws IOException, InterruptedException
	{
   
		String productName = "ZARA COAT 3";
		ProductCatalogue productCatalogue = landingPage.loginApplication("akshaybhagat168@gmail.com", "Akshay@00");

		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goToCartPage();

		Boolean match = cartPage.VerifyProductDisplay("ZARA COAT 33");
		Assert.assertFalse(match);
	
		

	}

}






