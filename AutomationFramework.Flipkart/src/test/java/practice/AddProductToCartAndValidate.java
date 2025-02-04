package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;


public class AddProductToCartAndValidate {

	

	public static void main(String[] args, Object productToBeAdded) {
		
		int x=100;
		int vv=0;   
	 int ymmm=0;
		int yy=0;
		int y = 0;  
		// step 1: Launch the browser
		WebDriver driver = new EdgeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.saucedemo.com/");
		
		// step 2: Login to Application
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
		
		// step 3: Click on Product - Sauce Labs Bike Light
		
		driver.findElement(By.xpath("//div[text()='Sauce Labs Bike Light']")).click();
		//String productToBeAdded = driver.findElement(By.xpath("//div[text()='Sauce Labs Bike Light'"));
	
		// step 4: Click on add To cart
		driver.findElement(By.id("add-to-cart")).click();
		
		// step 5: Navigate to Cart
		driver.findElement(By.id("shoping_cart_container")).click();
		
		// step 6: Validate the product
		String productDetailInCart = driver.findElement(By.className("inventory_item_name")).getText();
		
		
		if(productDetailInCart.equals(productToBeAdded))
		{
			System.out.println("PASS");
			System.out.println(productDetailInCart);
		}
		else
		{
			System.out.println("FAIL");
		}
				
	    // step 7: Logout of Application
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.linkText("Logout")).click();
		
  }

}
