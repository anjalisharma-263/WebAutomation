package com.purpleAdmin.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.purpleAdmin.qa.base.TestBase;
import com.purpleAdmin.qa.util.TestUtil;

public class WebHamburgerPage extends TestBase {
	// Page Factory - OR:

	@FindBy(xpath = "(//ion-menu-button)[2]")
	WebElement hambugerTag;

	@FindBy(xpath = "//span[@class='menuBackArrow']")
	WebElement closeHamburger;

	@FindBy(xpath = "//span[contains(text(),'Clear Route')]")
	WebElement clearRoute;

	@FindBy(xpath = "//span[contains(text(),'App Overview')]")
	WebElement appOverview;

	@FindBy(xpath = "//span[contains(text(),'Privacy Policy')]")
	WebElement privacyPolicy;

	@FindBy(xpath = "//button[@class = 'privacyCross']")
	WebElement PPolicyCrossIcon;

	@FindBy(xpath = "(//p//strong)[37]")
	WebElement endOfPPolicy;

	@FindBy(xpath = "//span[contains(text(),' FAQs')]")
	WebElement fAQs;

	@FindBy(xpath = "//span[contains(text(),'End User License Agreement (EULA)')]")
	WebElement clickEULAFromHamburger;

	@FindBy(xpath = "//strong[contains(text(), 'END USER SOFTWARE LICENSE AGREEMENT')]")
	WebElement EULAText;

	@FindBy(xpath = "//button[@class = 'crossIcon eulaCross']")
	WebElement EULACrossIcon;

	@FindBy(xpath = "(//p//strong)[16]")
	WebElement endOfEULA;

	@FindBy(xpath = "//span[contains(text(), 'LJ PRIVACY AND SECURITY POLICY')]")
	WebElement privacyPolicyText;

	@FindBy(xpath = "//button[@class = 'forwardIcon']")
	public WebElement SkipTutForwardIcon;

	@FindBy(xpath = "//button[@class = 'backIcon']")
	public WebElement SkipTutBackwardIcon;

	@FindBy(xpath = "(//img[@class = 'webImg'])[1]")
	public WebElement SkipTutImg1;

	@FindBy(xpath = "(//img[@class = 'webImg'])[2]")
	public WebElement SkipTutImg2;

	@FindBy(xpath = "(//img[@class = 'webImg'])[3]")
	public WebElement SkipTutImg3;

	@FindBy(xpath = "(//img[@class = 'webImg'])[4]")
	public WebElement SkipTutImg4;

	@FindBy(xpath = "//span[contains(text(),'Submit Feedback')]")
	WebElement submitFeedback;
	Boolean  isAppOverViewForwardIconDispalyed = false;

	//Initializing the Page objects
	public WebHamburgerPage(){
		PageFactory.initElements(driver, this);
	}

	public void clickCloseHamburger(){
		if(TestUtil.waitForElementPresence(closeHamburger, driver)){
			closeHamburger.click();
		}
	}

	public void clickHamburger(String browserName){
		if(browserName.equals("Chrome")){
			if(TestUtil.waitForElementPresence(hambugerTag, driver)){
				WebElement shadowRoot1 = TestUtil.expandRootElement(hambugerTag);
				shadowRoot1.findElement(By.cssSelector("button[type=button]")).click();;
			}
		}
		if(browserName.equals("FF") || browserName.equals("Edge") || browserName.equals("IE")){
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", hambugerTag);
		}
		if(browserName.equals("Safari")){
			if(TestUtil.waitForElementPresence(hambugerTag, driver)){
				hambugerTag.click();
			}
		}
	}

	public void clickClearRoute(){
		if(TestUtil.waitForElementPresence(clearRoute, driver)){
			clearRoute.click();
		}
	}

	public void clickPrivacyPolicy(){
		try {
			Thread.sleep(5000);
			if(TestUtil.waitForElementPresence(privacyPolicy, driver)){
				privacyPolicy.click();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Boolean isPrivacyPolicyLoaded(){
		Boolean blnFlag = false;
		if(TestUtil.waitForElementPresence(privacyPolicyText, driver)){
			blnFlag = true;
		}
		return blnFlag;
	}

	public void scrolldownPrivacyPolicy(){
		Boolean blnFlag = false;
		TestUtil.scrollByVisibleElement(endOfPPolicy);
	}

	public Boolean clickClosePPolicy(){
		Boolean blnFlag = false;
		if(TestUtil.waitForElementPresence(PPolicyCrossIcon, driver)){
			PPolicyCrossIcon.click();
			blnFlag = true;
		}
		return blnFlag;
	}


	public void clickEULAFromHamburger(){
		try {
			Thread.sleep(5000);
			if(TestUtil.waitForElementPresence(clickEULAFromHamburger, driver)){
				clickEULAFromHamburger.click();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void scrolldownEULA(){
		TestUtil.scrollByVisibleElement(endOfEULA);
	}

	public Boolean clickCloseEULAIcon(){
		Boolean blnFlag = false;
		if(TestUtil.waitForElementPresence(EULACrossIcon, driver)){
			EULACrossIcon.click();
			blnFlag = true;
		}
		return blnFlag;
	}

	public Boolean isEULALoaded(){
		Boolean blnFlag = false;
		if(TestUtil.waitForElementPresence(EULAText, driver)){
			blnFlag = true;
		}
		return blnFlag;
	}

	public void clickAppOverview(){
		if(TestUtil.waitForElementPresence(appOverview, driver)){
			appOverview.click();
		}
	}

	public Boolean isAppOverviewForwardIconPresent(){
		for(int i=0; i<3;i++){
			if(TestUtil.waitForElementPresence(SkipTutForwardIcon, driver)){
				isAppOverViewForwardIconDispalyed = true;
				SkipTutForwardIcon.click();
			}
			else{
				System.out.println("Forward icon is not present");
			}
		}
		return isAppOverViewForwardIconDispalyed;

	}
	public Boolean isAppOverviewImagePresent(){
		Boolean isAppOverViewImagesDispalyed = false;
		for(int j=0; j<3;j++){
			if(TestUtil.waitForElementPresence(SkipTutBackwardIcon, driver)){
				SkipTutBackwardIcon.click();
			}
		} 
		if(isAppOverViewForwardIconDispalyed){
			isAppOverViewImagesDispalyed =	AppOverviewListaWebElement(SkipTutImg1, SkipTutImg2, SkipTutImg3, SkipTutImg4, SkipTutForwardIcon, driver);
		}
		else{
			System.out.println("Forward icon is not present");
		}
		return isAppOverViewImagesDispalyed;
	}

	public boolean AppOverviewListaWebElement(WebElement img1,WebElement img2,WebElement img3,WebElement img4, WebElement forwardIcon,WebDriver driver){
		Boolean blnFlag = false;
		int count = 0;
		List<WebElement> imgList = new ArrayList<WebElement>();
		imgList.add(SkipTutImg1);
		imgList.add(SkipTutImg2);
		imgList.add(SkipTutImg3);
		imgList.add(SkipTutImg4);
		for(WebElement img:imgList){
			if(TestUtil.waitForElementPresence(img, driver)){
				count++;
			}
			SkipTutForwardIcon.click();
		}
		if(count<3){
			System.out.println("All Skip tutorial images is not present");
		}
		else{
			System.out.println("All Skip tutorial images are present");
			blnFlag = true;
		}
		return blnFlag;
	}

	public void clickSubmitFeedback(){
		if(TestUtil.waitForElementPresence(submitFeedback, driver)){
			submitFeedback.click();
		}
	}

	public void clickfAQs(){
		if(TestUtil.waitForElementPresence(fAQs, driver)){
			fAQs.click();
		}
	}
}
