package swagLabs.InventoryTests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import SwagLabs.GenericUtility.BaseClass;

@Listeners(SwagLabs.GenericUtility.ListenersImplementation.class)

public class RemoveProductTest  extends BaseClass {
	  
	 @Test(groups = "RegressionSuite")
     public void tc_002_removeProductTest()
	  {
		  System.out.println("product Removed");
	  }
	
}
