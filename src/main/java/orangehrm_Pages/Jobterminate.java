package orangehrm_Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import Orangehrm_Utils.utils_Method;

public class Jobterminate extends utils_Method {

	@FindBy(xpath = "//button[text()=' Terminate Employment ']")
	WebElement terminate;
	
	@FindBy(xpath="(//form[@class='oxd-form'])[2]//input[@class='oxd-input oxd-input--active']")
	WebElement date;
	
	
	@FindBy(xpath="(//form[@class='oxd-form'])[2]//div[@class='oxd-select-text oxd-select-text--active']//div[text()='-- Select --']")
	WebElement reason;
	
	@FindBy(xpath="(//form[@class='oxd-form'])[2]//div[@class='oxd-select-wrapper']//div")
	WebElement resign;
	
	@FindBy(xpath="//div[@class='oxd-select-text oxd-select-text--active oxd-select-text--error']")
	WebElement error;
	
	@FindBy(xpath="//div[@class='oxd-select-text oxd-select-text--focus oxd-select-text--error']")
	WebElement errorlist;
	
	@FindBy(xpath="//textarea[@placeholder='Type here']")
	WebElement note;
	
	@FindBy(xpath="(//button[text()=' Save '])[2]")
	WebElement save;
	
	@FindBy(xpath="//h6[text()='Job Details']")
	WebElement jobdetails;
	
	@FindBy(xpath="//p[text()='Terminated on: 2023-03-03']")
	WebElement termtext;

	public Jobterminate() {
		PageFactory.initElements(driver, this);
	}
	public void termination(String name,String id) throws Exception
	{
		try {
		Thread.sleep(2000);
		list(name,id);
		Jobdetails jo=new Jobdetails();
		click_button(jo.getJob(), "Job Menu");
		
		
click_button(terminate, "terminate");

date.sendKeys("2023-03-03");

Actions act=new Actions(driver);
act.moveToElement(reason).click().build().perform();
dropdown(resign, "Resigned");
act.sendKeys(resign,Keys.ENTER,Keys.RETURN).build().perform();
save.click();

displayed(jobdetails, "jobdetails");

JavascriptExecutor js=(JavascriptExecutor)driver;
js.executeScript("scroll(0,250);");
displayed(termtext, "Terminated on: 2023-03-03 displayed");
test.log(Status.PASS, "job terminated");
test.addScreenCaptureFromPath(screenshot("job termination"));
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "job termination");
			test.addScreenCaptureFromPath(screenshot("job termination"));
		}
	}
}

