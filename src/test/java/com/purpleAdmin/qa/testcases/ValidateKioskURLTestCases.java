/*package com.purpleAdmin.qa.testcases;

import java.util.HashMap;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.purpleAdmin.qa.base.TestBase;
import com.purpleAdmin.qa.util.TestUtil;

import businessLogic.KioskBL;

public class ValidateKioskURLTestCases extends TestBase {
	TestUtil testUtil;
	public static final String DETAIL_PAGE_DATA_SHEET = "/Users/user/Downloads/PurpleAuto/PurpleAdminPortal/src/main/java/com/purpleAdmin/qa/testdata/KioskData.xls";
	public static final String SHEET_NAME = "Sheet1";

	public ValidateKioskURLTestCases(){
		super();
	}
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
	}

	@Test(priority = 1, enabled = true, dataProvider = "getData")
	public void validateKioskURL(HashMap<String, String> dataMap     ) throws InterruptedException {
		KioskBL kbl = new KioskBL();
		dataMap      = kbl.performKioskWithSplashActions(driver, dataMap     );;
		kbl.validateResults(dataMap     );
	}
	
	@Test(priority = 2, dataProvider ="getData")
	public void validateKioskURLWithoutSplash(HashMap<String, String> dataMap) throws InterruptedException{
		KioskBL kbl = new KioskBL();
		dataMap = kbl.performKioskWithoutSplashActions(driver, dataMap);
		kbl.validateResults(dataMap);
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}





*/