package com.project.pom;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage extends Base {
	
	By searchboxLocator = By.cssSelector("#__next > div.globalstyles__GlobalWrapper-sc-1rfm2p-0.iHsbWn > header > div > header > div.SearchBar__StyledSearchBar-xgngsx-0.jhnLaL > div > div.SearchBar__SearchWrapper-xgngsx-8.tzNnF > form > input");
	By filtroHeladerasLocator = By.cssSelector("#__next > div.withMainLayout__LayoutWrapper-sc-1lj5zpr-1.hhFziS > div:nth-child(2) > div > div > div.generalstyles__Column-sc-1j7wv79-5.sgWgV > ul > li:nth-child(4) > ul > li:nth-child(1) > ul > li:nth-child(2) > a > h4");
	By SamsungLocator = By.cssSelector("#__next > div.withMainLayout__LayoutWrapper-sc-1lj5zpr-1.hhFziS > div:nth-child(2) > div > div > div.generalstyles__Column-sc-1j7wv79-5.sgWgV > ul > li:nth-child(4) > ul > li:nth-child(2) > ul > li:nth-child(7) > a > label");
	By actualResultsLocator = By.cssSelector("#__next > div.withMainLayout__LayoutWrapper-sc-1lj5zpr-1.hhFziS > div:nth-child(2) > div > div > div.generalstyles__Column-sc-1j7wv79-5.sgWgV > ul > li.listingDesktopstyled__TotalResult-wzwlr8-2.jPwsRI > span");
	By breadcrumbLocator = By.name("breadcrumb");
	By listaResultadosLocator = By.cssSelector("div[class=\"ProductCard__Card-sc-1w5guu7-2 hlRWOw\"] > a > article > div > h4");

	public SearchPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void searchHeladerasSamsung() throws InterruptedException {
		type("Heladera", searchboxLocator);
		submitText(searchboxLocator);
		Thread.sleep(2000);
		click(filtroHeladerasLocator);
		Thread.sleep(2000);
		click(SamsungLocator);
		//List<WebElement> GrillaResultados = findElements(listaResultadosLocator);
		//int resultsExpected = GrillaResultados.size();
		//WebElement actualResults = findElement(actualResultsLocator);
		//WebElement breadcrumb = findElement(breadcrumbLocator);
		
		//for (WebElement e: GrillaResultados) {
			//assertTrue(e.getText().contains("Samsung"));
			//System.out.println("Matched");
		//}
		
		//assertEquals(resultsExpected, Integer.parseInt(actualResults.getText()));
		
		//assertTrue(breadcrumb.getText().contains("Heladeras con freezer"));
	}
		

	public List<WebElement> guardarResultados() {
		List<WebElement> GrillaResultados = findElements(listaResultadosLocator);
		
		return GrillaResultados; 
		
	}
	
	public WebElement breadcrumbAssert() {
		WebElement breadcrumb = findElement(breadcrumbLocator);
		
		return breadcrumb;
		
	}
	
	public WebElement resultadosReales() {
		WebElement realResult = findElement(actualResultsLocator);
		return realResult;
	}
	
}


