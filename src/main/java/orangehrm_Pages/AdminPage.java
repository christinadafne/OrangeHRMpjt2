package orangehrm_Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.apache.commons.compress.archivers.sevenz.CLI;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import Orangehrm_Utils.utils_Method;

public class AdminPage extends utils_Method {
	int count, m;

	@FindBy(xpath = "//div[@class='oxd-main-menu-search']//input")
	WebElement search;

	@FindBy(linkText = "Admin")
	WebElement AdminMenu;

	public WebElement getAdmin() {
		return AdminMenu;
	}

	@FindBy(linkText = "PIM")
	WebElement PIM;

	@FindBy(linkText = "Leave")
	WebElement Leave;

	@FindBy(linkText = "Time")
	WebElement Time;

	@FindBy(linkText = "Recruitment")
	WebElement Recruitment;

	@FindBy(linkText = "My Info")
	WebElement MyInfo;

	@FindBy(linkText = "Performance")
	WebElement Performance;

	@FindBy(linkText = "Dashboard")
	WebElement Dashboard;

	@FindBy(linkText = "Directory")
	WebElement Directory;

	@FindBy(linkText = "Maintenance")
	WebElement Maintenance;

	@FindBy(linkText = "Buzz")
	WebElement Buzz;
	
	@FindBy(xpath="//span[text()='User Management ']")
	WebElement usermgmt;
	
	@FindBy(xpath="//ul[@class='oxd-dropdown-menu']//a[text()='Users']")
	WebElement users;
	
	@FindBy(xpath="//div[@class='oxd-select-wrapper']//div//div[text()='-- Select --']")
	WebElement searchbox;
	
	@FindBy(xpath="//div[@class='oxd-select-wrapper']//div//div[text()='Admin']")
	WebElement searchESS;
	
	@FindBy(xpath="//div[@class='oxd-select-wrapper']//div//div[text()='Enabled']")
	WebElement searchDisable;
	
	@FindBy(xpath="//div[@class='oxd-select-wrapper']//div//div")
	WebElement userRole;
	
	
	@FindBy(xpath="(//div[@class='oxd-select-wrapper'])[2]//div//div")
	WebElement status;

	public AdminPage() {
		PageFactory.initElements(driver, this);

	}

	public void search() throws Exception

	{
		try {
		waitamoment();

		click_button(AdminMenu, "Admin menu");
		displayed(search, "search textbox");
		click_button(search, "search ");

		input_text(search, "admin");
		displayed(AdminMenu, "Admin after search");

		clearmenu(search,"ADMIN");
		displayed(AdminMenu, "ADMIN after search");

		clearmenu(search,"PIM");
		displayed(PIM, "PIM after search");
		
		clearmenu(search,"pim");
		
		displayed(PIM, "pim after search");
		clearmenu(search,"leave");
		
		
		displayed(Leave, "leave after search");

		clearmenu(search,"LEAVE");
		
		
		displayed(Leave, "LEAVE after search");
		clearmenu(search,"time");
		
		
		displayed(Time, "time after search");
		clearmenu(search,"TIME");

		
		displayed(Time, "TIME after search");
		clearmenu(search,"recruitment");

		
		displayed(Recruitment, "recruitment after search");
		clearmenu(search,"RECRUITMENT");

		displayed(Recruitment, "RECRUITMENT after search");
		clearmenu(search,"my info");

		displayed(MyInfo, "my info after search");
		clearmenu(search,"MY INFO");

		displayed(MyInfo, "MY INFO after search");
		clearmenu(search,"performance");

		displayed(Performance, "performance after search");
		clearmenu(search,"PERFORMANCE");

		displayed(Performance, "PERFORMANCE after search");
		clearmenu(search,"dashboard");
		
		displayed(search, "dashboard after search");
		clearmenu(search,"DASHBOARD");
		
		displayed(search, "DASHBOARD after search");
		clearmenu(search,"directory");

		displayed(Directory, "directory after search");
		clearmenu(search,"DIRECTORY");

		displayed(Directory, "DIRECTOR after search");
		clearmenu(search,"maintenance");

		displayed(Maintenance, "maintenance after search");
		clearmenu(search,"MAINTENANCE");

		displayed(Maintenance, "MAINTENANCE after search");
		clearmenu(search,"buzz");

		displayed(Buzz, "buzz after search");
		clearmenu(search,"BUZZ");
		
		displayed(Buzz, "BUZZ after search");
		test.log(Status.PASS, "Search menu");
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "Search menu");
		}
	}
	public void usermanagement() throws Exception 
	{
		try {
		waitamoment();
		click_button(AdminMenu, "Admin");
		displayed(PIM, "PIM");
		displayed(Leave, "LEAVE");
		displayed(Time, "Time");
		displayed(Recruitment, "recruitment");
		click_button(usermgmt, "usermanagement");
		click_button(users, "users");
		click_button(searchbox, "user role");
		dropdown(userRole,"Admin");
		click_button(searchbox, "status");
		dropdown(status,"Enabled");
		Thread.sleep(1000);
	test.addScreenCaptureFromPath(screenshot("admin-enabled"));
		click_button(searchESS, "user role");
		dropdown(userRole,"ESS");
		click_button(searchDisable, "status");
		dropdown(status,"Disabled");
		test.addScreenCaptureFromPath(screenshot("ESS-disabled"));
		test.log(Status.PASS, "user administration");
		
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "user administration");
			test.addScreenCaptureFromPath(screenshot("usermanagement"));
		}
	}
	
	}	
	


