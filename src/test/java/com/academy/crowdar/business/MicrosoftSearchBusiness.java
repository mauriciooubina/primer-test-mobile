package com.academy.crowdar.business;

import org.openqa.selenium.WebDriver;
import com.academy.crowdar.business.pages.MicrosoftHomePage;
import com.academy.crowdar.business.pages.MicrosoftResultPage;
import com.acadeny.crowdar.business.interfaces.BusinessInterface;
import org.junit.Assert;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MicrosoftSearchBusiness implements BusinessInterface{
	private static final String SEARCH_BTN = "search";
	private static final String SEARCH = "cli_shellHeaderSearchInput";
	private MicrosoftHomePage homePage;
	private MicrosoftResultPage resultPage;
	
	public MicrosoftSearchBusiness(RemoteWebDriver driver) {
		super();
		this.homePage = new MicrosoftHomePage(driver);
		this.resultPage = new MicrosoftResultPage(driver);
	}

	public void perform(String text) {
		homePage.clickButton(SEARCH_BTN);
		homePage.completeText(text,SEARCH);
		homePage.clickButton(SEARCH_BTN);

		String result = "https://www.microsoft.com/es-ar/search?q=" + text;
		String url = resultPage.getUrl().toString();
		Assert.assertEquals(result,url);
	}
}
