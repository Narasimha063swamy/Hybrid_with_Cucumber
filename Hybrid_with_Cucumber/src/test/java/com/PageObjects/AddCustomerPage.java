package com.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {

	public WebDriver ldriver;
	public AddCustomerPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	By LinkCusomers_Menu=By.xpath("//a[@href='#']//span[contains(text(),'Customers')]");
	
	By Customers_Menu=By.xpath("/html/body/div[3]/div[2]/div/ul/li[4]/ul/li[1]/a");
	//By Customers_Menu=By.className("menu-item-link");
	
	By btnAddNew=By.xpath("//a[@class='btn bg-blue']");
	
	By Email=By.xpath("//*[@id=\'Email\']");
	
	By Password=By.xpath("//*[@id=\'Password\']");
	
	By FirstName=By.xpath("//input[@id='FirstName']");
	
	By LastName=By.xpath("//input[@id='LastName']");
	
By rdMaleGender=By.id("Gender_Male");
	
	By rdFemaileGender=By.id("Gender_Female");
	
	By DoB=By.xpath("//input[@id='DateOfBirth']");
	
	By CompanyName=By.xpath("//input[@id='Company']");
	
	By CustomersRole=By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']");
	
	By lstitemAdministrators=By.xpath("//li[contains(text(),'Administrators']");
	
	By lstitemGuests=By.xpath("//li[contains(text(),'Guests']");
	
	By lstitemRegitered=By.xpath("//li[contains(text(),'Registered']");
	
	By lstitemsVenders=By.xpath("//li[contains(text(),'Vendors']");

	
	
	By drpmgrofVendor=By.xpath("//*[@id='VendorId']");
	
	By AdminContent=By.xpath("//textarea[@id='AdminComment']");
	
	By ButtonSave=By.xpath("/html/body/div[3]/div[3]/div/form/div[1]/div/button[1]");
	
	// Action Methods
	
	public String getPageTitle() {
		return ldriver.getTitle();
	}
	
	public void ClickOnCustomersMenu(){
		ldriver.findElement(LinkCusomers_Menu).click();
	}
	public void clickonCustomersMenuItem() {
		ldriver.findElement(Customers_Menu).click();
	}
	public void ClickOnAddNew() {
		ldriver.findElement(btnAddNew).click();
		
	}
	public void setEmail(String email) {
		ldriver.findElement(Email).sendKeys(email);
	}
	public void setPassword(String PWD) {
		ldriver.findElement(Password).sendKeys(PWD);
	}
	public void setFirstNamre(String Fname) {
		ldriver.findElement(FirstName).sendKeys(Fname);
	}
	public void setLastName(String Lname) {
		ldriver.findElement(LastName).sendKeys(Lname);
	}
public void setGender(String gender) 
	{
		if(gender.equals("Male")) {
			ldriver.findElement(rdMaleGender).click();
		}else if(gender.equals("Female")) {
			ldriver.findElement(rdFemaileGender).click();
		}else {
			ldriver.findElement(rdMaleGender).click();
		}
	}
	public void setDoB(String dob) {
		ldriver.findElement(DoB).sendKeys(dob);
	}
	public void setCompanyName(String Cname) {
		ldriver.findElement(CompanyName).sendKeys(Cname);
	}
	
	//public void setCusomerRoles(String role) throws Exception {
	//public void setCusomerRoles(String value) throws Exception {	
	
	/*	if(!role.equals("Vendores")) {
			ldriver.findElement(By.xpath("//*[@id=\"VendorId\"]"));
		}
		ldriver.findElement(CustomersRole).click();
		WebElement listItem;
		Thread.sleep(3000);
		
		if(role.equals("Administrators")) {
			listItem=ldriver.findElement(lstitemAdministrators);
		}
		else if(role.equals("Guests"))
		{ 
			listItem=ldriver.findElement(lstitemGuests);
		}else if(role.equals("Registered")){
			listItem=ldriver.findElement(lstitemRegitered);
		}else if(role.equals("Vendores")){
			listItem=ldriver.findElement(lstitemsVenders);
		}else{
			listItem=ldriver.findElement(lstitemGuests);
	}	*/
		//Select RL=new Select(ldriver.findElement(lstitemGuests));
		//RL.selectByVisibleText(value);
	//	listItem.click();
		//Thread.sleep(3000);
	
		// Some times doesnt work "Click" operation, thats why we are using here "JavaScriptExecutor"
	// JavaScriptExecutor-method also work same as "click" method
		
		//JavascriptExecutor js=(JavascriptExecutor)ldriver;
	//	js.executeScript("arguments[0].click();",listItem);
		
	
	public void setManagerOfVendor(String value) {
		
		Select drop=new Select(ldriver.findElement(drpmgrofVendor));
		drop.selectByVisibleText(value);
	}
	
	
		
		public void setAdminContent(String AdmContent) {
			ldriver.findElement(AdminContent).sendKeys(AdmContent);
		}
		public void clickSave() {
			ldriver.findElement(ButtonSave).click();
		
		}
	}
	







 