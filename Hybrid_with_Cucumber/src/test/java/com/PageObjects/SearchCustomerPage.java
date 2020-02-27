package com.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utilities.WaiteHelper;

public class SearchCustomerPage {
	
	WaiteHelper waitHelper;

	public WebDriver ldriver;
	public SearchCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
		
		waitHelper=new WaiteHelper(ldriver);
	}
	
	@FindBy(id="SearchEmail")
	WebElement Email;
	
	@FindBy(id="SearchFirstName")
	WebElement Fname;
	
	@FindBy(id="SearchLastName")
	WebElement Lname;
	
	@FindBy(xpath="//button[@id='search-customers']")
	WebElement BtnSearch;
	
	/// This commented things are not required for every time 
	// Here we are using only above three things for Customer is valid or not(the ABOVE three things are much enough)
	
	/*@FindBy(id="SearchMonthOfBirth")
	WebElement MnBirth;
	
	@FindBy(id="SearchDayOfBirth")
	WebElement DyBirth;
	
	@FindBy(id="SearchCompany")
	WebElement Scompany;
	
	@FindBy(xpath="//div[@class='k-multiselect-wrap k-floatwrap']")
	WebElement CustomerRoles;
	
	@FindBy(xpath="//li[contains(text(),'Administrators']")
	WebElement Administrators;
	
	@FindBy(xpath="//li[contains(text(),'Registered']")
	WebElement Registered;
	
	@FindBy(xpath="//li[contains(text(),'Guests']")
	WebElement Guests;
	
	@FindBy(xpath="//li[contains(text(),'Vendors']")
	WebElement Vendores;
											*/
	@FindBy(xpath="//table[@role='grid']")
	WebElement TableSearchResults;
	
	@FindBy(xpath="//table[@id='customers-grid']")
	WebElement Table;
	
	@FindBy(xpath="//table[@id='customers-grid']//tbody/tr")
	List<WebElement> TableRows;
	
	@FindBy(xpath="//table[@id='customers-grid']//tbody/tr/td")
	List<WebElement> TableColumns;
													
	public void setEmail(String email) {
		waitHelper.WaitForElement(Email, 100);
		Email.clear();
		Email.sendKeys(email);
	}
	public void setFiratName(String FstName) {
		waitHelper.WaitForElement(Fname, 100);
		Fname.clear();
		Fname.sendKeys(FstName);
	}
	public void setLastName(String LstName) {
		waitHelper.WaitForElement(Lname, 100);
		Lname.clear();
		Lname.sendKeys(LstName);
	}
	public void clickSearchBttn() {
		
		BtnSearch.click();
		waitHelper.WaitForElement(Lname, 100);
	}
	public int getNuOfRows() {
		
	return(TableRows.size());
}
	public int getNuOfColumns() {
		
		return(TableColumns.size());

	}

	public boolean searchCustomerByEmail(String Email) {
		
		boolean flag=false;
		for (int i = 1; i <=getNuOfRows(); i++) {
			
			String emailId=Table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[2]")).getText();
		System.out.println(emailId);
		
		if(emailId.equals(Email)) {
			flag=true;  //Here input and output Emails are same or this eamils are available on the webpage/ table
							// then flag value is "true"-then condition is passed
		}  // input and output emails are not equal or not available on the table then my flag value is "false"
				// Then my flag value is "email is not found" 
	}
	return flag;

	}
	public boolean SearchCustomerByName(String Name) {
		boolean flag = false;
		for (int i = 1; i <=getNuOfRows(); i++)
		{
			String name=Table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[3]")).getText();
			String names[]=name.split(" ");  // This condition only for Fname and Lname 
			if(names[0].equals("NARASIMHASWAMY")&&names[1].equals("CHUNCHU"))
					{
				flag=true;
			}
		}
		
		return flag;
	}
	
}



