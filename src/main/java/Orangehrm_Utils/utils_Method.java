package Orangehrm_Utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import orangehrm_Pages.AdminPage;
import orangehrm_Pages.Emplist_menu;
import orangehrm_Pages.Login_Page;
import orangehrm_Pages.PIM_addemp;
import orangehrm_Pages.Personal_details;

public class utils_Method {

	public static WebDriver driver;
	public static String homedir;
	public static Properties prop;
	public static String browser, url, username, pass;
	public static ExtentSparkReporter spark;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static AdminPage ap;
	public static Login_Page lp;
	public static PIM_addemp pm;
	public static Emplist_menu em;
	public static Personal_details pd;
	public static WebDriverWait wait;
	// driver module

	public WebDriver browser_launch(String brows) {
		WebDriverManager.chromedriver().setup();
		switch (brows) {
		case "chrome":
			driver = new ChromeDriver();
			driver.get(url);

			break;
		case "firefox":
			driver = new FirefoxDriver();
			driver.get(url);
			break;
		case "safari":
			driver = new SafariDriver();
			driver.get(url);
			break;
		default:
			driver = new ChromeDriver();
			driver.get(url);
			break;
		}
		driver.manage().window().maximize();
		return driver;

	}

	// property file module

	public void property_file() throws Exception {
		prop = new Properties();
		homedir = System.getProperty("user.dir");
		// System.out.println(homedir);
		String path = homedir + "\\Orangehrm.properties";
		// System.out.println(path);
		FileInputStream fin = new FileInputStream(path);

		prop.load(fin);

		url = prop.getProperty("url");
		username = prop.getProperty("username");
		pass = prop.getProperty("password");
		browser = prop.getProperty("browser");
		

	}
	


	public void pageobject() {

		ap = new AdminPage();
		lp = new Login_Page();
		pm=new PIM_addemp();
		em=new Emplist_menu();
	 pd=new Personal_details();
	
	}

	// Report Module
	public void sparkReport() {
		spark = new ExtentSparkReporter("OrangeHrm.html");
		extent = new ExtentReports();
		extent.attachReporter(spark);
	}

	// screenshot module
	public String screenshot(String id) throws Exception {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(homedir + "/Screenshots/" + id + ".png");
		String path = homedir + "/Screenshots/" + id + ".png";
		FileUtils.copyFile(src, dest);
		return path;

	}

	// textbox input
	public void input_text(WebElement element, String id) {
		
		try {
			waitamoment();
			Assert.assertTrue(element.isDisplayed());
			//clear(element);
			if(element.getAttribute("value").equals(""))
			{
			element.sendKeys(id);
			test.log(Status.PASS, id + " entered");
			}
			else
			{
				clearmenu(element, id);
			}

		} catch (Exception e) {
			test.log(Status.FAIL, id + " not dispalyed and  entered");
		}

	}

	// submit button
	public void click_button(WebElement element, String id)

	{
		try {
			waitamoment();
			Assert.assertTrue(element.isDisplayed());
			element.click();
			test.log(Status.PASS, id + "  button clicked");
		} catch (Exception e) {
			test.log(Status.FAIL, id + " not dispalyed and clicked");
		}

	}

	// isDisplayed
	public boolean displayed(WebElement element, String id) throws Exception {
		// waitamoment();

		try {

			Assert.assertTrue(element.isDisplayed());
			// Thread.sleep(2000);
			test.log(Status.PASS, id + " is displayed");
			return true;
		} catch (Exception e) {
			test.log(Status.FAIL, id + " is not displayed");
			test.log(Status.INFO, e);
			test.addScreenCaptureFromPath(screenshot(id));
			return false;
		}

	}

	public void waitamoment() {
		driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
	}
	// explicit wait module

		public void Expwait(WebElement element) {
			wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}

	

	public void clear(WebElement element) throws InterruptedException {
	//Thread.sleep(2000);
		while (!element.getAttribute("value").equals("")) {
			Thread.sleep(2000);
			element.sendKeys(Keys.BACK_SPACE);
		}
	}
	
	public void clearmenu(WebElement element,String value) {
		Actions act = new Actions(driver);
		
		while (!element.getAttribute("value").equals("")) {
		
		Expwait(element);
		act.doubleClick(element).build().perform();
	
		//element.sendKeys(Keys.BACK_SPACE);
		act.sendKeys(Keys.DELETE).build().perform();
		}
		act.sendKeys(value).build().perform();
	
	
	}
	
	public void dropdown(WebElement element,String id) throws Exception
	{
		waitamoment();
		Robot robot=new Robot();
		try {
		while(!(element.getText().equals(id)))
				{
			robot.delay(300);
		robot.keyPress(KeyEvent.VK_DOWN);
				}
		robot.keyRelease(KeyEvent.VK_DOWN);

		// robot.keyPress(KeyEvent.VK_ENTER);
		// robot.keyRelease(KeyEvent.VK_ENTER);
		// robot.delay(200);
		 //robot.keyPress(KeyEvent.VK_ENTER);
		// robot.keyRelease(KeyEvent.VK_ENTER);
		element.click();
		
		test.log(Status.PASS, id +"dropdown clicked");
		
		}
		catch(Exception e){
			test.addScreenCaptureFromPath(screenshot(id));
			test.log(Status.FAIL, id +"dropdown not clicked");
			
		}
	}
	
	public void menu_available(List<WebElement> elements) throws Exception {
		for(int i=0;i<elements.size();i++)
		{
		
			String name=elements.get(i).getText();
			displayed(elements.get(i), name);
		}

	}
	
	public void password_check(WebElement element,WebElement errormsg) throws InterruptedException
	{
		waitamoment();
		if(element.isSelected()==true) {
			System.out.println("password check");
			clear(element);
			input_text(element, "Remona11$");
	}
	}
		
		public void valuedisplay(WebElement element,String id)
		{
			try {
				Thread.sleep(2000);
				String expected=element.getAttribute("value");
				
 Assert.assertEquals(expected, id);
 test.log(Status.PASS,id +"displayed");
		}
			catch(Exception e)
			{
				test.log(Status.FAIL, e);
			}
		}
		
		public void list(String name,String id) throws Exception
		{
			Thread.sleep(2000);
			ap.getAdmin().click();
			pm=new PIM_addemp();
			click_button(pm.getPIM(), "PIM");
			Thread.sleep(2000);
			input_text(pm.getNametosearch(),name);
			input_text(pm.getEnterid(),id);
			click_button(pm.getInclude(), "include");
			WebElement include_text = driver.findElement(
					By.xpath("(//div[@class='oxd-select-wrapper']//child::div[@class='oxd-select-text-input'])[2]"));
			Robot robot = new Robot();
			while (include_text.getText().equalsIgnoreCase("Current and Past Employees") == false) {
				robot.delay(300);
				robot.keyPress(KeyEvent.VK_DOWN);
			}
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			click_button(pm.getSearch(), "SEARCH");
			click_button(pm.getRecordtick(), "record ticked");
			click_button(pm.getEdit(), "edit option");
			
			//click_button(pm.getJob(), "job");
			//noRecord(noRecord);
			//Thread.sleep(2000);
			/*try {
				Thread.sleep(2000);
				Assert.assertTrue(pm.getNoRecord().getText().equals("No Records Found"));
				test.log(Status.PASS, "no record found");
				test.addScreenCaptureFromPath(screenshot("norecord"), "norecord");
			}
			catch (Exception e) {
			
				click_button(pm.getRecordtick(), "record ticked");
				click_button(pm.getEdit(), "edit option");
				
				click_button(pm.getJob(), "job");
				Thread.sleep(2000);
		}*/
		
		
		}	
		
}
