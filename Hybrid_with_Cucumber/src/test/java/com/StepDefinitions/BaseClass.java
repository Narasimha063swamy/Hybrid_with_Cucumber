package com.StepDefinitions;

import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.PageObjects.AddCustomerPage;
import com.PageObjects.LoginPage;
import com.PageObjects.SearchCustomerPage;

public class BaseClass {
	

	public WebDriver driver;
	public LoginPage lp;
	public AddCustomerPage AddCust;
	public SearchCustomerPage searchCust;
	public static Logger logger;
	public Properties configprop;
	
	
// Created for generating random string for unique Email
	public static String randomstring() {
		String generatedstring1=RandomStringUtils.randomAlphabetic(5);
		return (generatedstring1);
	}
	

}
