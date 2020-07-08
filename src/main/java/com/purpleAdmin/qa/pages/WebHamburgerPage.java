package com.purpleAdmin.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
	public WebElement endOfPPolicy;

	@FindBy(xpath = "//span[contains(text(),' FAQs')]")
	WebElement fAQs;

	@FindBy(xpath = "//span[contains(text(),'End User License Agreement (EULA)')]")
	WebElement clickEULAFromHamburger;

	@FindBy(xpath = "//strong[contains(text(), 'END USER SOFTWARE LICENSE AGREEMENT')]")
	WebElement EULAText;

	@FindBy(xpath = "//button[@class = 'crossIcon eulaCross']")
	WebElement EULACrossIcon;

	@FindBy(xpath = "(//p//strong)[16]")
	public WebElement endOfEULA;


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
	public WebElement submitFeedback;


	Boolean blnFlag = false;

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
		if(TestUtil.waitForElementPresence(privacyPolicy, driver)){
			privacyPolicy.click();
		}
	}

	public Boolean isPrivacyPolicyLoaded(){
		if(TestUtil.waitForElementPresence(privacyPolicyText, driver)){
			blnFlag = true;
		}
		return blnFlag;
	}

	public Boolean clickClosePPolicy(){
		if(TestUtil.waitForElementPresence(PPolicyCrossIcon, driver)){
			PPolicyCrossIcon.click();
			blnFlag = true;
		}
		return blnFlag;
	}


	public void clickEULAFromHamburger(){
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(TestUtil.waitForElementPresence(clickEULAFromHamburger, driver)){
			clickEULAFromHamburger.click();
		}
	}

	public Boolean clickCloseEULAIcon(){
		if(TestUtil.waitForElementPresence(EULACrossIcon, driver)){
			EULACrossIcon.click();
			blnFlag = true;
		}
		return blnFlag;
	}

	public Boolean isEULALoaded(){
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
