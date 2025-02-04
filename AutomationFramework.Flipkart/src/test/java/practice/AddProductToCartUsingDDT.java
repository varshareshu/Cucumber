package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class AddProductToCartUsingDDT {

	
public static void main(String[] args) throws IOException  {
		
	//Read The Common Data From Property File
	FileInputStream fis= new FileInputStream (".\\src\\test\\resources\\CommonData.properties");
	Properties p = new Properties();
	p.load(fis);
	String URL = p.getProperty("url");
	String USERNAME = p.getProperty("username");
	String PASSWORD = p.getProperty("password");
	
	//Read Test Data From Excel File
	FileInputStream fise = new FileInputStream("\\src\\test\\resources\\TestData.xlsx");
	Workbook wb = WorkbookFactory.create(fise);
	Sheet sh = wb.getSheet("Inventory");
	Row rw = sh.getRow(1);
	Cell cl =rw.getCell(2);
	String PRODUCTNAME = cl.getStringCellValue();
	System.out.println(PRODUCTNAME);
	
	//Step 1: Launch the browser
	//Step 1: Launch the browser
	WebDriver driver = new EdgeDriver();
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//selenium4
	
	driver.get(URL);
	
	//Step 2: Login to Application
	driver.findElement(By.id("user-name")).sendKeys(USERNAME);
	driver.findElement(By.id("password")).sendKeys(PASSWORD);
	driver.findElement(By.id("login-button")).click();
	
	//Step 3: Click on product - use Dynamic Xpath to pass ProductName from excel sheet
	WebElement ProductToBeAdded = driver.findElement(By.xpath("//div[text()='Sauce Labs Bike Light'"));
    driver.findElement(By.xpath("//div[text()='Sauce Labs Bike Light']")).click();		
    
    //Steps 4: click on add To cart
    driver.findElement(By.id(("add-to-cart"))).click();
    
    //steps 5: Navigate to cart
    driver.findElement(By.id(("shopping_cart_container"))).click();
    
    //steps 6: Validate the product
    String productDetailInCart = driver.findElement(By.className("inventory_item_name")).getText();
    if(productDetailInCart.equals(ProductToBeAdded))
    {
    	System.out.println("PASS");
    	System.out.println(productDetailInCart);
    }
    else
    {
    	System.out.println("Fail");
    }
    
    //step 7: Logout of Application
    driver.findElement(By.id("react-burger-menu-btn")).click();
    driver.findElement(By.linkText("Logout")).click();
    }

}
