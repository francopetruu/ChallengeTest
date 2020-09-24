package com.project.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	
	private WebDriver driver;
	
	public Base(WebDriver driver) {
		
		this.driver = driver;
		
		}
	
	public WebDriver chromeDriverconnection() {
		
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/ChromeDriver/chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
	}
	
	public WebElement findElement(By locator) {
		return driver.findElement(locator);
		
	}
	
	public List<WebElement> findElements(By locator) {
		return driver.findElements(locator);
		
	}
	
	public String getText(WebElement element) {
		return element.getText();
		
	}
	
	public void type(String inputText, By locator) {
		driver.findElement(locator).sendKeys(inputText);
		
	}
	
	public void click(By locator) {
		driver.findElement(locator).click();
		
	}
	
	public void visit(String url) {
		driver.get(url);
		
	}
	
	public void quit() {
		driver.quit();
	}
	
	public void searchboxClear(By locator) {
		driver.findElement(locator).clear();
	}
	
	public void submitText(By locator) {
		driver.findElement(locator).submit();
		
	}
	
	public void contains() {
		contains();
	}

}
