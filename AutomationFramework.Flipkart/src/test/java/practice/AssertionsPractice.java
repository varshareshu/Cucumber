package practice;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

//Run All
  public class AssertionsPractice {
	
//  @Test
//  Run | Debug
	public void sample()
	{
		System.out.println("Step 1");
		System.out.println("Step 2");
		System.out.println("Step 3");
		
		Assert.assertEquals(1, 1); //fail
		
		System.out.println("Step 4");
		
		Assert.assertTrue(false); //fail
		
		System.out.println("Step 5");
		
	}	
	 
	//@Test
	//Run | Debug
	public void sampleSoft()
	{
        SoftAssert sa = new SoftAssert();	
        
		System.out.println("Step 1");
		System.out.println("Step 2");
		System.out.println("Step 3");
		
		sa.assertEquals(0,1);
		
		System.out.println("Step 4");
		
		sa.assertEquals("c","d");
		
		System.out.println("Step 5");
		
		sa.assertAll();
		
   }

 }