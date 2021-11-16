package com.qa.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BBCSearchPage {
	
	// URL of the page we're creating 
	public String URL = "https://www.bbc.co.uk/search";
	
	@FindBy(id = "search-input") // Looks for element with this id / xpath / etc
	private WebElement searchBar; // Assigning that element as a WebElement called searchBar
	
	@FindBy(xpath = "//*[@id=\"main-content\"]/div[1]/div[3]/div/div/ul/li[1]/div/div/div[1]/div[1]/a/span/p/span")
	private WebElement article;
	
	// Methods of what we want to test
	
	// Method to enter text into search bar and click enter
	public void search(String searchTerm) {
		searchBar.sendKeys(searchTerm);
		searchBar.sendKeys(Keys.ENTER);
	}
	
	public String checkArticle() {
		return article.getText();
	}
	
	

}
