package orangehrm_BaseMethods;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import Orangehrm_Utils.utils_Method;
import orangehrm_Pages.AdminPage;
import orangehrm_Pages.Login_Page;

public class BaseMethods extends utils_Method{
	
	@BeforeSuite
	public void prerequisites() throws Exception
	{
		property_file();
		pageobject();
		sparkReport();
	}
	
	@BeforeMethod
	public void browser() throws Exception
	{
		test=extent.createTest("Login Page");
		browser_launch(browser);
	 lp=new Login_Page();
	 ap=new AdminPage();
		lp.login();
		
	}
	@AfterMethod
	public void aftertest()
	{
		driver.close();
		extent.flush();
	}
	
	

}
