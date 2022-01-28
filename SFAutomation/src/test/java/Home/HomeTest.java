package Home;
import java.io.File;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.pages.LeadCreation;
import com.pages.LoginSf;
import com.pages.SfHomePage;
import com.util.Xls_Reader;
import factory.BrowserFactory;
import factory.DataProviderFactory;
public class HomeTest
{
	WebDriver driver;
	Properties pro;
	public String Testdata_sheet_path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator +
			 "java" + File.separator +"AppData" + File.separator +"AppData.xlsx";
	SoftAssert softassert = new SoftAssert();
	
	@BeforeMethod()
	public void Setup2() throws InterruptedException
	{
	driver= BrowserFactory.getBrowser("chrome");
	driver.get(DataProviderFactory.Config().getSalesforceUrl());
	        //USING PAGE FACTORY MODEL
	LoginSf Lg = PageFactory.initElements(driver, LoginSf.class);
	Lg.LoginParameter(DataProviderFactory.Excel().getData(0, 1, 0),DataProviderFactory.Excel().getData(0, 1, 1));		
	}
	
	@Test ()
	public void NavigatetoLead() throws Exception
	{
		SfHomePage sf = PageFactory.initElements(driver, SfHomePage.class);
		Xls_Reader reader = new Xls_Reader(Testdata_sheet_path);
		int rowCount = reader.getRowCount("Lead Data");
		System.out.println(rowCount);
		for (int rowNum = 2; rowNum <= rowCount; rowNum++) 
		{
			sf.Appclick();
			sf.LeadSerach();
			sf.LeadTab();
			Thread.sleep(1500);
			sf.verifyLeadtab();
			Thread.sleep(1500);
			sf.clickOnLeadtab();
			
			String LSalutation = reader.getCellData("Lead Data", "L_Salutation", rowNum);
			System.out.println("Debug"+LSalutation);
			String LFirstname = reader.getCellData("Lead Data", "First_name", rowNum);
			System.out.println("Debug"+LFirstname);
			String LLastName = reader.getCellData("Lead Data", "Last_name", rowNum);
			System.out.println("Debug"+LLastName);
			String LCompany = reader.getCellData("Lead Data", "L_Company", rowNum);
			System.out.println("Debug"+LCompany);
			String LTitle = reader.getCellData("Lead Data", "L_Title", rowNum);
			System.out.println("Debug"+LTitle);
			String LEmail = reader.getCellData("Lead Data", "L_email", rowNum);
			System.out.println("Debug"+LEmail);
			String LSource = reader.getCellData("Lead Data", "Lead_Source", rowNum);
			System.out.println("Debug"+LSource);
			
			LeadCreation obj = PageFactory.initElements(driver, LeadCreation.class);
			obj.getSalutation(LSalutation);
		    obj.getfirstname(LFirstname);
		    obj.getlastname(LLastName);
		    obj.getcompanyname(LCompany);
		    obj.getEmail(LEmail);
		    obj.clickLeadSource();
		    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		    obj.clickLeadSourceType(LSource);
		    obj.savelead();
		    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		    obj.ClickDetail();
		    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		    softassert.assertEquals(obj.verifyCompany(), LCompany,"Company Not Matched");
		    softassert.assertEquals(obj.verifyEmailAddress(), LEmail,"Email Not Matched");
		    softassert.assertEquals(obj.verifyLeadSource(), LSource,"Email Not Matched");
		}		     		    
     }
}
