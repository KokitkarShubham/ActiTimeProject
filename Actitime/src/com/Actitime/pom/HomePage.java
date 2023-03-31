package com.Actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	@FindBy (xpath="//div[.='Tasks']")
	private WebElement tasklnk;
	
	@FindBy (xpath="//div[.='Reports']")
	private WebElement reportlink;
	
	@FindBy (id="logoutlink")
	private WebElement logoutlink;
	
	//Initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getTasklnk() {
		return tasklnk;
	}

	public WebElement getReportlink() {
		return reportlink;
	}

	public WebElement getLogoutlink() {
		return logoutlink;
	}
	
	

}
