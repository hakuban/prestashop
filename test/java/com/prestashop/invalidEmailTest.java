package com.prestashop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class invalidEmailTest {

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
	driver.findElement(By.cssSelector("#email")).sendKeys("hangke");
	driver.findElement(By.cssSelector("#passwd")).sendKeys("12345");
	driver.findElement(By.cssSelector("#SubmitLogin")).click();
	Assert.assertTrue(driver.getPageSource().contains("Invalid email address"));
	
}

@AfterMethod
public void tearDown() {
	driver.close();
}

}


