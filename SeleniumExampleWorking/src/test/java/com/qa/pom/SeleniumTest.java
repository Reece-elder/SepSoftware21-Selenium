package com.qa.pom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class SeleniumTest {
	
	private WebDriver driver;
	
	@BeforeEach
	void setup() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver(); 
		driver.manage().window().setSize(new Dimension(1366, 768)); 
	}
	
	// When entering a String into the BBC Search page 
	// it should show articles with that String contained
	
	@Test
	void searchPageString() {
		
		// Arrange
		String testString = "Badger"; // What we're putting in the searchbar
		
		// Create a SearchPage to test
		BBCSearchPage searchPage = PageFactory.initElements(driver, BBCSearchPage.class);
		
		// Act
		// Accessing bbc search 
		driver.get(searchPage.URL);
		
		// Run the methods to search for a string on the page
		searchPage.search(testString);
		
		// Assert 
		Assertions.assertTrue(searchPage.checkArticle().contains(testString));
		
	}

}
