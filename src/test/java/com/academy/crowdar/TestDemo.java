package com.academy.crowdar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import com.academy.crowdar.business.MicrosoftForgotPasswordBusiness;
import com.academy.crowdar.business.MicrosoftLogInBusiness;
import com.academy.crowdar.business.MicrosoftPasswordBusiness;
import com.academy.crowdar.business.MicrosoftSearchBusiness;

public class TestDemo {
	
	private ChromeDriver driver;
	private MicrosoftSearchBusiness microsoftSearchBusiness;
	private MicrosoftLogInBusiness microsoftLogInBusiness;
	private MicrosoftPasswordBusiness microsoftPasswordBusiness;
	private MicrosoftForgotPasswordBusiness microsoftForgotPasswordBusiness;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "/home/mauricio/Descargas/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.microsoft.com/es-ar");	
		microsoftSearchBusiness = new MicrosoftSearchBusiness(driver);
		microsoftLogInBusiness = new MicrosoftLogInBusiness(driver);
		microsoftPasswordBusiness = new MicrosoftPasswordBusiness(driver);
		microsoftForgotPasswordBusiness = new MicrosoftForgotPasswordBusiness(driver);
	}
	
	@Test
	public void whenAUserSearchs() {
		String searchText = "netflix";
		microsoftSearchBusiness.perform(searchText);
	}
	
	@Test
	public void whenAUserLogsIn() {
		String email = "mauriciooubina@hotmail.com";
		microsoftLogInBusiness.perform(email);
	}
	
	@Test
	public void whenAUserLogsInAndHasToWriteHisPassword() {
		String email = "mauriciooubina@hotmail.com";
		String password = "callefalsa123";
		microsoftLogInBusiness.perform(email);
		microsoftPasswordBusiness.perform(password);
	}
	
	@Test
	public void whenAUserForgotsHisPassword() {
		String email = "mauriciooubina@hotmail.com";
		String password = "callefalsa123";
		String anotherEmail = "miotromail@hotmail.com";
		microsoftLogInBusiness.perform(email);
		microsoftPasswordBusiness.perform(password);
		microsoftForgotPasswordBusiness.perform(anotherEmail);
	}

	@After
	public void finishTest() {
		driver.close();
	}

}
