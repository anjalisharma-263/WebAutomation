package com.purpleAdmin.qa.testcases;

import java.util.HashMap;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.purpleAdmin.qa.base.TestBase;

import businessLogic.WebBL;

public class WebNavigationDirectionsTestCases extends TestBase {
	public static final String DETAIL_PAGE_DATA_SHEET = System.getProperty("user.dir")
			+ "/src/main/java/com/purpleAdmin/qa/testdata/KioskData.xls";
	public static final String SHEET_NAME = "Web";
	ExtentTest extentTest = null;
	public static ExtentTest parent;
	HashMap<String, String> outputMap;

	public WebNavigationDirectionsTestCases() {
		super();
	}

	@BeforeTest
	public void createTest() {
		parent = extent.createTest("Direction Validation Test");
	}

	@BeforeMethod
	public void setUp() {
		// parent = extent.createTest("Direction Validation Test");
		outputMap = new HashMap<String, String>();
	}

	@Test(priority = 1, enabled = true, dataProvider = "getData")
	public void validateOnsiteDirections(HashMap<String, String> dataMap) throws InterruptedException {
		initialization(dataMap.get("BROWSER_NAME"));
		extentTest = parent.createNode("Validating Onsite Directions on " + dataMap.get("BROWSER_NAME") + " for "
				+ dataMap.get("CAMPUS_NAME"));
		WebBL wb = new WebBL();
		outputMap = wb.performOnisteDirections(driver, dataMap);
		wb.validateResults(extentTest, outputMap);
	}

	@Test(priority = 2, enabled = true, dataProvider = "getData")
	public void validateOnisteOffsiteDirections(HashMap<String, String> dataMap) throws InterruptedException {
		initialization(dataMap.get("BROWSER_NAME"));
		extentTest = parent.createNode("Validating Onsite to Offsite directions" + dataMap.get("BROWSER_NAME") + " for "
				+ dataMap.get("CAMPUS_NAME"));
		WebBL wb = new WebBL();
		outputMap = wb.performOnsiteOffsiteDirections(driver, dataMap);
		wb.validateResults(extentTest, outputMap);
	}

	@Test(priority = 3, enabled = true, dataProvider = "getData")
	public void validateOffsiteOnsiteDirections(HashMap<String, String> dataMap) throws InterruptedException {
		initialization(dataMap.get("BROWSER_NAME"));
		extentTest = parent.createNode("Validating offsite to onsite directions" + dataMap.get("BROWSER_NAME") + " for "
				+ dataMap.get("CAMPUS_NAME"));
		WebBL wb = new WebBL();
		outputMap = wb.performOffsiteOnsiteDirections(driver, dataMap);
		wb.validateResults(extentTest, outputMap);
	}
	
	@Test(priority = 4, enabled = true, dataProvider = "getData")
	public void validateGoogleResults(HashMap<String, String> dataMap) {
		initialization(dataMap.get("BROWSER_NAME"));
		extentTest = parent.createNode(
				"Validating Google Results" + dataMap.get("BROWSER_NAME") + " for " + dataMap.get("CAMPUS_NAME"));
		WebBL wb = new WebBL();
		outputMap = wb.performGoogleSearch(driver, dataMap);
		wb.validateResults(extentTest, outputMap);
	}
	
	@Test(priority = 5, enabled = true, dataProvider = "getData")
	public void validateReverseDirections(HashMap<String, String> dataMap) throws InterruptedException {
		initialization(dataMap.get("BROWSER_NAME"));
		extentTest = parent.createNode("Validating Reverse directions on "+ dataMap.get("BROWSER_NAME")+ " for " +dataMap.get("CAMPUS_NAME"));
		WebBL wb = new WebBL();
		outputMap = wb.performReverse(driver, dataMap);
		wb.validateResults(extentTest, outputMap);
	}

//	@Test(priority = 10, enabled = true, dataProvider = "getData")
//	public void validateAlertMsgOnSameDirections(HashMap<String, String> dataMap) throws InterruptedException {
//		initialization(dataMap.get("BROWSER_NAME"));
//		extentTest = parent.createNode("Validating Alert Msg On Same Directions on " + dataMap.get("BROWSER_NAME")
//				+ " for " + dataMap.get("CAMPUS_NAME"));
//		WebBL wb = new WebBL();
//		outputMap = wb.EnterSameDirectionsTOFrom(driver, dataMap);
//		wb.validateResults(extentTest, outputMap);
//	}
//
//	@Test(priority = 11, enabled = true, dataProvider = "getData")
//	public void validateAlertMsgOffSiteToOffSiteDirections(HashMap<String, String> dataMap)
//			throws InterruptedException {
//		initialization(dataMap.get("BROWSER_NAME"));
//		extentTest = parent.createNode("Validating Alert Msg On OffSite To OffSite Directions on "
//				+ dataMap.get("BROWSER_NAME") + " for " + dataMap.get("CAMPUS_NAME"));
//		WebBL wb = new WebBL();
//		outputMap = wb.EnterOffSiteDirectionsTOFrom(driver, dataMap);
//		wb.validateResults(extentTest, outputMap);
//	}
//
//	@Test(priority = 12, enabled = true, dataProvider = "getData")
//	public void validateDirectoryMenuSubMenu(HashMap<String, String> dataMap) throws InterruptedException {
//		initialization(dataMap.get("BROWSER_NAME"));
//		extentTest = parent.createNode("Validating Directory Menu and SubMenu on " + dataMap.get("BROWSER_NAME")
//				+ " for " + dataMap.get("CAMPUS_NAME"));
//		WebBL wb = new WebBL();
//		outputMap = wb.performDirectoryMenu(driver, dataMap);
//		wb.validateResults(extentTest, outputMap);
//	}
//
//	@Test(priority = 13, enabled = true, dataProvider = "getData")
//	public void BlankFromField(HashMap<String, String> dataMap) throws InterruptedException {
//		initialization(dataMap.get("BROWSER_NAME"));
//		extentTest = parent.createNode("Validating Bluedot on SVG Map when From field is blank "
//				+ dataMap.get("BROWSER_NAME") + " for " + dataMap.get("CAMPUS_NAME"));
//		WebBL wb = new WebBL();
//		outputMap = wb.performBlankFromField(driver, dataMap);
//		wb.validateResults(extentTest, outputMap);
//	}
//
//	@Test(priority = 14, enabled = true, dataProvider = "getData")
//	public void BlankToField(HashMap<String, String> dataMap) throws InterruptedException {
//		initialization(dataMap.get("BROWSER_NAME"));
//		extentTest = parent.createNode("Validating Bluedot on SVG Map when To field is blank "
//				+ dataMap.get("BROWSER_NAME") + " for " + dataMap.get("CAMPUS_NAME"));
//		WebBL wb = new WebBL();
//		outputMap = wb.performBlankToField(driver, dataMap);
//		wb.validateResults(extentTest, outputMap);
//	}
//
//	@Test(priority = 15, enabled = true, dataProvider = "getData")
//	public void ValidateDirectionsLoadedOrNotWhenPasteURL(HashMap<String, String> dataMap) throws InterruptedException {
//		initialization(dataMap.get("BROWSER_NAME"));
//		extentTest = parent.createNode("Validating Directions loaded or not when paste URL in new tab "
//				+ dataMap.get("BROWSER_NAME") + " for " + dataMap.get("CAMPUS_NAME"));
//		WebBL wb = new WebBL();
//		outputMap = wb.performPasteURLInNewTab(driver, dataMap);
//		wb.validateResults(extentTest, outputMap);
//	}
//
//	@Test(priority = 16, enabled = true, dataProvider = "getData")
//	public void ValidateDirectoryInternalSearch(HashMap<String, String> dataMap) throws InterruptedException {
//		initialization(dataMap.get("BROWSER_NAME"));
//		extentTest = parent.createNode("Validating Funtionality Of Directory Internal Search "
//				+ dataMap.get("BROWSER_NAME") + " for " + dataMap.get("CAMPUS_NAME"));
//		WebBL wb = new WebBL();
//		outputMap = wb.performDirectoryInternalSearch(driver, dataMap);
//		wb.validateResults(extentTest, outputMap);
//	}
//
//	@Test(priority = 17, enabled = true, dataProvider = "getData")
//	public void ValidateDirectoryBackButton(HashMap<String, String> dataMap) throws InterruptedException {
//		initialization(dataMap.get("BROWSER_NAME"));
//		extentTest = parent.createNode("Validating Present of Directory Menu Back Arrow Icon "
//				+ dataMap.get("BROWSER_NAME") + " for " + dataMap.get("CAMPUS_NAME"));
//		WebBL wb = new WebBL();
//		outputMap = wb.performDirectoryBackButton(driver, dataMap);
//		wb.validateResults(extentTest, outputMap);
//	}
//
//	@Test(priority = 18, enabled = true, dataProvider = "getData")
//	public void ValidateDirectoryCrossButton(HashMap<String, String> dataMap) throws InterruptedException {
//		initialization(dataMap.get("BROWSER_NAME"));
//		extentTest = parent.createNode("Validating Present of Directory Menu Cross Icon " + dataMap.get("BROWSER_NAME")
//				+ " for " + dataMap.get("CAMPUS_NAME"));
//		WebBL wb = new WebBL();
//		outputMap = wb.performDirectoryCrossButton(driver, dataMap);
//		wb.validateResults(extentTest, outputMap);
//	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
