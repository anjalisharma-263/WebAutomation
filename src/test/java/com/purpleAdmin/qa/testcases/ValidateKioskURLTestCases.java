package com.purpleAdmin.qa.testcases;

import java.util.HashMap;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.purpleAdmin.qa.base.TestBase;
import businessLogic.KioskBL;

public class ValidateKioskURLTestCases extends TestBase {
	public static final String DETAIL_PAGE_DATA_SHEET = System.getProperty("user.dir") +"/src/main/java/com/purpleAdmin/qa/testdata/Test_Data.xls";
	public static final String SHEET_NAME = "Kiosk";
	ExtentTest extentTest = null;
	public static ExtentTest parent;
	HashMap<String, String> outputMap;


	@BeforeClass
	public void createTest() {
		parent = extent.createTest("Kiosk Page Load Validation Test");		
	}

	@BeforeMethod
	public void setUp() {
		outputMap = new HashMap<String, String>();
	}
	/*
	public ValidateKioskURLTestCases(){
		super();
	}
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
	}
	 */
	@Test(priority = 1, enabled = true, dataProvider = "getData")
	public void validateKioskURL(HashMap<String, String> dataMap) throws InterruptedException {
		initialization(dataMap.get("BROWSER_NAME"));
		extentTest = parent.createNode("Validating Kiosk Splash Screen on "+ dataMap.get("BROWSER_NAME")+ " for " +dataMap.get("CAMPUS_NAME"));
		KioskBL kbl = new KioskBL();
		outputMap = kbl.performKioskWithSplashActions(driver, dataMap);
		kbl.validateResults(extentTest, outputMap);
	}

/*	@Test(priority = 2, dataProvider ="getData")
	public void validateKioskURLWithoutSplash(HashMap<String, String> dataMap) throws InterruptedException{
		initialization(dataMap.get("BROWSER_NAME"));
		extentTest = parent.createNode("Validating Kiosk Without Splash Screen on "+ dataMap.get("BROWSER_NAME")+ " for " +dataMap.get("CAMPUS_NAME"));
		KioskBL kbl = new KioskBL();
		outputMap = kbl.performKioskWithoutSplashActions(driver, dataMap);
		kbl.validateResults(extentTest, outputMap);
	}
*/	
//	@AfterMethod
//	public void tearDown() {
//		driver.close();	
//	}
}





