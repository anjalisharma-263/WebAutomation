package com.purpleAdmin.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.purpleAdmin.qa.base.TestBase;
import com.purpleAdmin.qa.util.TestUtil;

public class WebDirectoryPage extends TestBase {
	@FindBy(xpath = "//input[@name ='ion-input-0']")
	WebElement startingPoint;

	@FindBy(xpath = "//input[@name ='ion-input-1']")
	WebElement destinationPoint;

	@FindBy(xpath = "(//span[@class='iconExpanderBg'])[1]")
	WebElement expandIcon;

	@FindBy(xpath = "(//button[@class='mapItButton'])[1]")
	WebElement MapIt;

	@FindBy(xpath = "(//button[@class='viewMap '])[1]")
	WebElement viewOnMap;

	@FindBy(xpath = "(//button[@class='viewMap '])[2]")
	WebElement viewOnMapForOffsite;

	@FindBy(xpath = "(//div[@class='accordion']//a)[1]")
	WebElement selectParking;

	@FindBy(id = "reverseDirection")
	WebElement reverseDirection;

	@FindBy(xpath = "//div[@class='showHelpMessage']")
	WebElement SameToFromField;

	@FindBy(xpath = "//input[@placeholder='Start typing to filter the results']")
	WebElement directoryInternalSearch;

	@FindBy(xpath = "//span[@class='indexColumn']")
	WebElement firstResultAfterDirectoryInternalSearch;

	@FindBy(tagName = "ion-icon")
	WebElement directoryBackArrowTag;

	@FindBy(xpath = "//button[@class='backMenu']//ion-icon[@class='md hydrated']")
	WebElement directoryBackArrowIcon;

	@FindBy(xpath = "//button[@class='customBackButton']//ion-icon[@name='close']")
	WebElement directoryCrossIcon;

	@FindBy(xpath = "//div[@class ='checkboxTerms']//ion-checkbox")
	WebElement eULAchkBox;
	
	@FindBy(xpath = "(//ion-row[@class ='searchGoogleRow md hydrated']//ion-col//div//a)[1]")
	WebElement selectOffsiteLocation;

	Boolean blnFlag = false;

	// Initializing the Page objects
	public WebDirectoryPage() {
		PageFactory.initElements(driver, this);
	}

	public void enterStartingPoint(String starting_Point) {
		if (TestUtil.waitForElementPresence(startingPoint, driver)) {
			startingPoint.click();
			startingPoint.sendKeys(starting_Point);
		}
	}

	public void clickOnDirectoryMenuTo(String toFirstMenu) {
		WebElement ToFirstMenu = driver.findElement(By.xpath("//span[contains(text(),'" + toFirstMenu + "')]"));
		if (TestUtil.waitForElementPresence(ToFirstMenu, driver)) {
			ToFirstMenu.click();
		}
	}

	public void clickOnDirectorySubMenuTo(String toSubMenu) {
		WebElement ToSubMenu = driver.findElement(By.xpath("//span[contains(text(),'" + toSubMenu + "')]"));
		if (TestUtil.waitForElementPresence(ToSubMenu, driver)) {
			ToSubMenu.click();
		}
	}

	public void clickOnDirectoryMenuFrom(String fromFirstMenu) {
		WebElement FromFirstMenu = driver.findElement(By.xpath("//span[contains(text(),'" + fromFirstMenu + "')]"));
		if (TestUtil.waitForElementPresence(FromFirstMenu, driver)) {
			FromFirstMenu.click();
		}
	}

	public void clickOnDirectorySubMenuFrom(String fromSubMenu) {
		WebElement FromSubMenu = driver.findElement(By.xpath("//span[contains(text(),'" + fromSubMenu + "')]"));
		if (TestUtil.waitForElementPresence(FromSubMenu, driver)) {
			FromSubMenu.click();
		}
	}

	public void enterDestinationPoint(String destination_Point) {
		if (TestUtil.waitForElementPresence(destinationPoint, driver)) {
			destinationPoint.click();
			destinationPoint.sendKeys(destination_Point);
		}
	}

	public void ExpandIconPoint() {
		if (TestUtil.waitForElementPresence(expandIcon, driver)) {
			expandIcon.click();
		}
	}

	public void clickMapIt() {
		if (TestUtil.waitForElementPresence(MapIt, driver)) {
			MapIt.click();
		}
	}

	public Boolean clickViewOnMap() {
		if (TestUtil.waitForElementPresence(viewOnMap, driver)) {
			viewOnMap.click();
			blnFlag = true;
		}
		return blnFlag;
	}

	public Boolean clickViewOnMapForOffiste() {
		TestUtil.scrollByVisibleElement(viewOnMapForOffsite);
		if (TestUtil.waitForElementPresence(viewOnMapForOffsite, driver)) {
			viewOnMapForOffsite.click();
			blnFlag = true;
		}
		return blnFlag;
	}

	public void selectParkingFromMenu() {
		if (TestUtil.waitForElementPresence(selectParking, driver)) {
			selectParking.click();
		}
	}

	public void clickReverseDirection() {
		if (TestUtil.waitForElementPresence(reverseDirection, driver)) {
			reverseDirection.click();
		}

	}

	public Boolean CheckSameDirectionsAlertMsg() {
		if (TestUtil.waitForElementPresence(SameToFromField, driver)) {
			System.out.println("Alert Msg is present : " + SameToFromField.getText());
			blnFlag = true;
		}
		return blnFlag;
	}

	public Boolean isReverseIconEnabled() {
		Boolean blnFlag = false;
		blnFlag = reverseDirection.isEnabled();
		if (blnFlag == false) {
			blnFlag = true;
		}
		return blnFlag;
	}

	public Boolean isDirectionContentClickable() {
		List<WebElement> allRows = driver.findElements(By.xpath("//ul//li//span[@class = 'directionContent ']"));
		System.out.println(allRows);

		for (WebElement element : allRows) {
			System.out.println(element.getText());
			blnFlag = element.isEnabled();
			if (blnFlag) {
				element.click();
			} else {
				System.out.println(element + " is not clickable ");
			}
		}
		return blnFlag;
	}

	public void enterDirectoryInternalSearchInput(String starting_Point) {
		if (TestUtil.waitForElementPresence(directoryInternalSearch, driver)) {
			directoryInternalSearch.click();
			directoryInternalSearch.sendKeys(starting_Point);
		}
	}

	public void clickfirstResultAfterDirectoryInternalSearch() {
		if (TestUtil.waitForElementPresence(firstResultAfterDirectoryInternalSearch, driver)) {
			firstResultAfterDirectoryInternalSearch.click();
		}

	}

	public void clickOnDirectoryBackButton(String browserName) {
		if (browserName.equals("Chrome")) {
			if (TestUtil.waitForElementPresence(directoryBackArrowTag, driver)) {
				WebElement shadowRoot1 = TestUtil.expandRootElement(directoryBackArrowTag);
				shadowRoot1.findElement(By.cssSelector("button.backMenu")).click();
				;
			}
		}
		if (browserName.equals("FF") || browserName.equals("Edge") || browserName.equals("IE")) {
			try {
				Thread.sleep(15000);
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", directoryBackArrowIcon);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		if (browserName.equals("Safari")) {
			if (TestUtil.waitForElementPresence(eULAchkBox, driver)) {
				eULAchkBox.click();
			}
		}
	}

	public void clickOnDirectoryCrossButton(String browserName) {
		if (browserName.equals("Chrome")) {
			if (TestUtil.waitForElementPresence(directoryBackArrowTag, driver)) {
				WebElement shadowRoot1 = TestUtil.expandRootElement(directoryBackArrowTag);
				shadowRoot1.findElement(By.cssSelector("button.backMenu")).click();
				;
			}
		}
		if (browserName.equals("FF") || browserName.equals("Edge") || browserName.equals("IE")) {
			try {
				Thread.sleep(15000);
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", directoryCrossIcon);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		if (browserName.equals("Safari")) {
			if (TestUtil.waitForElementPresence(eULAchkBox, driver)) {
				eULAchkBox.click();
			}
		}
	}

	public void clearStartingPointText() {
		TestUtil.clearData(startingPoint);
	}

	public void clearDestinationPointText() {
		TestUtil.clearData(destinationPoint);
	}

	public Boolean isGoogleSearchEnable() {
		Boolean blnFlag = false;
		List<WebElement> googleResultList = driver
				.findElements(By.xpath("//div[@class ='googlesearchAtoComplete']//div//div//ion-row"));
		for (WebElement element : googleResultList) {
			System.out.println(element.getText());
		}
		if (googleResultList.size() >= 1) {
			blnFlag = true;
		} else {
			System.out.println("Google search is not working");
		}
		return blnFlag;
	}
	
	public void selectOffsiteLocation(){
		if(TestUtil.waitForElementPresence(selectOffsiteLocation, driver)){
		selectOffsiteLocation.click();
		}
	}

}
