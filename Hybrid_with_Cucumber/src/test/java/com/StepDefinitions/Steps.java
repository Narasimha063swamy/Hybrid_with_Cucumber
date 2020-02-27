package com.StepDefinitions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

import com.PageObjects.AddCustomerPage;
import com.PageObjects.LoginPage;
import com.PageObjects.SearchCustomerPage;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


// Here " * " is an regular expression-Which will match with all the imports of the @Given,@When,@Then keywords 

public class Steps extends BaseClass{
	// Now if you want execute the total script on the desired browser
	//you need to create the separate method(setup method) for Before class
	
	@Before
	public void setup() throws Exception 
	{
		logger=Logger.getLogger("nopCommerce");  // Added the logs
		PropertyConfigurator.configure("log4j.properties");	// Added the logs
		
		// by reading the properties file
		configprop =new Properties();
		FileInputStream configpropfile=new FileInputStream("C:\\Users\\admin\\MyWork\\Hybrid_with_Cucumber\\config.properties");
		configprop.load(configpropfile);
			
		String Br=configprop.getProperty("browser");
		
		if(Br.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", configprop.getProperty("chromepath"));
		driver=new ChromeDriver();
		driver.manage().window().maximize();	
		}
		else if(Br.equals("firefox"))
		{
		System.setProperty("webdriver.gecko.driver", configprop.getProperty("firefoxpath"));
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		}
		else if(Br.equals("InternetExplorer"))
		{
		System.setProperty("webdriver.ie.driver", configprop.getProperty("iepath"));
		driver=new InternetExplorerDriver();
		driver.manage().window().maximize();
		}
		logger.info("**********Launching the Browser**********");
	}
	
	
	@Given("User launch chrome browser")
	public void user_launch_chrome_browser() {
		
	/*	logger=Logger.getLogger("nopCommerce");  // Added the logs
		PropertyConfigurator.configure("log4j.properties");	// Added the logs
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver79.exe");
		driver=new ChromeDriver();
	logger.info("**********Launching the Browser**********");
		driver.manage().window().maximize();	*/
		
		lp=new LoginPage(driver);
	
	}

	@When("User open URL {string}")
	public void user_open_URL(String url) throws Exception {
		
	logger.info("**********Open the URL**********");
		driver.get(url);
	Thread.sleep(3000);
	
	}

	@When("User Enters Email as {string} and Password as {string}")
	public void user_Enters_Email_as_and_Password_as(String Email, String Password) {
		
		logger.info("********Provide the user login Details********");
		lp.setUsername(Email);
		lp.setPassword(Password);
		
	}

	@When("Click on Login")
	public void click_on_Login() throws Exception {
		
		logger.info("**********Click on Login Button**********");
		lp.Button();
		Thread.sleep(3000);
	
	}

	
	@Then("Page Title should be {string}")
	public void page_Title_should_be_the(String title) throws Exception {
	
		if(driver.getPageSource().contains("Login was unsuccessful.")) {
			driver.close();
			logger.info("**********Login is Passed**********");
		Assert.assertTrue(false);
		}else {
			logger.info("**********Login is Failed**********");
			Assert.assertTrue(true);
			
		}	
		Thread.sleep(3000);
	}

	@When("User Click on Logout Link")
	public void user_Click_on_Logout_Link() throws Exception {
		logger.info("**********Click on Logout link**********");
		lp.logout();
		Thread.sleep(3000);
	
	}

	@Then("Close Browser")
	public void close_Browser() {
		
		logger.info("**********Closing Browser**********");
		driver.close();
	}	


// Add Customer feature step definitions........
	
	@Then("User can View Dashboard")
	public void user_can_View_Dashboard() {
		AddCust=new AddCustomerPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", AddCust.getPageTitle());
	}
	
	@When("User Click on Customers menu")
	public void user_Click_on_Customers_menu() throws Exception {
		Thread.sleep(3000);
	 AddCust.ClickOnCustomersMenu();
	}
	
	@When("Click on Customers menu Item")
	public void click_on_Customers_menu_Item() throws Exception {
		Thread.sleep(3000);
	 AddCust.clickonCustomersMenuItem();
	}
	
	@When("Click on Add New Button")
	public void click_on_Add_New_Button() throws Exception {
		
	 AddCust.ClickOnAddNew();
	 Thread.sleep(3000);
	}
	
	@Then("User can view Add new Customer Page")
	public void user_can_view_Add_new_Customer_Page() {
	 
		Assert.assertEquals("Add a new customer / nopCommerce administration",AddCust.getPageTitle());
	}
	
	@When("User Enter Customers Info")
	public void user_Enter_Customers_Info() throws Exception {
	 
		logger.info("********Adding new Customer********");
		logger.info("**********Providing the new Customer details**********");
		String email=randomstring()+"@gmail.com";
	 AddCust.setEmail(email);
	 AddCust.setPassword("test123");
	Thread.sleep(3000);
	
	AddCust.setFirstNamre("Narasimhaswamy");
	AddCust.setLastName("Chunchu");

AddCust.setGender("male");
	
	AddCust.setDoB("10/06/1994");  // Format is dd/mm/yyy
	
	AddCust.setCompanyName("LiveTech");
	
	// Registered -Default
//The customer cannot be in both "Guests" and "Registered customer roles"	
	// Add the customer to "Guests" or "Registered" customer role
	
	//AddCust.setCusomerRoles("Guests");

	Thread.sleep(3000);
	AddCust.setManagerOfVendor("Vendor 2");
	
	
	AddCust.setAdminContent("This is for Testing......");
	
	}
	
	@When("Click on Save Button")
	public void click_on_Save_Button() throws Exception {
	 
		logger.info("********Saving the New Customer data********");
		AddCust.clickSave();
	 Thread.sleep(3000);
		
	}
	
	@Then("User can View confirmation message {string}")
	public void user_can_View_confirmation_message(String Msg) {
	 
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
				.contains("The new customer has been added successfully."));
	}
	// Steps for searching a customer using Email ID.....
	
	@When("Enter Customer Emamil")
	public void enter_Customer_Emamil() {
		
		logger.info("********Searching the Customer by using Email id********");
    searchCust=new SearchCustomerPage(driver);
	searchCust.setEmail("victoria_victoria@nopCommerce.com");
	// this email is we passing the input email(this email we are passing on text field/text box)
	}

	@When("Click on Search Button")
	public void click_on_Search_Button() throws Exception {
		searchCust.clickSearchBttn();
		Thread.sleep(3000);
	}

	@Then("User Should Found Email in the Search Table")
	public void user_Should_Found_Email_in_the_Search_Table() {
		// this email is there in the table available or not (This email we hope the assuming )
		boolean status=searchCust.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
		Assert.assertEquals(true, status);
		
	
	}
	// Steps for searching a customer using Firs tName and Last Name.....

	@When("Enter Customer FirstName")
	public void enter_Customer_FirstName() {
		
		logger.info("********Searching the Customer by using First Name and Last Name********");
		 searchCust=new SearchCustomerPage(driver);
		 searchCust.setFiratName("Victoria");
		
		
	}

	@When("Enter Customer LastName")
	public void enter_Customer_LastName() {
		searchCust.setLastName("Terces");
	}

	@Then("User Should Found Name in the Search Table")
	public void user_Should_Found_Name_in_the_Search_Table() {
	    
		boolean status=searchCust.SearchCustomerByName("Victoria Terces");
		Assert.assertEquals(false, status);
	}



}










