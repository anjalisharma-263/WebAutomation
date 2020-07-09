package businessLogic;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.purpleAdmin.qa.base.TestBase;
import com.purpleAdmin.qa.pages.Kiosk;
import com.purpleAdmin.qa.pages.WebDirectoryPage;
import com.purpleAdmin.qa.pages.WebHamburgerPage;
import com.purpleAdmin.qa.pages.WebLoginPage;
import com.purpleAdmin.qa.pages.WebMapPage;
import com.purpleAdmin.qa.util.TestUtil;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class WebBL {
	WebLoginPage loginPage = new WebLoginPage();
	WebDirectoryPage dirPage = new WebDirectoryPage();
	WebMapPage mapPage = new WebMapPage();
	WebHamburgerPage webHamburgerPage = new WebHamburgerPage();
	Boolean isMapDisplayed = false;
	Boolean isBlueDotDisplayed = false;
	Boolean isNavigationStepsDisplayed = false;
	Boolean isDirectionContentClickable = false;
	Boolean isAlertMsgDisplayed = false;
	HashMap<String, String> outputMap = new HashMap<String, String>();
	ExtentTest extentTest = null;
	Boolean blnFlag = false;
	
	public HashMap<String, String> performPasteURLInNewTab(WebDriver driver, HashMap<String, String> dataMap) {
		performPrerequisitesPasteURLInNewTab(driver, dataMap);
		isNavigationStepsDisplayed = dirPage.clickViewOnMap();
		isDirectionContentClickable = dirPage.isDirectionContentClickable();
		isMapDisplayed = mapPage.verifyOnsiteMapPresence();
		isBlueDotDisplayed = mapPage.verifyBlueDotPresence();
		outputMap.put("NAVIGATION_STATUS", String.valueOf(isNavigationStepsDisplayed));
		outputMap.put("NavigationStepsClickable_STATUS", String.valueOf(isNavigationStepsDisplayed));
		outputMap.put("MAP_STATUS", String.valueOf(isMapDisplayed));
		outputMap.put("BLUEDOT_STATUS", String.valueOf(isBlueDotDisplayed));
		return outputMap;
	}
	
	public HashMap<String, String> performDirectoryBackButton(WebDriver driver, HashMap<String, String> dataMap) {
		performPrerequisitesDirectoryBackButton(driver, dataMap);
		isBlueDotDisplayed = mapPage.verifyBlueDotPresence();
		outputMap.put("BLUEDOT_STATUS", String.valueOf(isBlueDotDisplayed));
		return outputMap;
	}
	
	public HashMap<String, String> performDirectoryInternalSearch(WebDriver driver, HashMap<String, String> dataMap) {
		performPrerequisitesDirectoryInternalSearch(driver, dataMap);
		isBlueDotDisplayed = mapPage.verifyBlueDotPresence();
		outputMap.put("BLUEDOT_STATUS", String.valueOf(isBlueDotDisplayed));
		return outputMap;
	}

	public HashMap<String, String> performOnisteDirections(WebDriver driver, HashMap<String, String> dataMap) {
		performPrerequisites(driver, dataMap);
		isNavigationStepsDisplayed = dirPage.clickViewOnMap();
		isDirectionContentClickable = dirPage.isDirectionContentClickable();
		isMapDisplayed = mapPage.verifyOnsiteMapPresence();
		isBlueDotDisplayed = mapPage.verifyBlueDotPresence();
		outputMap.put("NAVIGATION_STATUS", String.valueOf(isNavigationStepsDisplayed));
		outputMap.put("NavigationStepsClickable_STATUS", String.valueOf(isNavigationStepsDisplayed));
		outputMap.put("MAP_STATUS", String.valueOf(isMapDisplayed));
		outputMap.put("BLUEDOT_STATUS", String.valueOf(isBlueDotDisplayed));
		return outputMap;
	}

	public HashMap<String, String> performDirectoryMenu(WebDriver driver, HashMap<String, String> dataMap) {
		performPrerequisitesDirectory(driver, dataMap);
		isNavigationStepsDisplayed = dirPage.clickViewOnMap();
		isMapDisplayed = mapPage.verifyOnsiteMapPresence();
		isBlueDotDisplayed = mapPage.verifyBlueDotPresence();
		outputMap.put("NAVIGATION_STATUS", String.valueOf(isNavigationStepsDisplayed));
		outputMap.put("MAP_STATUS", String.valueOf(isMapDisplayed));
		outputMap.put("BLUEDOT_STATUS", String.valueOf(isBlueDotDisplayed));
		return outputMap;
	}

	public HashMap<String, String> performBlankToField(WebDriver driver, HashMap<String, String> dataMap) {
		performPrerequisitesBlankToField(driver, dataMap);
		isBlueDotDisplayed = mapPage.verifyBlueDotPresence();
		outputMap.put("BLUEDOT_STATUS", String.valueOf(isBlueDotDisplayed));
		return outputMap;
	}

	public HashMap<String, String> performBlankFromField(WebDriver driver, HashMap<String, String> dataMap) {
		performPrerequisitesBlankFromField(driver, dataMap);
		isBlueDotDisplayed = mapPage.verifyBlueDotPresence();
		outputMap.put("BLUEDOT_STATUS", String.valueOf(isBlueDotDisplayed));
		return outputMap;
	}

	public HashMap<String, String> EnterSameDirectionsTOFrom(WebDriver driver, HashMap<String, String> dataMap) {
		performPrerequisites(driver, dataMap);
		isAlertMsgDisplayed = dirPage.CheckSameDirectionsAlertMsg();
		outputMap.put("AlertMsg_STATUS", String.valueOf(isAlertMsgDisplayed));
		return outputMap;
	}

	public HashMap<String, String> EnterOffSiteDirectionsTOFrom(WebDriver driver, HashMap<String, String> dataMap) {
		performPrerequisitesOffSiteToOffSite(driver, dataMap);
		isAlertMsgDisplayed = dirPage.CheckSameDirectionsAlertMsg();
		outputMap.put("AlertMsg_STATUS", String.valueOf(isAlertMsgDisplayed));
		return outputMap;
	}

	public HashMap<String, String> performOnisteOffsiteDirections(WebDriver driver, HashMap<String, String> dataMap) {
		performPrerequisites(driver, dataMap);
		dirPage.selectParkingFromMenu();
		isNavigationStepsDisplayed = dirPage.clickViewOnMap();
		isMapDisplayed = mapPage.verifyOnsiteOffsiteMapPresence();
		isBlueDotDisplayed = mapPage.verifyBlueDotPresence();
		outputMap.put("NAVIGATION_STATUS", String.valueOf(isNavigationStepsDisplayed));
		outputMap.put("MAP_STATUS", String.valueOf(isMapDisplayed));
		outputMap.put("BLUEDOT_STATUS", String.valueOf(isBlueDotDisplayed));
		return outputMap;
	}

	public HashMap<String, String> performOffsiteOnisteDirectionsReverse(WebDriver driver,
			HashMap<String, String> dataMap) {
		performPrerequisites(driver, dataMap);
		dirPage.selectParkingFromMenu();
		dirPage.clickViewOnMap();
		dirPage.clickReverseDirection();
		dirPage.selectParkingFromMenu();
		isMapDisplayed = mapPage.verifyOffsiteOnsiteMapPresence();
		isNavigationStepsDisplayed = dirPage.clickViewOnMapForOffiste();
		isBlueDotDisplayed = mapPage.verifyBlueDotPresence();
		// mapPage.verifyPointAB();
		outputMap.put("NAVIGATION_STATUS", String.valueOf(isNavigationStepsDisplayed));
		outputMap.put("MAP_STATUS", String.valueOf(isMapDisplayed));
		outputMap.put("BLUEDOT_STATUS", String.valueOf(isBlueDotDisplayed));
		return outputMap;
	}

	public HashMap<String, String> performReverse(WebDriver driver, HashMap<String, String> dataMap)
			throws InterruptedException {
		Boolean isReverseIconEnabled = false;
		driver.get(dataMap.get("URL"));
		acceptTermsDisplayed(dataMap);
		isReverseIconEnabled = dirPage.isReverseIconEnabled();
		outputMap.put("Reverse icon state when there is no starting/destination point",
				String.valueOf(isReverseIconEnabled));
		loginPage.clickStartingPoint();
		dirPage.enterStartingPoint(dataMap.get("STARTING_POINT"));
		Thread.sleep(5000);
		dirPage.ExpandIconPoint();
		dirPage.clickMapIt();
		isReverseIconEnabled = dirPage.isReverseIconEnabled();
		outputMap.put("Reverse icon state with only starting point", String.valueOf(isReverseIconEnabled));
		dirPage.enterDestinationPoint(dataMap.get("DESTINATION_POINT"));
		dirPage.ExpandIconPoint();
		dirPage.clickMapIt();
		TestUtil.clearData(dirPage.startingPoint);
		TestUtil.clearData(dirPage.destinationPoint);
		isReverseIconEnabled = dirPage.isReverseIconEnabled();
		outputMap.put("Reverse icon state after clearing starting/destination point",
				String.valueOf(isReverseIconEnabled));
		return outputMap;
	}

	public HashMap<String, String> performClearRoute(WebDriver driver, HashMap<String, String> dataMap) {
		try {
			Boolean isTextCleared = false;
			performPrerequisites(driver, dataMap);
			webHamburgerPage.clickHamburger(dataMap.get("BROWSER_NAME"));
			webHamburgerPage.clickClearRoute();
			isTextCleared = TestUtil.compareText(loginPage.startingPoint, "");
			System.out.print(isTextCleared);
			outputMap.put("CLEARROUTE_STATUS", String.valueOf(isTextCleared));
		} catch (Exception e) {
			System.out.println(e);
		}
		return outputMap;
	}

	/*
	 * public HashMap<String, String> performAppOverview(WebDriver driver,
	 * HashMap<String, String> dataMap) { try{ Boolean isSkipTutorial = false;
	 * driver.get(dataMap.get("URL")); acceptTermsDisplayed(dataMap);
	 * webHamburgerPage.clickHamburger(dataMap.get("BROWSER_NAME"));
	 * webHamburgerPage.clickAppOverview(); isSkipTutorial =
	 * loginPage.skipTutorial(); System.out.print(isSkipTutorial);
	 * outputMap.put("APPOVERVIEW_STATUS", String.valueOf(isSkipTutorial));
	 * }catch(Exception e){ System.out.println(e); } return outputMap; }
	 */
	public HashMap<String, String> performPrivacyPolicyBtn(WebDriver driver, HashMap<String, String> dataMap) {
		try {
			Boolean isPPolicyTextLoaded = false;
			Boolean isPPolicyClosed = false;
			driver.get(dataMap.get("URL"));
			acceptTermsDisplayed(dataMap);
			webHamburgerPage.clickHamburger(dataMap.get("BROWSER_NAME"));
			webHamburgerPage.clickPrivacyPolicy();
			isPPolicyTextLoaded = webHamburgerPage.isPrivacyPolicyLoaded();
			TestUtil.scrollByVisibleElement(webHamburgerPage.endOfPPolicy);
			isPPolicyClosed = webHamburgerPage.clickClosePPolicy();
			outputMap.put("PRIVACYPOLICY_STATUS", String.valueOf(isPPolicyTextLoaded));
			outputMap.put("PPolicyCLOSE_STATUS", String.valueOf(isPPolicyClosed));
		} catch (Exception e) {
			System.out.println(e);
		}
		return outputMap;
	}

	public HashMap<String, String> performEULA(WebDriver driver, HashMap<String, String> dataMap) {
		try {
			Boolean isEULATextLoaded = false;
			Boolean isEULAClosed = false;
			driver.get(dataMap.get("URL"));
			acceptTermsDisplayed(dataMap);
			webHamburgerPage.clickHamburger(dataMap.get("BROWSER_NAME"));
			webHamburgerPage.clickEULAFromHamburger();
			isEULATextLoaded = webHamburgerPage.isEULALoaded();
			TestUtil.scrollByVisibleElement(webHamburgerPage.endOfEULA);
			isEULAClosed = webHamburgerPage.clickCloseEULAIcon();
			outputMap.put("EULA_STATUS", String.valueOf(isEULATextLoaded));
			outputMap.put("EULACLOSE_STATUS", String.valueOf(isEULAClosed));
		} catch (Exception e) {
			System.out.println(e);
		}
		return outputMap;
	}

	public HashMap<String, String> performMapZoomIn(WebDriver driver, HashMap<String, String> dataMap) {
		try {
			Boolean isMapZoomedIn = false;
			performPrerequisites(driver, dataMap);
			isMapZoomedIn = mapPage.verifyMapZoomIn();
			System.out.print(isMapZoomedIn);
			outputMap.put("ZoomIn_STATUS", String.valueOf(isMapZoomedIn));
		} catch (Exception e) {
			System.out.println(e);
		}
		return outputMap;
	}

	public HashMap<String, String> performMapZoomOut(WebDriver driver, HashMap<String, String> dataMap) {
		try {
			Boolean isMapZoomedOut = false;
			performPrerequisites(driver, dataMap);
			isMapZoomedOut = mapPage.verifyMapZoomOut();
			System.out.print(isMapZoomedOut);
			outputMap.put("ZoomOut_STATUS", String.valueOf(isMapZoomedOut));
		} catch (Exception e) {
			System.out.println(e);
		}
		return outputMap;
	}

	public HashMap<String, String> performMapRecenter(WebDriver driver, HashMap<String, String> dataMap) {
		try {
			Boolean isMapRecentered = false;
			performPrerequisites(driver, dataMap);
			isMapRecentered = mapPage.verifyMapRecenter();
			System.out.print(isMapRecentered);
			outputMap.put("MapRecenter_STATUS", String.valueOf(isMapRecentered));
		} catch (Exception e) {
			System.out.println(e);
		}
		return outputMap;
	}

	public HashMap<String, String> performMapRotationLeft(WebDriver driver, HashMap<String, String> dataMap) {
		try {
			Boolean isMapRotatedLeft = false;
			performPrerequisites(driver, dataMap);
			isMapRotatedLeft = mapPage.verifyMapRotateLeft();
			System.out.print(isMapRotatedLeft);
			outputMap.put("MapRotateLeft_STATUS", String.valueOf(isMapRotatedLeft));
		} catch (Exception e) {
			System.out.println(e);
		}
		return outputMap;
	}

	public HashMap<String, String> performMapRotationRight(WebDriver driver, HashMap<String, String> dataMap) {
		try {
			Boolean isMapRotatedRight = false;
			performPrerequisites(driver, dataMap);
			isMapRotatedRight = mapPage.verifyMapRotateLeft();
			System.out.print(isMapRotatedRight);
			outputMap.put("MapRotateRight_STATUS", String.valueOf(isMapRotatedRight));
		} catch (Exception e) {
			System.out.println(e);
		}
		return outputMap;
	}

	public HashMap<String, String> performKeyLegends(WebDriver driver, HashMap<String, String> dataMap) {
		try {
			Boolean isKeyLegendLoaded = false;
			performPrerequisites(driver, dataMap);
			isKeyLegendLoaded = mapPage.verifyKeyLegends();
			System.out.print(isKeyLegendLoaded);
			outputMap.put("KeyLegends_STATUS", String.valueOf(isKeyLegendLoaded));
		} catch (Exception e) {
			System.out.println(e);
		}
		return outputMap;
	}


	public void acceptTermsDisplayed(HashMap<String, String> dataMap) {
		String campusName = dataMap.get("CAMPUS_NAME");
		System.out.println(campusName);
		if (campusName.equals("AMC")) {
			acceptEULATerms(dataMap);

			// } else if (campusName.equals("FF") || campusName.equals("Edge"))
			// {
			// acceptEULATerms(dataMap); // This method handles EULA popup
			// loginPage.skipTutorial(); // This method handles Skip Tutorial
		} else {
			loginPage.skipTutorial();
		}
	}

	public void acceptEULATerms(HashMap<String, String> dataMap) {
		try {
			loginPage.acceptEULAChkBox(dataMap.get("BROWSER_NAME"));
			loginPage.acceptEULABtn();
		} catch (Exception e) {
			System.out.print("no EULA popup displayed");
		}
	}
	
	public void performPrerequisitesPasteURLInNewTab(WebDriver driver, HashMap<String, String> dataMap) {
		try {
			System.out.println(dataMap);
			driver.get(dataMap.get("URL"));
			System.out.println(dataMap.get("URL"));
			Thread.sleep(9000);
			acceptTermsDisplayed(dataMap);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void performPrerequisitesOffSiteToOffSite(WebDriver driver, HashMap<String, String> dataMap) {
		try {
			System.out.println(dataMap);
			driver.get(dataMap.get("URL"));
			Thread.sleep(9000);
			acceptTermsDisplayed(dataMap);
			loginPage.clickStartingPoint();
			dirPage.enterStartingPoint(dataMap.get("STARTING_POINT"));
			// Thread.sleep(5000);
			dirPage.selectParkingFromMenu();
			dirPage.enterDestinationPoint(dataMap.get("DESTINATION_POINT"));
			// Thread.sleep(9000);
			dirPage.selectParkingFromMenu();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void performPrerequisites(WebDriver driver, HashMap<String, String> dataMap) {
		try {
			System.out.println(dataMap);
			driver.get(dataMap.get("URL"));
			Thread.sleep(9000);
			acceptTermsDisplayed(dataMap);
			verifyCompanyLogo(driver, dataMap);
			loginPage.clickStartingPoint();
			dirPage.enterStartingPoint(dataMap.get("STARTING_POINT"));
			Thread.sleep(5000);
			dirPage.ExpandIconPoint();
			dirPage.clickMapIt();
			dirPage.enterDestinationPoint(dataMap.get("DESTINATION_POINT"));
			// dirPage.selectParkingFromMenu();
			dirPage.ExpandIconPoint();
			dirPage.clickMapIt();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void performPrerequisitesDirectoryInternalSearch(WebDriver driver, HashMap<String, String> dataMap) {
		try {
			System.out.println(dataMap);
			driver.get(dataMap.get("URL"));
			System.out.println(dataMap.get("URL"));
			Thread.sleep(9000);
			acceptTermsDisplayed(dataMap);
			loginPage.clickStartingPoint();
			dirPage.clickOnDirectoryMenuTo(dataMap.get("ToDirectoryMenu"));
			dirPage.enterDirectoryInternalSearchInput(dataMap.get("DirectoryInternalInput1"));
			dirPage.clickfirstResultAfterDirectoryInternalSearch();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void performPrerequisitesDirectoryBackButton(WebDriver driver, HashMap<String, String> dataMap) {
		try {
			System.out.println(dataMap);
			driver.get(dataMap.get("URL"));
			System.out.println(dataMap.get("URL"));
			Thread.sleep(9000);
			acceptTermsDisplayed(dataMap);
			loginPage.clickStartingPoint();
			dirPage.clickOnDirectoryMenuTo(dataMap.get("ToDirectoryMenu"));
			dirPage.clickOnDirectoryBackButton(dataMap.get("BROWSER_NAME"));
			

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	

	public void performPrerequisitesDirectory(WebDriver driver, HashMap<String, String> dataMap) {
		try {
			System.out.println(dataMap);
			driver.get(dataMap.get("URL"));
			System.out.println(dataMap.get("URL"));
			Thread.sleep(9000);
			acceptTermsDisplayed(dataMap);
			loginPage.clickDestinationPoint();
			// System.out.println(dataMap.get("ToDirectoryMenu"));
			// System.out.println(dataMap.get("ToSubMenu1"));
			// System.out.println(dataMap.get("FromDirectoryMenu"));
			// System.out.println(dataMap.get("FromSubMenu1"));
			dirPage.clickOnDirectoryMenuTo(dataMap.get("ToDirectoryMenu"));
			dirPage.clickOnDirectorySubMenuTo(dataMap.get("ToSubMenu1"));
			dirPage.clickOnDirectoryMenuFrom(dataMap.get("FromDirectoryMenu"));
			dirPage.clickOnDirectorySubMenuFrom(dataMap.get("FromSubMenu1"));

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void performPrerequisitesBlankFromField(WebDriver driver, HashMap<String, String> dataMap) {
		try {
			System.out.println(dataMap);
			driver.get(dataMap.get("URL"));
			System.out.println(dataMap.get("URL"));
			Thread.sleep(9000);
			acceptTermsDisplayed(dataMap);
			loginPage.clickStartingPoint();
			dirPage.enterStartingPoint(dataMap.get("STARTING_POINT"));
			Thread.sleep(5000);
			dirPage.ExpandIconPoint();
			dirPage.clickMapIt();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void performPrerequisitesBlankToField(WebDriver driver, HashMap<String, String> dataMap) {
		try {
			System.out.println(dataMap);
			driver.get(dataMap.get("URL"));
			System.out.println(dataMap.get("URL"));
			Thread.sleep(9000);
			acceptTermsDisplayed(dataMap);
			loginPage.clickDestinationPoint();
			dirPage.enterDestinationPoint(dataMap.get("DESTINATION_POINT"));
			Thread.sleep(5000);
			dirPage.ExpandIconPoint();
			dirPage.clickMapIt();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void validateResults(ExtentTest test, HashMap<String, String> outputMap) {
		System.out.println(outputMap);
		for (HashMap.Entry<String, String> entry : outputMap.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key + "||||" + value + "||||" + key.replace("_STATUS", "") + "||||" + test);
			new TestUtil().verifyText(value, "true", key.replace("_STATUS", "") + " LOAD VALIDATION", test);
		}
	}

	public HashMap<String, String> performAppOverview(WebDriver driver, HashMap<String, String> dataMap)
			throws InterruptedException {

		Boolean isAppOverViewForwardIconDispalyed = false;
		Boolean isAppOverViewBackIconDispalyed = false;
		Boolean isAppOverViewImagesDispalyed = false;
		driver.get(dataMap.get("URL"));
		System.out.println(dataMap);
		acceptTermsDisplayed(dataMap);
		webHamburgerPage.clickHamburger(dataMap.get("BROWSER_NAME"));
		Thread.sleep(5000);
		webHamburgerPage.clickAppOverview();

		for (int i = 0; i < 3; i++) {
			if (TestUtil.waitForElementPresence(webHamburgerPage.SkipTutForwardIcon, driver)) {
				isAppOverViewForwardIconDispalyed = true;
				webHamburgerPage.SkipTutForwardIcon.click();
			} else {
				System.out.println("Forward icon is not present");
			}

		}
		for (int j = 0; j < 3; j++) {
			if (TestUtil.waitForElementPresence(webHamburgerPage.SkipTutBackwardIcon, driver)) {
				isAppOverViewBackIconDispalyed = true;
				webHamburgerPage.SkipTutBackwardIcon.click();
			}
		}
		if (isAppOverViewForwardIconDispalyed) {
			isAppOverViewImagesDispalyed = AppOverviewListaWebElement(webHamburgerPage.SkipTutImg1,
					webHamburgerPage.SkipTutImg2, webHamburgerPage.SkipTutImg3, webHamburgerPage.SkipTutImg4,
					webHamburgerPage.SkipTutForwardIcon, driver);
		} else {
			System.out.println("Forward icon is not present");
		}
		outputMap.put("AppOverViewForwardIcon_Status", String.valueOf(isAppOverViewForwardIconDispalyed));
		outputMap.put("AppOverViewBackIcon_Status", String.valueOf(isAppOverViewBackIconDispalyed));
		outputMap.put("AppOverImages_Status", String.valueOf(isAppOverViewImagesDispalyed));
		return outputMap;
	}

	public boolean AppOverviewListaWebElement(WebElement img1, WebElement img2, WebElement img3, WebElement img4,
			WebElement forwardIcon, WebDriver driver) {
		int count = 0;
		List<WebElement> imgList = new ArrayList<WebElement>();
		imgList.add(webHamburgerPage.SkipTutImg1);
		imgList.add(webHamburgerPage.SkipTutImg2);
		imgList.add(webHamburgerPage.SkipTutImg3);
		imgList.add(webHamburgerPage.SkipTutImg4);
		for (WebElement img : imgList) {
			if (TestUtil.waitForElementPresence(img, driver)) {
				count++;
			}
			webHamburgerPage.SkipTutForwardIcon.click();
		}
		if (count < 3) {
			System.out.println("All Skip tutorial images is not present");
		} else {
			System.out.println("All Skip tutorial images are present");
			blnFlag = true;
		}
		return blnFlag;
	}

	public HashMap<String, String> performSubmitFeedback(WebDriver driver, HashMap<String, String> dataMap) {
		String actualPageTitle = "";
		String expectedPageTitle = dataMap.get("EXPECTED_TITLE");
		Boolean isSubmitFeedbackDispalyed = false;
		driver.get(dataMap.get("URL"));
		System.out.println(dataMap);
		acceptTermsDisplayed(dataMap);
		webHamburgerPage.clickHamburger(dataMap.get("BROWSER_NAME"));
		webHamburgerPage.clickSubmitFeedback();
		actualPageTitle = driver.getTitle();
		System.out.println(actualPageTitle);
		System.out.println(expectedPageTitle);
		if (actualPageTitle.equals(expectedPageTitle)) {
			System.out.println("Submit feedback link is functional");
			isSubmitFeedbackDispalyed = true;
		} else {
			System.out.println("Submit feedback link is not functional");
		}
		outputMap.put("SubmitFeedback_Status", String.valueOf(isSubmitFeedbackDispalyed));
		return outputMap;
	}

	public HashMap<String, String> performFAQs(WebDriver driver, HashMap<String, String> dataMap) {
		String actualPageTitle = "";
		String expectedPageTitle = dataMap.get("EXPECTED_TITLE");
		Boolean isFAQsDispalyed = false;
		driver.get(dataMap.get("URL"));
		System.out.println(dataMap);
		acceptTermsDisplayed(dataMap);
		webHamburgerPage.clickHamburger(dataMap.get("BROWSER_NAME"));
		webHamburgerPage.clickfAQs();
		actualPageTitle = driver.getTitle();
		System.out.println(actualPageTitle);
		System.out.println(expectedPageTitle);
		if (actualPageTitle.equals(expectedPageTitle)) {
			System.out.println("FAQs link is functional");
			isFAQsDispalyed = true;
		} else {
			System.out.println("FAQs link is not functional");
		}
		outputMap.put("FAQs_Status", String.valueOf(isFAQsDispalyed));
		return outputMap;
	}

	public HashMap<String, String> verifyCompanyLogo(WebDriver driver, HashMap<String, String> dataMap)
			throws InterruptedException {
		Boolean isCompanyLogoPresent = false;
		// driver.get(dataMap.get("URL"));
		// System.out.println(dataMap);
		// acceptTermsDisplayed(dataMap);
		isCompanyLogoPresent = loginPage.isLogoPresent();
		outputMap.put("Company_LOGO_Status", String.valueOf(isCompanyLogoPresent));
		return outputMap;
	}
}
