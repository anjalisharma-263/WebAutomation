package com.purpleAdmin.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.purpleAdmin.qa.base.TestBase;
import com.purpleAdmin.qa.util.TestUtil;

public class WebMapPage extends TestBase {
	@FindBy(xpath = "(//*[@name='withDirectionButton'])[2]")
	WebElement onsiteMapOnly;

	@FindBy(xpath = "(//*[@name='noDirectionButton'])[2]")
	WebElement onsiteOffsiteMap;

	@FindBy(xpath = "//ion-content[@name='noDirectionButton']")
	WebElement offsiteOnsiteMap;

	@FindBy(xpath = "//img[@class='flipIcon']")
	WebElement blueDot;

	@FindBy(xpath = "//span[@class='zoomIcon zoomIn active']")
	WebElement mapZoomIn;

	@FindBy(xpath = "//span[@class='zoomIcon zoomOut active']")
	WebElement mapZoomOut;

	@FindBy(xpath = "//span[@class='rotationIcon leftRotation active']")
	WebElement mapRotateLeft;

	@FindBy(xpath = "//span[@class='rotationIcon rightRotation active']")
	WebElement mapRotateRight;

	@FindBy(xpath = "//span[@class='recenter active']")
	WebElement mapRecentre;

	@FindBy(xpath = "//span[@class='legendsKey active']")
	WebElement legendsKey;



	//Initializing the Page objects
	public WebMapPage(){
		PageFactory.initElements(driver, this);
	}

	public Boolean verifyOnsiteMapPresence(){
		Boolean blnFlag = false;
		if(TestUtil.waitForElementPresence(onsiteMapOnly, driver)){
			System.out.println("indoorMap is loaded");
			blnFlag = true;
		}
		return blnFlag;
	}

	public Boolean verifyOnsiteOffsiteMapPresence(){
		Boolean blnFlag = false;
		if(TestUtil.waitForElementPresence(onsiteOffsiteMap, driver)){
			System.out.println("indoorMap is loaded");
			blnFlag = true;
		}
		return blnFlag;
	}

	public Boolean verifyOffsiteOnsiteMapPresence(){
		Boolean blnFlag = false;
		if(TestUtil.waitForElementPresence(offsiteOnsiteMap, driver)){
			System.out.println("Google Map is loaded");
			blnFlag = true;
		}
		return blnFlag;
	}

	public Boolean verifyBlueDotPresence(){
		Boolean blnFlag = false;
		if(TestUtil.waitForElementPresence(blueDot, driver)){
			System.out.println("Blue Dot is present");
			blnFlag = true;
		}
		return blnFlag;
	}

	public Boolean isGooglePointABVisible(){
		Boolean blnFlag = false;
		List<WebElement> list = new ArrayList<WebElement>();
		list = driver.findElements(By.xpath("//map[contains(@id,'gmimap')]//area"));
		System.out.print(list.size());
		if(list.size()==2){
			System.out.println("Google Points A and B are present");
			blnFlag = true;
		}
		return blnFlag;
	}

	public Boolean verifyMapZoomIn(){
		Boolean blnFlag = false;
		if(TestUtil.waitForElementPresence(mapZoomIn, driver)){
			System.out.println("Zoom In icon is present");
			mapZoomIn.click();
			blnFlag = true;
		}
		return blnFlag;
	}

	public Boolean verifyMapZoomOut(){
		Boolean blnFlag = false;
		if(TestUtil.waitForElementPresence(mapZoomOut, driver)){
			System.out.println("Zoom Out icon is present");
			blnFlag = true;
		}
		return blnFlag;
	}

	public Boolean verifyMapRotateLeft(){
		Boolean blnFlag = false;
		if(TestUtil.waitForElementPresence(mapRotateLeft, driver)){
			System.out.println("Rotate Left icon is present");
			blnFlag = true;
		}
		return blnFlag;
	}

	public Boolean verifyMapRotateRight(){
		Boolean blnFlag = false;
		if(TestUtil.waitForElementPresence(mapRotateRight, driver)){
			System.out.println("Rotate Right icon is present");
			blnFlag = true;
		}
		return blnFlag;
	}

	public Boolean verifyMapRecenter(){
		Boolean blnFlag = false;
		if(TestUtil.waitForElementPresence(mapRecentre, driver)){
			System.out.println("Map Recentre icon is present");
			blnFlag = true;
		}
		return blnFlag;
	}

	public Boolean verifyKeyLegends(){
		Boolean blnFlag = false;
		if(TestUtil.waitForElementPresence(legendsKey, driver)){
			System.out.println("Key Legends icon is present");
			blnFlag = true;
		}
		return blnFlag;
	}
	
	public void getAttributeValue(){
		WebElement element =driver.findElement(By.xpath("//div[@id ='FloorBasement-map']//div[@class = 'leaflet-pane leaflet-rotate-pane']"));
		String att =element.getAttribute("style");
		System.out.print(att);
		}
}
