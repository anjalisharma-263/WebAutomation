package com.purpleAdmin.qa.testcases;

import java.util.HashMap;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.purpleAdmin.qa.base.TestBase;

import businessLogic.WebBL;

public class WebMapPageTestCases extends TestBase{
	public static final String DETAIL_PAGE_DATA_SHEET = System.getProperty("user.dir") +"/src/main/java/com/purpleAdmin/qa/testdata/KioskData.xls";
	public static final String SHEET_NAME = "Web";
	ExtentTest extentTest = null;
	public static ExtentTest parent;
	HashMap<String, String> outputMap;

/*	public WebMapPageTestCases(){
		super();
	}
*/
	@BeforeTest
	public void createTest() {
		parent = extent.createTest("Map Operations Validation Test");		
	}

	@BeforeMethod
	public void setUp() {
		outputMap = new HashMap<String, String>();
	}
	@Test(priority = 1,dataProvider = "getData")
	public void validateMapZoomIn(HashMap<String, String> dataMap     ){
		initialization(dataMap     .get("BROWSER_NAME"));
		extentTest = parent.createNode("Validating Map Rotate Left on "+ dataMap     .get("BROWSER_NAME")+ " for " +dataMap     .get("CAMPUS_NAME"));
		WebBL wb = new WebBL();
		outputMap = wb.performMapZoomIn(driver, dataMap     );
		wb.validateResults(extentTest, outputMap);
	}

	@Test(priority = 2,dataProvider = "getData")
	public void validateMapZoomOut(HashMap<String, String> dataMap     ){
		initialization(dataMap     .get("BROWSER_NAME"));
		extentTest = parent.createNode("Validating Map Zoom Out on "+ dataMap     .get("BROWSER_NAME")+ " for " +dataMap     .get("CAMPUS_NAME"));
		WebBL wb = new WebBL();
		outputMap = wb.performMapZoomOut(driver, dataMap     );
		wb.validateResults(extentTest, outputMap);
	}

	@Test(priority = 3,dataProvider = "getData")
	public void validateMapRotateLeft(HashMap<String, String> dataMap     ){
		initialization(dataMap     .get("BROWSER_NAME"));
		extentTest = parent.createNode("Validating Map Rotate Left on "+ dataMap     .get("BROWSER_NAME")+ " for " +dataMap     .get("CAMPUS_NAME"));
		WebBL wb = new WebBL();
		outputMap = wb.performMapRotationLeft(driver, dataMap     );
		wb.validateResults(extentTest, outputMap);
	}

	@Test(priority = 4,dataProvider = "getData")
	public void validateMapRotateRight(HashMap<String, String> dataMap     ){
		initialization(dataMap     .get("BROWSER_NAME"));
		extentTest = parent.createNode("Validating Map Rotate Right on "+ dataMap     .get("BROWSER_NAME")+ " for " +dataMap     .get("CAMPUS_NAME"));
		WebBL wb = new WebBL();
		outputMap = wb.performMapRotationRight(driver, dataMap     );
		wb.validateResults(extentTest, outputMap);
	}
	@Test(priority = 5,dataProvider = "getData")
	public void validateMapRecenter(HashMap<String, String> dataMap     ){
		initialization(dataMap     .get("BROWSER_NAME"));
		extentTest = parent.createNode("Validating Map Zoom Recenter on "+ dataMap     .get("BROWSER_NAME")+ " for " +dataMap     .get("CAMPUS_NAME"));
		WebBL wb = new WebBL();
		outputMap = wb.performMapRecenter(driver, dataMap     );
		wb.validateResults(extentTest, outputMap);
	}

	@Test(priority = 6,dataProvider = "getData")
	public void validateKeyLegends(HashMap<String, String> dataMap     ){
		initialization(dataMap     .get("BROWSER_NAME"));
		extentTest = parent.createNode("Validating Key Legends on "+ dataMap     .get("BROWSER_NAME")+ " for " +dataMap     .get("CAMPUS_NAME"));
		WebBL wb = new WebBL();
		outputMap = wb.performKeyLegends(driver, dataMap     );
		wb.validateResults(extentTest, outputMap);
	}
	
	@AfterMethod
	public void tearDown() {
        driver.close();	
	}

}
