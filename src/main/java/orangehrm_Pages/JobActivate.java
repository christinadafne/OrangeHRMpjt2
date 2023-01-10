package orangehrm_Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import Orangehrm_Utils.utils_Method;

public class JobActivate extends utils_Method{
	@FindBy(xpath="//button[text()=' Activate Employment ']")
	WebElement activate;
	
	@FindBy(xpath="//button[text()=' Terminate Employment ']")
	WebElement term;
	
	@FindBy(xpath="//h6[text()='Job Details']")
	WebElement jobdetails;
	
	
	public JobActivate() {
PageFactory.initElements(driver, this);	

}
public void act_emp(String name,String id) throws Exception

{
	list(name,id);
	Jobdetails jo=new Jobdetails();
	click_button(jo.getJob(), "Job Menu");
	/*
	 * Thread.sleep(2000); Jobterminate jt=new Jobterminate();
	 * jt.termination(name,id);
	 */
	
	click_button(activate, "activate Employment");
	try {
		displayed(jobdetails, "jobdetails");

		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("scroll(0,250);");
		
	displayed(term, "Terminate Employment");
	test.log(Status.PASS, "Employee Activated");
	test.addScreenCaptureFromPath(screenshot("job activate"));
	}
	catch(Exception e) {
		test.log(Status.FAIL, "Employee not  Activated");
		test.addScreenCaptureFromPath(screenshot("job activate"));
	}
	
}
}