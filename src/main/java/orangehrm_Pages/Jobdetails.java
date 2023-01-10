package orangehrm_Pages;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import Orangehrm_Utils.utils_Method;

public class Jobdetails extends utils_Method {
	
	@FindBy(linkText="Job")
	WebElement Job;
	
	@FindBy(xpath="//input[@placeholder='yyyy-mm-dd'][1]")
	WebElement joineddate;
	
	@FindBy(xpath="(//div[@class='oxd-select-text oxd-select-text--active'])[1]")
	WebElement jobtitle;
	
	@FindBy(xpath="//div[@class='oxd-select-text oxd-select-text--focus']//div")
	WebElement QA;
	
	@FindBy(xpath="(//div[@class='oxd-select-text oxd-select-text--active'])[2]")
	WebElement jobcategory;
	
	@FindBy(xpath="//div[@class='oxd-select-text oxd-select-text--focus']//div")
	WebElement categ;
	
	@FindBy(xpath="(//div[@class='oxd-select-text oxd-select-text--active'])[3]")
	WebElement subunit;
	
	@FindBy(xpath="//div[@class='oxd-select-text oxd-select-text--focus']//div")
	WebElement sunit;
	
	@FindBy(xpath="(//div[@class='oxd-select-text oxd-select-text--active'])[4]")
	WebElement location;
	
	@FindBy(xpath="//div[@class='oxd-select-text oxd-select-text--focus']//div")
	WebElement loc;
	
	@FindBy(xpath="(//div[@class='oxd-select-text oxd-select-text--active'])[5]")
	WebElement empstatus;
	
	@FindBy(xpath="//div[@class='oxd-select-text oxd-select-text--focus']//div")
	WebElement status;
	
	@FindBy(xpath="//span[@class='oxd-switch-input oxd-switch-input--active --label-right']")
	WebElement toggle;
	
	
	@FindBy(xpath="(//input[@placeholder='yyyy-mm-dd'])[2]")
	WebElement startdate;
	
	@FindBy(xpath="(//input[@placeholder='yyyy-mm-dd'])[3]")
	WebElement enddate;
	
	@FindBy(xpath="//div[text()='Browse']")
	WebElement browse;
	
	@FindBy(xpath="//button[text()=' Save ']")
	WebElement save1;
	
	
	public Jobdetails()
	{
PageFactory.initElements(driver, this);	
}
	
	public void job_details(String name,String id) throws Exception {
		try {
		list(name,id);
		click_button(Job, "Job Menu");
		input_text(joineddate, "2012-03-03");
		Thread.sleep(2000);
		
		jobtitle.click();
		dropdown(QA, "QA Engineer");
		
		jobcategory.click();
		dropdown(categ, "Professionals");
		
		subunit.click();
		dropdown(sunit, "Quality Assurance");
		
		location.click();
		dropdown(loc, "Texas R&D");
		
		empstatus.click();
		dropdown(status, "Full-Time Contract");
		
		click_button(toggle, "toggle");
		input_text(startdate, "2012-03-03");
		input_text(enddate, "2023-03-03");
		Thread.sleep(5000);
		
		Assert.assertTrue(save1.isDisplayed());
		Assert.assertTrue(save1.isEnabled());
		save1.click();
		//click_button(save1, "save");
		Thread.sleep(2000);
		test.log(Status.PASS, "Job details add");
		test.addScreenCaptureFromPath(screenshot("Job details add"));
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "Job details add");
			test.addScreenCaptureFromPath(screenshot("Job details add"));		
		}
	
		
		
		
	}

	public WebElement getJob() {
		return Job;
	}

}
