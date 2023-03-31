package com.Actitime.genericLibrary;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	WebDriver driver;
	FileLibrary f=new FileLibrary();
	@BeforeSuite
	public void databaseConnection() {
		Reporter.log("database connected successfully",true);
	}
	
	@AfterSuite
	public void databaseDisconnection() {
		Reporter.log("database disconnected",true);
	}
	
	@BeforeClass
	public void launchBrowser() throws IOException {
		ChromeOptions option= new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriver driver= new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    String url1 = f.readDataFromPropertyFile("url");
		driver.get(url1);
		Reporter.log("browser launch",true);
	}
	@AfterClass
	public void closeBrowser() {
		driver.close();
		Reporter.log("browser closed",true);
	}
	
	@BeforeMethod
	public void login() throws IOException {
		String un = f.readDataFromPropertyFile("username");
		driver.findElement(By.id("username")).sendKeys(un);
		String pw=f.readDataFromPropertyFile("password");
		driver.findElement(By.name("pwd")).sendKeys(pw);
		driver.findElement(By.xpath("//div[.='Login ']")).click();
		Reporter.log("login sucessfully",true);
	}
	
	@AfterMethod
	public void logout() {
		driver.findElement(By.id("logoutLink")).click();
		Reporter.log("logout sucessfully",true);
	}

}
