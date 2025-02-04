package practice;


import org.testng.annotations.Test;

//Run All

public class TestNGPractice {
	
    //priority
	//invocation count
	//dependsOnmethods
	//enabled
	//dataprovider

	    @Test
		public void sampleTest1()
		{
			System.out.println("Sample1");//pass
		}

		//@Test(dependsOnMethods = "sampleTest1")
				//Run | Debug
		public void sampleTest2()
		{
			System.out.println("sample2");
		}
				
		//@Test
		//Run | Debug
		public void sampleTest3()
		{
			System.out.println("sample3");
		}


}
