package com.crm.qa.testcases;

import com.crm.qa.pages.SearchResultPage;
import org.testng.Assert;
import org.testng.annotations.*;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;

public class TestCase_01 extends TestBase {

	HomePage homepage;
	SearchResultPage searchResultPage;

	public TestCase_01() {
		super();
	}

	@BeforeSuite(alwaysRun = true)
	public void setUp() {
		initializaton();
		homepage = new HomePage();
		searchResultPage = new SearchResultPage();
	}

	@Test
	public void test_case_01() throws InterruptedException {
		homepage.click_flights_tab();
		homepage.click_roundtrip_module();
		homepage.enterLeavingFrom_name(properties.getProperty("LeavingFrom"));
		homepage.enter_GoingTo_name(properties.getProperty("GoingTo"));
		homepage.select_departure_date();
		homepage.select_return_date();
		homepage.click_datepicker_done_btn();
		homepage.click_search_btn();
		searchResultPage.validate_search_context(properties.getProperty("LeavingFrom"), properties.getProperty("GoingTo"), properties.getProperty("DepartureDate"), properties.getProperty("ReturnDate"));
		searchResultPage.click_nonstop_chkbox();
		searchResultPage.select_price_range();
		searchResultPage.select_departingflight();
		searchResultPage.click_nonstop_chkbox();
		searchResultPage.select_price_range();
		searchResultPage.select_returnflight();
		searchResultPage.handle_popup();
		searchResultPage.validate_trip();

	}

	@AfterSuite(alwaysRun = true)
	public void tearDown() {
		tearDownMain();
	}

}
