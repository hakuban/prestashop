package com.prestashop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class blankPasswordTest {
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.get("http://automationpractice.com");
	}

	@Test
	public void wrongLogin() {
		driver.findElement(By.cssSelector(".login")).click();
		driver.findElement(By.cssSelector("#email")).sendKeys("hangke@gmai.com");
		driver.findElement(By.cssSelector("#passwd")).sendKeys("");
		driver.findElement(By.cssSelector("#SubmitLogin")).click();
		Assert.assertTrue(driver.getPageSource().contains("Password is required"));
		
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

	}
