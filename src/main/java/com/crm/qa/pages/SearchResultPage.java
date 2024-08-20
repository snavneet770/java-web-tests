package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import com.crm.qa.utilities.GenericFunctions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SearchResultPage extends TestBase {

    private static Logger LOGGER = Logger.getLogger(SearchResultPage.class.getName());
    GenericFunctions genericFunctions = new GenericFunctions();

    public SearchResultPage() {
        PageFactory.initElements(driver, this);
    }

    // locators
    @FindBy(xpath = "//input[@id='departure-airport-1']")
    WebElement departure_location;

    @FindBy(xpath = "//input[@id='arrival-airport-1']")
    WebElement arrival_location;

    @FindBy(xpath = "//input[@id='departure-date-1']")
    WebElement departure_date;

    @FindBy(xpath = "//input[@id='return-date-1']")
    WebElement return_date;

    @FindBy(xpath = "(//label[@class='uitk-col all-col-fill checkbox-label-filter'])[2]")
    WebElement nonstop_chkbox;

    @FindBy(xpath = "//select[@data-test-id='sortDropdown']")
    WebElement sort_filter;

    @FindBy(xpath = "//select[@data-test-id='sortDropdown']/option[text()= 'Price (Highest)']")
    WebElement select_highestprice;

    @FindBy(xpath = "(//button[@data-test-id='select-button'])[1]")
    WebElement select_flight;

    @FindBy(xpath = "(//button[@data-test-id='select-button']/span)[1]")
    WebElement select_flight2;

    @FindBy(xpath = "//span[text()='Select your departure to New York']")
    WebElement departing_message;

    @FindBy(xpath = "//span[text()='Select your return to San Francisco']")
    WebElement returning_message;

    @FindBy(xpath = "//div[@class='modal-body']/div[@class='click-handler-range']/a/span[contains(.,'Add Hotel Now')]")
    WebElement addhotel_popup;

    @FindBy(xpath = "//div[@class='modal-body']/div[@class='click-handler-range']/span/a[contains(.,'No thanks')]")
    WebElement nothanks_popup;

    @FindBy(xpath = "(//span[@data-test-id='airline-name'])[1]")
    WebElement departure_airline_name;

    @FindBy(xpath = "(//span[@data-test-id='listing-price-dollars'])[1]")
    WebElement departure_flight_price;

    @FindBy(xpath = "(//div[@data-test-id='flight-info']/span[2])[1]")
    WebElement departure_flight_from_name;

    @FindBy(xpath = "(//div[@data-test-id='flight-info']/span[4])[1]")
    WebElement departure_flight_to_name;

    @FindBy(xpath = "(//span[@data-test-id='airline-name'])[2]")
    WebElement return_airline_name;

    @FindBy(xpath = "(//span[@data-test-id='listing-price-dollars'])[1]")
    WebElement return_flight_price;

    @FindBy(xpath = "(//div[@data-test-id='flight-info']/span[2])[1]")
    WebElement return_flight_from_name;

    @FindBy(xpath = "(//div[@data-test-id='flight-info']/span[4])[1]")
    WebElement return_flight_to_name;

    String departing_airlines_name;
    String departing_flight_price;
    String departing_from;
    String departing_to;

    String returning_airlines_name;
    String returning_flight_price;
    String returning_from;
    String returning_to;

    // trip page
    @FindBy(xpath = "(//div[@class='airlineName'])[1]")
    WebElement first_flightname;

    @FindBy(xpath = "(//div[@class='departure']/div)[1]")
    WebElement first_flight_from;

    @FindBy(xpath = "(//div[@class='arrival']/div)[1]")
    WebElement first_flight_to;

    @FindBy(xpath = "(//div[@class='airlineName'])[2]")
    WebElement second_flightname;

    @FindBy(xpath = "(//div[@class='departure']/div)[2]")
    WebElement second_flight_from;

    @FindBy(xpath = "(//div[@class='arrival']/div)[2]")
    WebElement second_flight_to;





    public void validate_search_context(String leavingfrom, String goingto, String deptdate, String returndate) throws InterruptedException {
        Thread.sleep(10000);
        try{
            if(departure_location.isDisplayed()){
                String get_deptlocation = departure_location.getAttribute("value");
                if (get_deptlocation.contains(leavingfrom)){
                    LOGGER.log(Level.INFO, "Leaving From location is same as: " + get_deptlocation);
                    Assert.assertTrue(true);
                }
                else {
                    LOGGER.log(Level.INFO, "Leaving From location did not match!");
                    Assert.assertFalse(true);
                }
            }
            else {
                LOGGER.log(Level.SEVERE, "Departure Location field is not displayed!");
                Assert.assertFalse(true);
            }
            if (arrival_location.isDisplayed()){
                String get_arrivallocation = arrival_location.getAttribute("value");
                if(get_arrivallocation.contains(goingto)){
                    LOGGER.log(Level.INFO, "Going To location is same as: " + get_arrivallocation);
                    Assert.assertTrue(true);
                }
                else {
                    LOGGER.log(Level.INFO, "Going To location did not match!");
                    Assert.assertFalse(true);
                }
            }
            else {
                LOGGER.log(Level.SEVERE, "Arrival Location field did not displayed!");
                Assert.assertFalse(true);
            }
            if (departure_date.isDisplayed()){
                String get_deptdate = departure_date.getAttribute("value");
                if (get_deptdate.contains(deptdate)){
                    LOGGER.log(Level.INFO, "Departure Date is same as: " + get_deptdate);
                    Assert.assertTrue(true);
                }
                else {
                    LOGGER.log(Level.INFO, "Departure Date did not match!");
                    Assert.assertFalse(true);
                }
            }
            else {
                LOGGER.log(Level.SEVERE, "Departure Date field did not displayed!");
                Assert.assertFalse(true);
            }
            if (return_date.isDisplayed()){
                String get_returndate = return_date.getAttribute("value");
                if (get_returndate.contains(returndate)){
                    LOGGER.log(Level.INFO, "Return Date is same as: " + get_returndate);
                    Assert.assertTrue(true);
                }
                else{
                    LOGGER.log(Level.INFO, "Return Date did not match!");
                    Assert.assertFalse(true);
                }
            }
            else {
                LOGGER.log(Level.SEVERE, "Return Date field did not displayed!");
                Assert.assertFalse(true);
            }
        }
        catch (Exception e){
            e.printStackTrace();
            LOGGER.log(Level.SEVERE, "Something went wrong while validating Search Context on Results Page!");
            Assert.assertFalse(true);
        }
    }

    public void click_nonstop_chkbox(){
        try{
            Thread.sleep(7000);
            if (nonstop_chkbox.isDisplayed()){
                nonstop_chkbox.click();
                LOGGER.log(Level.INFO, "Clicked on Non Stop Check box.");
                Assert.assertTrue(true);
            }
        }
        catch (Exception e){
            e.printStackTrace();
            LOGGER.log(Level.SEVERE, "Something went wrong while clicking on Non Stop Check box!");
            Assert.assertFalse(true);
        }
    }

    public void select_price_range(){
        try{
            Thread.sleep(2000);
            if (sort_filter.isDisplayed()){
                sort_filter.click();
                LOGGER.log(Level.INFO, "Clicked on Price Range filter.");
                Assert.assertTrue(true);
                select_highestprice.click();
                LOGGER.log(Level.INFO, "Selected Highest Price.");
                Assert.assertTrue(true);
            }
        }
        catch (Exception e){
            e.printStackTrace();
            LOGGER.log(Level.SEVERE, "Something went wrong while selecting Price Range filter!");
            Assert.assertFalse(true);
        }
    }

    public void select_departingflight(){
        try{
            Thread.sleep(5000);
            if(departing_message.isDisplayed()){
                departing_airlines_name = departure_airline_name.getText();
                departing_flight_price = departure_flight_price.getText();
                departing_from = departure_flight_from_name.getText();
                departing_to = departure_flight_to_name.getText();
                select_flight.click();
                LOGGER.log(Level.INFO, "Clicked on Departing Flight Select Button.");
                Assert.assertTrue(true);
            }
        }
        catch (Exception e){
            e.printStackTrace();
            LOGGER.log(Level.SEVERE, "Something went wrong while clicking on Departing Flight Select Button!");
            Assert.assertFalse(true);
        }
    }

    public void select_returnflight(){
        try{
            if(returning_message.isDisplayed()){
                returning_airlines_name = return_airline_name.getText();
                returning_flight_price = return_flight_price.getText();
                returning_from = return_flight_from_name.getText();
                returning_to = return_flight_to_name.getText();
                Thread.sleep(2000);
                select_flight2.click();
                LOGGER.log(Level.INFO, "Clicked on Returning Flight Select Button.");
                Assert.assertTrue(true);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
            LOGGER.log(Level.SEVERE, "Something went wrong while clicking on Returning Flight Select Button!");
            Assert.assertFalse(true);
        }
    }

    public void handle_popup() throws InterruptedException {
        Thread.sleep(3000);
        if (addhotel_popup.isDisplayed()){
            nothanks_popup.click();
            LOGGER.log(Level.INFO, "Add Hotel Pop-Up displayed and clicked on No Thanks.");
        }
    }

    public void validate_trip(){
        try{
            Thread.sleep(5000);
            if (first_flightname.isDisplayed()){
                if (departing_airlines_name.contains(first_flightname.getText())){
                    LOGGER.log(Level.INFO, "Departure Flight name matched with Flight selection page as: " +first_flightname);
                    Assert.assertTrue(true);
                }
                else {
                    LOGGER.log(Level.SEVERE, "Departure Flight name did not match!");
                    Assert.assertFalse(true);
                }
            }
            else {
                LOGGER.log(Level.SEVERE, "Departing Flight name did not displayed!");
                Assert.assertFalse(true);
            }
            if (first_flight_from.isDisplayed()){
                if (departing_from.replace(" -","").contains(first_flight_from.getText())){
                    LOGGER.log(Level.INFO, "Departure Flight from is same.");
                    Assert.assertTrue(true);
                }
                else {
                    LOGGER.log(Level.SEVERE, "Departure Flight from did not match!");
                    Assert.assertFalse(true);
                }
            }
            else {
                LOGGER.log(Level.SEVERE, "Departing Flight From did not displayed!");
                Assert.assertFalse(true);
            }


        }
        catch (Exception e){
            e.printStackTrace();
            LOGGER.log(Level.SEVERE, "Something went wrong while validating Trip review page!");
            Assert.assertFalse(true);
        }
    }




}
