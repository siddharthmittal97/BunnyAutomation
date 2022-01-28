package com.pages;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import com.util.SyncElement;
public class LeadCreation 
{  
	SoftAssert ass= new SoftAssert();
	
	public LeadCreation(WebDriver driver)
	{
		this .driver = driver;
 	}
	WebDriver driver;
	@FindBy(xpath="//input[@name='salutation']")
	List<WebElement> Lsalutation;
	
	@FindBy(xpath="//input[@name='firstName']")
	WebElement Fname;
	
	@FindBy(xpath="//input[@name='lastName']")
	WebElement Lname;
	
	@FindBy(xpath="//input[@name='Company']")
	WebElement LComp;
	
	@FindBy(xpath="//input[@name='Title']")
	WebElement Ltitle;
	
	@FindBy(xpath="//input[@name='Email']")
	WebElement Lemail;
	
	@FindBy(xpath="//label[text()='Lead Source']/..//input")
	WebElement Leadsource;
	
	@FindBy(xpath="//button[@name='SaveEdit']")
	WebElement savebtn;
	
	@FindBy(xpath="//lightning-formatted-text[@data-output-element-id='output-field'][normalize-space()='wwwwww']")
	WebElement VerifyCompany;
	
	@FindBy(xpath="//a[@id='detailTab__item']")
	WebElement ClickDetail;
	
	@FindBy(xpath="//emailui-formatted-email-lead[@data-output-element-id='output-field']//a[@class='emailuiFormattedEmail'][normalize-space()='wwwww@test.com']")
	WebElement VerifyEmail;
	
	@FindBy(xpath="//lightning-formatted-text[contains(text(),'Web')]")
	WebElement VerifySource;
		
	public void getSalutation(String Salut) throws InterruptedException
	 {
		  for(int i=0;i<Lsalutation.size();i++)
		{
		  String pickval=Lsalutation.get(i).getText();
		  System.out.println(pickval);
		  if(pickval.contains(Salut))
		  {
			Lsalutation.get(i).click();
		  }
	   }
		  Thread.sleep(2500);
	 }
	
	public void getfirstname(String Firstname) throws InterruptedException
	 {
		Fname.sendKeys(Firstname);
		Thread.sleep(3000);
	 }
	public void getlastname(String Lastname) throws InterruptedException
	 {
		Lname.sendKeys(Lastname);
		Thread.sleep(3000);
	 }
	public void getcompanyname(String company) throws InterruptedException
	 {
		LComp.sendKeys(company);
		Thread.sleep(3000);
	 }
	
	public void getEmail(String email) throws InterruptedException
	 {
		SyncElement.isElementPresnt(driver, Lemail, 30);
		Lemail.sendKeys(email+"\n");
		Thread.sleep(3000);
	 }
	
	public void getTitle(String title) throws InterruptedException
	 {
		SyncElement.isElementPresnt(driver, Ltitle, 30);
		Ltitle.sendKeys(title+"\n");
		Thread.sleep(3000);
	 }
	
	public void clickLeadSource()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Leadsource.click();
	}
	
	public WebElement getLeadSourceValues(String leadSourceTypes)
	{
		return driver.findElement(By.xpath("//label[text()='Lead Source']/..//span[contains(text(),'"+leadSourceTypes+"')]"));
	}
	public void clickLeadSourceType(String leadSourceTypes)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", getLeadSourceValues(leadSourceTypes));
		//getLeadSourceValues(leadSourceTypes).click();
	}
	
	public void getLeadSource(String Source) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(Leadsource));
		Leadsource.sendKeys(Source);
		Thread.sleep(3000);
	}
	
	public void savelead() throws InterruptedException
	 {
		 SyncElement.isElementPresnt(driver, savebtn, 30);
		 savebtn.click();
		 Thread.sleep(3000);
	 }	
	
	public String verifyCompany()
	{
		return VerifyCompany.getText();
	}
	
	public void ClickDetail()
	{
		ClickDetail.click();
	}
	
	public String verifyEmailAddress()
	{
		return VerifyEmail.getText();
	}
	
	public String verifyLeadSource()
	{
		return VerifySource.getText();
	}
}
