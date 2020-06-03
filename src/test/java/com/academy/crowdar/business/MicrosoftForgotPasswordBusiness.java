package com.academy.crowdar.business;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.academy.crowdar.business.pages.MicrosoftHomePage;
import com.academy.crowdar.business.pages.MicrosoftResultPage;
import com.acadeny.crowdar.business.interfaces.BusinessInterface;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MicrosoftForgotPasswordBusiness implements BusinessInterface{
	private static final String FORGOT_PASSWORD_BTN = "idA_PWD_ForgotPassword";
	private static final String SELECT_EMAIL_BTN = "proofOption0";
	private MicrosoftHomePage homePage;
	private MicrosoftResultPage resultPage;	
	
	public MicrosoftForgotPasswordBusiness(RemoteWebDriver driver) {
		super();
		this.resultPage = new MicrosoftResultPage(driver);
		this.homePage = new MicrosoftHomePage(driver);
	}

	public void perform(String text) {
		homePage.clickButton(FORGOT_PASSWORD_BTN);
		homePage.clickButton(SELECT_EMAIL_BTN);
		
		Assert.assertEquals("Necesitamos comprobar tu identidad", resultPage.getTitle());
	}

}
