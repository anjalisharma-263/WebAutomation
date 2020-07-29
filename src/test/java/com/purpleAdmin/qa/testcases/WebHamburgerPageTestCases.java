package com.purpleAdmin.qa.testcases;

import java.util.HashMap;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.purpleAdmin.qa.base.TestBase;
import com.purpleAdmin.qa.pages.WebHamburgerPage;

import businessLogic.WebBL;

public class WebHamburgerPageTestCases extends TestBase {
	public static final String DETAIL_PAGE_DATA_SHEET = System.getProperty("user.dir") +"/src/main/java/com/purpleAdmin/qa/testdata/KioskData.xls";
	public static final String SHEET_NAME = "Web";
	ExtentTest extentTest = null;
	public static ExtentTest parent;
	HashMap<String, String> outputMap;
	WebHamburgerPage webHamburgerPage = new WebHamburgerPage();


	@BeforeClass
	public void createTest() {
		parent = extent.createTest("Hamburger Features Validation Test");		
	}

	@BeforeMethod
	public void setUp() {
		outputMap = new HashMap<String, String>();
	}

//	@Test(dataProvider = "getData")
//	public void validateCompanyLogo(HashMap<String, String> dataMap){
//		initialization(dataMap.get("BROWSER_NAME"));
//		extentTest = parent.createNode("Validating Company Logo"+ dataMap.get("BROWSER_NAME")+ " for " +dataMap.get("CAMPUS_NAME"));
//		WebBL wb = new WebBL();
//		try {
//			outputMap = wb.verifyCompanyLogo(driver, dataMap);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		wb.validateResults(extentTest, outputMap);
//	}

	@Test(priority = 1, enabled = true, dataProvider = "getData")
	public void validateSubmitFeedbackBtn(HashMap<String, String> dataMap){
		initialization(dataMap.get("BROWSER_NAME"));
		extentTest = parent.createNode("Validating Submit Feedback Button Functionality "+ dataMap.get("BROWSER_NAME")+ " for " +dataMap.get("CAMPUS_NAME"));
		WebBL wb = new WebBL();
		outputMap = wb.performSubmitFeedback(driver, dataMap);
		wb.validateResults(extentTest, outputMap);
	}

//	@Test(priority = 2, enabled = true, dataProvider = "getData")
//	public void validateFAQsBtn(HashMap<String, String> dataMap){
//		initialization(dataMap.get("BROWSER_NAME"));
//		extentTest = parent.createNode("Validating FAQs Button Functionality "+ dataMap.get("BROWSER_NAME")+ " for " +dataMap.get("CAMPUS_NAME"));
//		WebBL wb = new WebBL();
//		outputMap = wb.performFAQs(driver, dataMap);
//		wb.validateResults(extentTest, outputMap);
//	}
//
//
//	@Test(priority = 3, enabled = true, dataProvider = "getData")
//	public void validateClearRouteBtn(HashMap<String, String> dataMap){
//		initialization(dataMap.get("BROWSER_NAME"));
//		extentTest = parent.createNode("Validating Clear Route Button Functionality "+ dataMap.get("BROWSER_NAME")+ " for " +dataMap.get("CAMPUS_NAME"));
//		WebBL wb = new WebBL();
//		outputMap = wb.performClearRoute(driver, dataMap);
//		wb.validateResults(extentTest, outputMap);
//	}
//
//	@Test(priority = 4, enabled = true, dataProvider = "getData")
//	public void validateAppOverviewBtn(HashMap<String, String> dataMap){
//		
//		try {
//			initialization(dataMap.get("BROWSER_NAME"));
//			extentTest = parent.createNode("Validating App Overview Button Functionality "+ dataMap.get("BROWSER_NAME")+ " for " +dataMap.get("CAMPUS_NAME"));
//			WebBL wb = new WebBL();
//			outputMap = wb.performAppOverview(driver, dataMap);
//			wb.validateResults(extentTest, outputMap);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	@Test(priority = 5, enabled = true, dataProvider = "getData")
//	public void validatePrivacyPolicyBtn(HashMap<String, String> dataMap){
//		initialization(dataMap.get("BROWSER_NAME"));
//		extentTest = parent.createNode("Validating Privacy Policy Button Functionality "+ dataMap.get("BROWSER_NAME")+ " for " +dataMap.get("CAMPUS_NAME"));
//		WebBL wb = new WebBL();
//		outputMap = wb.performPrivacyPolicyBtn(driver, dataMap);
//		wb.validateResults(extentTest, outputMap);
//	}
//
//	@Test(priority = 6, enabled = true, dataProvider = "getData")
//	public void validateEULABtn(HashMap<String, String> dataMap){
//		initialization(dataMap.get("BROWSER_NAME"));
//		extentTest = parent.createNode("Validating EULA Button Functionality "+ dataMap.get("BROWSER_NAME")+ " for " +dataMap.get("CAMPUS_NAME"));
//		WebBL wb = new WebBL();
//		outputMap = wb.performEULA(driver, dataMap);
//		wb.validateResults(extentTest, outputMap);
//	}
//	
//	@Test(priority = 7, enabled = true, dataProvider = "getData")
//	public void validateSendFeedback(HashMap<String, String> dataMap){
//		initialization(dataMap.get("BROWSER_NAME"));
//		extentTest = parent.createNode("Validating Send Feedback Button Functionality "+ dataMap.get("BROWSER_NAME")+ " for " +dataMap.get("CAMPUS_NAME"));
//		WebBL wb = new WebBL();
//		outputMap = wb.performSendFeedback(driver, dataMap);
//		wb.validateResults(extentTest, outputMap);
//	}
//	
//
//
//	@Test(priority = 8, enabled = true, dataProvider = "getData")
//	public void validateEventCaledar(HashMap<String, String> dataMap){
//		initialization(dataMap.get("BROWSER_NAME"));
//		extentTest = parent.createNode("Validating Event Calendar Button Functionality "+ dataMap.get("BROWSER_NAME")+ " for " +dataMap.get("CAMPUS_NAME"));
//		WebBL wb = new WebBL();
//		outputMap = wb.performEventCalendar(driver, dataMap);
//		wb.validateResults(extentTest, outputMap);
//	}
//	
//	@Test(priority = 9, enabled = true, dataProvider = "getData")
//	public void validateDownloadMobileApp(HashMap<String, String> dataMap){
//		initialization(dataMap.get("BROWSER_NAME"));
//		extentTest = parent.createNode("Validating Download Mobile App Button Functionality "+ dataMap.get("BROWSER_NAME")+ " for " +dataMap.get("CAMPUS_NAME"));
//		WebBL wb = new WebBL();
//		outputMap = wb.performDownloadMobileApp(driver, dataMap);
//		wb.validateResults(extentTest, outputMap);
//	}

	@AfterMethod
	public void tearDown() {
		extent.flush();
		driver.quit();
	}
}
