package com.academy.crowdar.business.pages;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MicrosoftResultPage {
	private static final String SELECTOR_RESULT = "#rso > div:nth-child(%s) > div > div.r > a";
	private WebDriver driver;
	
	public MicrosoftResultPage(RemoteWebDriver driver) {
		super();
		this.driver = driver;
	}

	public void clickOnTheResult(String text) {
		WebElement result = driver.findElement(MobileBy.cssSelector(String.format(SELECTOR_RESULT, text)));
		result.click();
	}
	
	

	public Object getTitle() {
		return driver.getTitle();
	}

	public Object getUrl() {
		return driver.getCurrentUrl();
	}
	
}
