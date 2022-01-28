package LoginSF;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.pages.LoginSf;
import factory.BrowserFactory;
import factory.DataProviderFactory;
public class LoginSalesforce 
{
	WebDriver driver;
	@BeforeMethod
	public void setUP() 
	{
		// we are directly calling a method so BrowserFactory will be static method
		driver = BrowserFactory.getBrowser("chrome");
		String url1 = DataProviderFactory.Config().getSalesforceUrl(); 
		System.out.println("debug++++++++++++"+   url1);
		driver.get(DataProviderFactory.Config().getSalesforceUrl());
	}
	@Test()
	public void Testing()
	{
		String a = DataProviderFactory.Excel().getData(0, 1, 0);
        System.out.println(a);
        String b = DataProviderFactory.Excel().getData(0, 1, 1);
        System.out.println(b);
        //USING PAGE FACTORY MODEL
        LoginSf Lg = PageFactory.initElements(driver, LoginSf.class);
		Lg.LoginParameter(DataProviderFactory.Excel().getData(0, 1, 0),
				DataProviderFactory.Excel().getData(0, 1, 1));
	}
	@AfterTest()
	public void Tear()
	{
	driver.close();	
	}
}
