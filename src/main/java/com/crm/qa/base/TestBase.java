package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.log4testng.Logger;

import com.crm.qa.utilities.LoggerClass;
import com.crm.qa.utilities.GenericFunctions;
import com.crm.qa.utilities.TestUtils;
import com.crm.qa.utilities.WebDriverListener;

public class TestBase {

	protected static WebDriver driver;
	protected static Properties properties;
	protected static GenericFunctions sele_Actions;
	protected static WebDriverListener eventListener;
	protected static EventFiringWebDriver e_driver;
	protected static ChromeOptions chromeOptions;
	protected static Logger log;

	public TestBase() {

		try {
			properties = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com/crm/qa/config/config.properties");
			properties.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("file not found");
		} catch (IOException e) {
			System.out.println("io exception");

		}

	}

	protected static void initializaton() {
		startLogger();
		String browserName = properties.getProperty("browser");
		driver = getDriver(browserName);
		log.info(browserName + " is configured");

		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebDriverListener();
		e_driver.register(eventListener);
		driver = e_driver;

		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

		driver.get(properties.getProperty("url"));

		sele_Actions = new GenericFunctions();

	}

	private static WebDriver getDriver(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", TestUtils.WORKSAPCE_PATH + "//drivers//chromedriver");
			chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--kiosk");
			return new ChromeDriver(chromeOptions);
		} else if (browserName.equalsIgnoreCase("FF")) {
			System.setProperty("webdriver.gecko.driver", TestUtils.WORKSAPCE_PATH + "//drivers//geckodriver");
			return new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("IE")) { // just a condition IE driver is not present in this project
			System.setProperty("webdriver.ie.driver", TestUtils.WORKSAPCE_PATH + "//drivers//IEDriverServer.exe");
			return new InternetExplorerDriver();
		}
		return null;
	}

	protected static void startLogger() {
		log = Logger.getLogger(LoggerClass.class);

	}

	public void tearDownMain() {
		//driver.manage().deleteAllCookies();
		driver.close();
	}


}
