package com.academy.crowdar.business;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import com.academy.crowdar.business.pages.MicrosoftHomePage;
import com.academy.crowdar.business.pages.MicrosoftResultPage;
import com.acadeny.crowdar.business.interfaces.BusinessInterface;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MicrosoftPasswordBusiness implements BusinessInterface{
	private static final String CONTINUE_BTN = "idSIButton9";
	private static final String PASSWORD_PLACE = "i0118";
	private MicrosoftHomePage homePage;
	private MicrosoftResultPage resultPage;
	
	public MicrosoftPasswordBusiness(RemoteWebDriver driver) {
		super();
		this.resultPage = new MicrosoftResultPage(driver);
		this.homePage = new MicrosoftHomePage(driver);
	}

	public void perform(String text) {
		homePage.clickButton(CONTINUE_BTN);
		homePage.completeText(text, PASSWORD_PLACE);
		
		Assert.assertEquals("Iniciar sesión en tu cuenta Microsoft", resultPage.getTitle());
	}

}
