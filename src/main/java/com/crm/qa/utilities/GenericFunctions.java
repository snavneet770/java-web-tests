package com.crm.qa.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericFunctions extends TestBase {


	public void waitForElementToLoad(WebDriver driver, WebElement element, int seconds){
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

}
