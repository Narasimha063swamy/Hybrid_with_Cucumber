package com.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaiteHelper {
	
	public WebDriver driver;
	public WaiteHelper(WebDriver driver) {
		this.driver=driver;
	}
public void WaitForElement(WebElement element,long timeOutInSeconds) {
	WebDriverWait Wait=new WebDriverWait(driver,timeOutInSeconds);
	Wait.until(ExpectedConditions.visibilityOf(element));
	}
}

