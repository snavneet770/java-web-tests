package com.crm.qa.pages;

import com.crm.qa.utilities.LoggerClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import org.testng.Assert;

import java.util.logging.Level;
import java.util.logging.Logger;

public class HomePage extends TestBase {

	private static Logger LOGGER = Logger.getLogger(HomePage.class.getName());

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	// locators
	@FindBy(xpath = "//a/span[text()='Flights']")
	WebElement flights_tab_icon;

	@FindBy(xpath = "//a/span[text()='Roundtrip']")
	WebElement roundtrip_tab_text;

	//@FindBy(xpath = "//span[@class='uitk-field-label' and text()='Leaving from']")
	@FindBy(xpath = "//button[@aria-label='Leaving from']")
	WebElement leavingfrom_btn;

	@FindBy(xpath = "//input[@id='location-field-leg1-origin']")
	WebElement input_origin_name;

	@FindBy(xpath = "//li[@class= 'uitk-typeahead-result-item has-subtext'][1]")
	WebElement choose_origin_name;

	@FindBy(xpath = "//button[@aria-label='Going to']")
	WebElement goingto_btn;

	@FindBy(xpath = "//input[@id='location-field-leg1-destination']")
	WebElement input_destination_name;

	@FindBy(xpath = "(//ul[@data-stid='location-field-leg1-destination-results']/li/button/div[contains(.,'New York')])[1]")
	WebElement choose_destination_name;

	@FindBy(xpath = "//button[@id='d1-btn']")
	WebElement departing_calander;

	@FindBy(xpath = "//tbody/tr[1]/td/button[@data-day='1' and @aria-label='Jul 1, 2021']")
	WebElement select_dept_date;

	@FindBy(xpath = "//button[@id='d2-btn']")
	WebElement returning_calander;

	@FindBy(xpath = "//tbody/tr[3]/td/button[@data-day='12' and @aria-label='Jul 12, 2021']")
	WebElement select_return_date;

	@FindBy(xpath = "//button/span[text()='Done']")
	WebElement calendar_done_btn;

	@FindBy(xpath = "//button[@data-testid=\"submit-button\"]")
	WebElement search_btn;




	public void click_flights_tab(){
		try{
			if(flights_tab_icon.isDisplayed()){
				flights_tab_icon.click();
				LOGGER.log(Level.INFO, "Flights tab is displayed and clicked.");
				Assert.assertTrue(true);
			}
		}
		catch (Exception e){
			e.printStackTrace();
			LOGGER.log(Level.SEVERE, "Flights tab is not displayed");
			Assert.assertFalse(true);
		}
	}

	public void click_roundtrip_module(){
		try{
			if(roundtrip_tab_text.isDisplayed()){
				roundtrip_tab_text.click();
				LOGGER.log(Level.INFO, "Round Trip tab is displayed and clicked.");
				Assert.assertTrue(true);
			}
		}
		catch (Exception e){
			e.printStackTrace();
			LOGGER.log(Level.SEVERE, "Round Trip tab is not displayed!");
			Assert.assertFalse(true);
		}
	}

	public void enterLeavingFrom_name(String leavingfrom) throws InterruptedException {
		Thread.sleep(1000);
		try{
			if (leavingfrom_btn.isDisplayed()){
				leavingfrom_btn.click();
				LOGGER.log(Level.INFO, "leaving form input box is displayed and clicked.");
				input_origin_name.sendKeys(leavingfrom);
				choose_origin_name.click();
				LOGGER.log(Level.INFO, "Entered Leaving From Name as: " + leavingfrom);
				Assert.assertTrue(true);
			}
		}
		catch (Exception e){
			e.printStackTrace();
			LOGGER.log(Level.SEVERE, "Leaving from input field is not displayed!");
			Assert.assertFalse(true);
		}
	}

	public void enter_GoingTo_name(String goingto){
		try{
			if (goingto_btn.isDisplayed()){
				goingto_btn.click();
				LOGGER.log(Level.INFO, "Going to input box is displayed and clicked.");
				input_destination_name.sendKeys(goingto);
				choose_destination_name.click();
				LOGGER.log(Level.INFO, "Entered Going To Name as: " + goingto);
				Assert.assertTrue(true);
			}
		}
		catch (Exception e){
			e.printStackTrace();
			LOGGER.log(Level.SEVERE, "Going To input field is not displayed!");
			Assert.assertFalse(true);
		}
	}

	public void select_departure_date(){
		try{
			if (departing_calander.isDisplayed()){
				Thread.sleep(1000);
				departing_calander.click();
				Thread.sleep(1000);
				select_dept_date.click();
				LOGGER.log(Level.INFO, "Selected departure date.");
				Assert.assertTrue(true);
			}
		}
		catch (Exception e){
			e.printStackTrace();
			LOGGER.log(Level.SEVERE, "Departure Date calendar is not displayed!");
			Assert.assertFalse(true);
		}
	}

	public void select_return_date(){
		driver.findElement(By.xpath("//body")).click();
		try{
			if (returning_calander.isDisplayed()){
				Thread.sleep(1000);
				returning_calander.click();
				Thread.sleep(2000);
				select_return_date.click();
				Thread.sleep(2000);
				LOGGER.log(Level.INFO, "Selected return date.");
				Assert.assertTrue(true);
			}
		}
		catch (Exception e){
			e.printStackTrace();
			LOGGER.log(Level.SEVERE, "Return Date calendar is not displayed!");
			Assert.assertFalse(true);
		}
	}

	public void click_datepicker_done_btn(){
		try{
			if (calendar_done_btn.isDisplayed()){
				calendar_done_btn.click();
				LOGGER.log(Level.INFO, "Date Picker Done button displayed and clicked.");
				Assert.assertTrue(true);
			}
		}
		catch (Exception e){
			e.printStackTrace();
			LOGGER.log(Level.SEVERE, "Date Picker Done button is not displayed!");
			Assert.assertFalse(true);
		}
	}

	public void click_search_btn(){
		try{
			if (search_btn.isDisplayed()){
				search_btn.click();
				LOGGER.log(Level.INFO, "Clicked on Search Button.");
				Assert.assertTrue(true);
			}
		}
		catch (Exception e){
			e.printStackTrace();
			LOGGER.log(Level.SEVERE, "Search button is not displayed!");
			Assert.assertFalse(false);
		}
	}

}
