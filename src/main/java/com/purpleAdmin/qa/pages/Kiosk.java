package com.purpleAdmin.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.purpleAdmin.qa.util.TestUtil;

import com.purpleAdmin.qa.base.TestBase;

public class Kiosk extends TestBase {
	// Page Factory - OR:

	
	@FindBy(xpath = "//button[contains(text(),'Touch Here To Begin')]")
	WebElement BeginBtn;
	@FindBy(xpath = "//button[@class='closeVideoIntro']")
	WebElement SkipIntro;
	
	@FindBy(xpath = "//h3[contains(text(),'Main Menu')]")
	WebElement MainMenu;
	
//	@FindBy(xpath = "//*[@id='Art']")
//	WebElement mapFloor;
	
	@FindBy(xpath = "//*[name()='div' and contains(@class,'floorName')]")
	WebElement mapFloor;
	
	@FindBy(xpath = " 	")
	WebElement directoryWithSplash;
	@FindBy(xpath = "//*[@class = 'main-nav row'][1]")
	WebElement directoryWithoutSplash;


	// Initializing the Page Objects:
	public Kiosk() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public void clickBeginBtn() {
		System.out.println("-----------------"+BeginBtn);
		if(TestUtil.waitForElementPresence(BeginBtn,driver)){
			BeginBtn.click();
			
		}
	}
	public String getTitleMainMenu(){
		String title = "";
		if(TestUtil.waitForElementPresence(MainMenu, driver)){
			title = MainMenu.getText();
		}
		return title;
	}
	
	public void clickSkipIntro() {
		System.out.println("-----------------"+SkipIntro);
		if(TestUtil.waitForElementPresence(SkipIntro,driver)){
			SkipIntro.click();
			
		}
	}
	
	public  Boolean getMapFloor(){
		Boolean blnFlag = false;
		blnFlag = TestUtil.waitForElementPresence(mapFloor, driver);
		return blnFlag;
	}
	public  Boolean getDirectoryWithSplash(){
		Boolean blnFlag = false;
		blnFlag = TestUtil.waitForElementPresence(directoryWithSplash, driver);
		return blnFlag;
	}
	public  Boolean getDirectoryWithoutSplash(){
		Boolean blnFlag = false;
		blnFlag = TestUtil.waitForElementPresence(directoryWithoutSplash, driver);
		return blnFlag;
	}
}