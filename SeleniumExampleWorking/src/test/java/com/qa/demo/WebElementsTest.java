package com.qa.demo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementsTest {
	
	private WebDriver driver;
	
	@BeforeEach
	void setup() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		// Our Webdriver is being specified as a chrome driver
		driver = new ChromeDriver(); 
		
		// Create a new browser window with these measurements
		driver.manage().window().setSize(new Dimension(1366, 768)); 
	}
	
	@Test
	public void testUselessButton() {
		
		// Arrange
		driver.get("https://theuselessweb.com/");
		
		// Grab the button we want to click
		WebElement button = driver.findElement(By.id("button"));
		System.out.println(button);
		
		// Act - Us clicking the button
		button.click();
		
		// Assert
		// Once the button is clicked the new url IS NOT the uselessweb.com
//		Assertions.assertNotEquals("https://theuselessweb.com/", driver.getCurrentUrl());
		
	}
	
	@Test
	void testWalesButton() {
			
		// Arrange
		String url = "https://www.bbc.co.uk/news";
		driver.get(url);
		
		WebElement walesButton = driver.findElement(By.xpath("/html/body/div[7]/header/div[2]/div[2]/div[1]/nav/ul/li[5]"));
		String title = "Wales - BBC News";
		
		// Act
		
		walesButton.click();
		
		// Assert
		Assertions.assertEquals(title, driver.getTitle());
		
	}
	
	@Test
	void bingSearchTest() {
		// Arrange
		driver.get("https://www.bing.com/");
		WebElement searchBar = driver.findElement(By.id("sb_form_q"));
		
		// Act - Simulate entering text into the search bar
		searchBar.sendKeys("egg");
		searchBar.sendKeys(Keys.ENTER);
		
		// Assert
	}
	
	@Test
	void printBBCHeader() {
		
		driver.get("https://www.bbc.co.uk/");
		WebElement header = driver.findElement(By.xpath("//*[@id=\"header-content\"]/div[3]/div/div/div/div/div"));
		System.out.println(header.getText());
		
	}
	
	@AfterEach
	void teardown() {
		driver.close();
	}

}
