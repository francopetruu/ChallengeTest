package com.project.pom;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class fravegaTest {
	
	private WebDriver driver;
	SearchPage searchPage;

	@Before
	public void setUp() throws Exception {
		
		searchPage = new SearchPage(driver);
		driver = searchPage.chromeDriverconnection();
		searchPage.visit("https://www.fravega.com/");
	}

	@After
	public void tearDown() throws Exception {
		//driver.quit();
	}

	@Test
	public void test() throws InterruptedException {
		searchPage.searchHeladerasSamsung();
		Thread.sleep(2000);
		List<WebElement> listadeResultados = searchPage.guardarResultados();
		int resultsExpected = listadeResultados.size();
		WebElement finalResults = searchPage.resultadosReales();
		WebElement migajasDepan = searchPage.breadcrumbAssert();
		
		for (WebElement e: listadeResultados ) {
			assertTrue(e.getText().contains("Samsung"));
			System.out.println("Matched");
			
		}
		
		assertEquals(resultsExpected, Integer.parseInt(finalResults.getText()));
		
		assertTrue(migajasDepan.getText().contains("Heladeras con freezer"));
		

    }
	
}
