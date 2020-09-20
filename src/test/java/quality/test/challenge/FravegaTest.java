package quality.test.challenge;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class FravegaTest {
	
	private WebDriver driver;
	
	@Before
	
	public void SetUp() {
		
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/ChromeDriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.fravega.com/");
	}
	
	@Test
	
	public void TestFravegaPage() {
	
		WebElement searchbox = driver.findElement(By.cssSelector("#__next > div.globalstyles__GlobalWrapper-sc-1rfm2p-0.iHsbWn > header > div > header > div.SearchBar__StyledSearchBar-xgngsx-0.jhnLaL > div > div.SearchBar__SearchWrapper-xgngsx-8.tzNnF > form > input"));
		searchbox.clear();
		searchbox.sendKeys("Heladera");
		searchbox.submit();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement FiltroHeladeras = driver.findElement(By.cssSelector("#__next > div.withMainLayout__LayoutWrapper-sc-1lj5zpr-1.hhFziS > div:nth-child(2) > div > div > div.generalstyles__Column-sc-1j7wv79-5.sgWgV > ul > li:nth-child(4) > ul > li:nth-child(1) > ul > li:nth-child(2) > a > h4"));
		FiltroHeladeras.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//WebElement VerTodas = driver.findElement(By.cssSelector("#__next > div.withMainLayout__LayoutWrapper-sc-1lj5zpr-1.hhFziS > div:nth-child(2) > div > div > div.generalstyles__Column-sc-1j7wv79-5.sgWgV > ul > li:nth-child(4) > ul > li:nth-child(2) > ul > a"));
		//VerTodas.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement Samsung = driver.findElement(By.cssSelector("#__next > div.withMainLayout__LayoutWrapper-sc-1lj5zpr-1.hhFziS > div:nth-child(2) > div > div > div.generalstyles__Column-sc-1j7wv79-5.sgWgV > ul > li:nth-child(4) > ul > li:nth-child(2) > ul > li:nth-child(7) > a > label"));
		Samsung.click();
		//WebElement AplicarButton = driver.findElement(By.id("apply"));
		//AplicarButton.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		

		
		List<WebElement> GrillaResultados = driver.findElements(By.cssSelector("div[class=\"ProductCard__Card-sc-1w5guu7-2 hlRWOw\"] > a > article > div > h4"));
		
		int resultsExpected = GrillaResultados.size();
		System.out.print(resultsExpected);
		String samsung = "Samsung";
		WebElement actualResults = driver.findElement(By.cssSelector("#__next > div.withMainLayout__LayoutWrapper-sc-1lj5zpr-1.hhFziS > div:nth-child(2) > div > div > div.generalstyles__Column-sc-1j7wv79-5.sgWgV > ul > li.listingDesktopstyled__TotalResult-wzwlr8-2.jPwsRI > span"));
		WebElement breadcrumb = driver.findElement(By.name("breadcrumb"));
	
		for(WebElement e: GrillaResultados) {
			
			
			assertTrue(e.getText().contains(samsung));
			System.out.println("Matched");
		}
		
		assertEquals(resultsExpected, Integer.parseInt(actualResults.getText()));
		
		assertTrue(breadcrumb.getText().contains("Heladeras con Freezer"));
		
	}
	
	@After
	public void TearDown() {
		
		driver.quit();
	}

}
