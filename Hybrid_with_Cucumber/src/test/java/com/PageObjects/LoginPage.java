package com.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

			WebDriver ldriver;
		
		public LoginPage(WebDriver rdriver) {
			
			ldriver=rdriver;
			PageFactory.initElements(rdriver, this);
			
		}
		@FindBy(name="Email")
		WebElement Username;
		
		@FindBy(name="Password")
		WebElement Pwd;
		
		@FindBy(xpath="//input[@value='Log in']")
		WebElement Login;
		
		@FindBy(xpath="//a[text()='Logout']")
		
		WebElement Logout;
		
	public void setUsername(String UN) {
		Username.clear();
		Username.sendKeys(UN);
		
	}
		public void setPassword(String PS) {
			Pwd.clear();
			Pwd.sendKeys(PS);
		}
		public void Button() {
			Login.click();
		}
		public void logout() {
			Logout.click();
			
		}	

	}
	


	
	
	
	
	