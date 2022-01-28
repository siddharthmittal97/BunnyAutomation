package factory;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class BrowserFactory 
{	
	// static method can acess only static data so we need to declare WebDriver driver as static
	static WebDriver driver;
	public static WebDriver getBrowser(String browserName)
	{
		if (browserName.equalsIgnoreCase("chrome")) 
		{
			ChromeOptions ops = new ChromeOptions();
            ops.addArguments("--disable-notifications");
    		System.setProperty("webdriver.chrome.driver",DataProviderFactory.Config().getChromePath());
    		// Now Line 17 would just launch a chrome browser
    		driver = new ChromeDriver(ops);
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
}
