package com.pages;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
public class SfHomePage 
{
	public SfHomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	WebDriver driver;
	
	@FindBy(xpath="//div[@class='slds-icon-waffle']")
	WebElement AppLauncher;
	
	@FindBy(xpath="//input[@placeholder='Search apps and items...']")
	WebElement Searchbox;
	
	@FindBy(xpath="//div[@class='al-menu-dropdown-list']")
	List<WebElement> FetchAllItems;
	//We have used the whole List & storing in the List<WebElement>
	
	@FindBy(xpath = "//a[@title='Leads']")
	WebElement Leadsbtn;
	
	@FindBy(xpath = "//div[contains(text(),'New')]")
	WebElement NewLead;
	
	
	public void Appclick() throws InterruptedException
	{
		//SyncElement.TobeClickable(driver, AppLauncher, 20);
		Thread.sleep(2000);
		AppLauncher.click();
		Thread.sleep(2000);
	}
	public void LeadSerach() throws InterruptedException
	{
		Searchbox.sendKeys("Leads");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(3000);
	}
	public void LeadTab()
	{
		for(WebElement cap:FetchAllItems)
		{
			if(cap.getText().contains("Leads"))
			{
				cap.click();
			}
		}
	}
	
	public void verifyLeadtab()
	{
		boolean btn = Leadsbtn.isDisplayed();
		Assert.assertEquals(btn, true, "Button Not Present");
	}
	
	public void clickOnLeadtab() throws InterruptedException
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", NewLead);
		Thread.sleep(2000);
	}
}
