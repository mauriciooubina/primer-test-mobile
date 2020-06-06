package com.academy.crowdar.business.pages;

import java.util.concurrent.TimeUnit;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MicrosoftHomePage {
	private WebDriver driver;
	
	public MicrosoftHomePage(RemoteWebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public void clickButton(String idBtn) {
		WebElement btnSearch = driver.findElement(MobileBy.id(idBtn));
		btnSearch.click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void completeText(String text, String place) {
		WebElement search = driver.findElement(MobileBy.id(place));
		search.clear();	
		search.sendKeys(text);
		search.sendKeys(Keys.TAB);
	}
	
	public String getTitle() {
		return driver.getTitle();
	}	

	public void returnWebPage() {
		driver.navigate().back();
	}

	public boolean searchError(String error) {
		return driver.findElement(By.id(error)) != null;
		
	}
}
