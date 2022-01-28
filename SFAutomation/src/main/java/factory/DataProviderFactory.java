package factory;
import dataprovider.ConfigDataProvider;
import dataprovider.ExcelDataProvider;
public class DataProviderFactory 
{
	
//Method 1
// Method is static so that It is can directly acess without creating an Object	
public static ConfigDataProvider Config()
  {
	ConfigDataProvider config = new ConfigDataProvider();
	return config;
  }
public static ExcelDataProvider Excel()
  {
	ExcelDataProvider excel = new ExcelDataProvider();
	return excel;
  }
}
