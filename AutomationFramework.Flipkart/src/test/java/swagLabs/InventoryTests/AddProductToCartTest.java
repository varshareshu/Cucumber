package swagLabs.InventoryTests;

import java.io.IOException;
import SwagLabs.GenericUtility.SeleniumUtility;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import SwagLabs.GenericUtility.BaseClass;
import SwagLabs.ObjectRepository.CartPage;
import SwagLabs.ObjectRepository.InventoryPage;
import SwagLabs.ObjectRepository.ProductPage;

@Listeners(SwagLabs.GenericUtility.ListenersImplementation.class)
public class AddProductToCartTest  extends BaseClass {
	
	@Test(groups = "SmokeSuite")
	public void tc_001_AddProductToCartTest() throws IOException
	{
		//Read Test Data From Excel File
		String PRODUCTNAME = eUtil.readDataFromExcel("Inventory", 1,2);
		System.out.println(PRODUCTNAME);
		
		// Step 1:Click on product - ProductName from excel
		InventoryPage ip = new InventoryPage(driver);
		String productAdded = ip.clickOnAnyProduct(driver, PRODUCTNAME);
		SeleniumUtility s = new SeleniumUtility();
		
		try {
			String screenshotName = "tc_001_AddProductToCartTest";
		  s.captureScreenShot(BaseClass.sdriver, screenshotName);
	    }
		catch (IOException e)
		{
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
		//step 2:click on add To cart button
		ProductPage pp = new ProductPage(driver);
		 
		pp.clickOnAddToCartBtn();
		
		//Step 3: Navigate to Cart
		ip.clickOnCartContainer();
		
		//Assert.fail();
		
		//step 4: Validate the Product in Cart
		CartPage cp = new CartPage(driver);
		String productInCart = cp.getProductInfo();
		
		Assert.assertEquals(productInCart, productAdded);
		
		Assert.assertTrue(productInCart.equals(productAdded));
		
		System.out.println(productInCart);
		
     }	
	
	@Test(retryAnalyzer = SwagLabs.GenericUtility.RetryAnalyserImplementation.class)
	public void sampleTest()
	{
		Assert.fail();
		System.out.println("sample");
	}


}
	
	
	
	
	


