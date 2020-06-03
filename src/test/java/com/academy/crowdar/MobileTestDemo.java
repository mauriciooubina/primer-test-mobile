package com.academy.crowdar;

import com.academy.crowdar.business.MicrosoftForgotPasswordBusiness;
import com.academy.crowdar.business.MicrosoftLogInBusiness;
import com.academy.crowdar.business.MicrosoftPasswordBusiness;
import com.academy.crowdar.business.MicrosoftSearchBusiness;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class MobileTestDemo {

	private MicrosoftSearchBusiness microsoftSearchBusiness;
	private MicrosoftLogInBusiness microsoftLogInBusiness;
	private MicrosoftPasswordBusiness microsoftPasswordBusiness;
	private MicrosoftForgotPasswordBusiness microsoftForgotPasswordBusiness;
	private AppiumDriver driver;
	private RemoteWebDriver webDriver;

	@Before
	public void setup() throws MalformedURLException {
		DesiredCapabilities capabilities = DesiredCapabilities.android();
		capabilities.setPlatform(Platform.ANDROID);
		capabilities.setCapability("deviceName", "Pixel3");
		//capabilities.setCapability("app", "/home/mauricio/eclipse-workspace/primer-test/sample_apk/lippia.apk");
		capabilities.setCapability("autoGrantPermissions", true);
		capabilities.setCapability("resetKeyboard", true);
		capabilities.setCapability("unicodeKeyboard", true);
		capabilities.setCapability("browserName","Chrome");
		capabilities.setCapability("chromedriverExecutable", "/home/mauricio/Descargas/chromedriver");
		capabilities.setCapability("newCommandTimeout", 10000);
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver(url, capabilities);
		//webDriver = new RemoteWebDriver(capabilities);
		driver.get("https://www.microsoft.com/es-ar/");
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
