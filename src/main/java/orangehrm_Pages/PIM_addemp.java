package orangehrm_Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import Orangehrm_Utils.utils_Method;

public class PIM_addemp extends utils_Method{
	public static Actions act;
	public static String empid;
	
	@FindBy(linkText="PIM")
	WebElement PIM;
	
	@FindBy(xpath = "//a[text()='Employee List']")
	WebElement list;
	
	public WebElement getList() {
		return list;
	}
	@FindBy(xpath = "//div[text()='Current Employees Only']")
	WebElement include;

	public WebElement getInclude() {
		return include;
	}
	
	@FindBy(xpath = "//span[text()='No Records Found']")
	WebElement noRecord;
	
	public WebElement getNoRecord() {
		return noRecord;
	}
	@FindBy(xpath = "//button[@type='submit']")
	WebElement search;
	
	public WebElement getSearch() {
		return search;
	}
	@FindBy(xpath = "//div[@class='oxd-table-body']//span")
	WebElement recordtick;
	
	public WebElement getRecordtick() {
		return recordtick;
	}
	
	@FindBy(xpath="(//input[@placeholder='Type for hints...'])[1]")
	WebElement nametosearch;
	
	public WebElement getNametosearch() {
		return nametosearch;
	}
	@FindBy(xpath = "//label[text()='Employee Id']//following::input[1]")
	WebElement enterid;
	
	public WebElement getEnterid() {
		return enterid;
	}
	@FindBy(xpath = "//i[@class='oxd-icon bi-pencil-fill']")
	WebElement edit;

	@FindBy(xpath = "//*[text()='Job']")
	WebElement job;
	
	
	public WebElement getEdit() {
		return edit;
	}

	public WebElement getJob() {
		return job;
	}
	@FindBys(@FindBy(xpath="//ul[@class='oxd-main-menu']//li//span"))
	List<WebElement> menu;
	
	@FindBy(xpath="//i[@class='oxd-icon bi-plus oxd-button-icon']")
	WebElement add;
	
	@FindBy(name="firstName")
	WebElement firstname;
	
	@FindBy(name="lastName")
	WebElement lastname;
	

	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[2]")
	WebElement emp; 
	
	@FindBy(xpath="//input[@class='oxd-input oxd-input--focus']")
	WebElement emp_id;
	
	@FindBy(xpath="//div[@class='oxd-switch-wrapper']//child::input")
	WebElement toggle;
	
	public WebElement getEmp_id() {
		return emp_id;
	}

	@FindBy(xpath="//label[text()='Username']//following::div//input[@class='oxd-input oxd-input--active'][1]")
	WebElement username;
	
	@FindBy(xpath="//input[@type='password'][1]")
	WebElement password;
	
	@FindBy(xpath="//input[@class='oxd-input oxd-input--active oxd-input--error' and @type='password']")
	WebElement errpassw;
	
	@FindBy(xpath="//input[@class='oxd-input oxd-input--active oxd-input--error' and @type='password']//following::span")
	WebElement errmsg;
	
	@FindBy(xpath="//div//label[contains(text(),'Confirm Password')]//following::input[@type='password']")
	WebElement confirmpass;
	
	@FindBy(xpath="//input[@value='1']")
	WebElement enabled;
	
	@FindBy(xpath="//button[@type='submit' ]")
	WebElement save;
	
	@FindBy(xpath="//a[text()='Employee List']")
	WebElement emplist;
	
	
	
	public PIM_addemp() {
		
		PageFactory.initElements(driver, this);
	}
	
	public void addemp(String userNAME,String id) throws Exception {
		try {
		empid=id;
		waitamoment();
		ap.getAdmin().click();
		//Thread.sleep(2000);
		click_button(PIM, "PIM menu");


		click_button(add, "+ add");
		input_text(firstname, userNAME);
		input_text(lastname, "king");
		emp.click();
		clear(emp_id);
		input_text(emp_id, id);
		//Expwait(toggle);
		Thread.sleep(2000);
		if(toggle.isEnabled()) {
			//System.out.println("toggle");
			 act=new Actions(driver);
		act.moveToElement(toggle).click().build().perform();
		test.log(Status.PASS, "toggle clicked");
		}
	input_text(username, userNAME);
	
	input_text(password,"Remona11#");
	System.out.println("password"+password.getAttribute("value"));
	Expwait(confirmpass);
	input_text(confirmpass,"Remona11#");
	System.out.println("confirmpassword"+confirmpass.getAttribute("value"));
	//Expwait(enabled);
	Thread.sleep(2000);
	if(enabled.isEnabled())
	{
		 act=new Actions(driver);
		act.moveToElement(enabled).click().build().perform();
	}
		act.click(save).build().perform();
		Assert.assertTrue(emplist.isDisplayed());
		test.log(Status.PASS, "employee added & list displayed");
		test.addScreenCaptureFromPath("employee list displayed");
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "employee list not  displayed");
			test.addScreenCaptureFromPath("employee list displayed");
		}
	

}

	public WebElement getFirstname() {
		return firstname;
	}

	public WebElement getPIM() {
		return PIM;
	}
}
