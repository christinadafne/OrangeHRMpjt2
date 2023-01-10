package orangehrm_Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import Orangehrm_Utils.utils_Method;

public class Dependency extends utils_Method{
	@FindBy(linkText="Dependents")
	WebElement dependents;
	
	@FindBy(xpath="(//div[@class='orangehrm-action-header']//child::i)[1]")
	WebElement add;
	
	@FindBy(xpath="(//div[@class='oxd-grid-item oxd-grid-item--gutters'])[1]//input")
	WebElement name;
	
	@FindBy(xpath="//div[@class='oxd-select-text-input']")
	WebElement relationship;
	
	@FindBy(xpath="(//div[@class='oxd-input-group oxd-input-field-bottom-space']//input[@class='oxd-input oxd-input--active'])[2]")
	WebElement reason;
	
	
	@FindBy(xpath="//input[@placeholder='yyyy-mm-dd']")
	WebElement dob;
	
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
	WebElement save;
	
	
	public Dependency() {
PageFactory.initElements(driver, this);	
}

	public void depends(String name1,String id) throws Exception {
		try {
		list(name1,id);
		Thread.sleep(2000);
		click_button(dependents, "dependents");
		click_button(add, "+ add");
		input_text(name, "birla");
		input_text(dob, "1989-02-17");
		
		Thread.sleep(2000);
		Actions act=new Actions(driver);
		act.sendKeys(relationship, "o").sendKeys(Keys.ARROW_DOWN,Keys.RETURN).sendKeys(Keys.ENTER).build().perform();
		act.sendKeys(reason, "dad").build().perform();
		save.click();
		test.log(Status.PASS, "Dependency successfull");
		test.addScreenCaptureFromPath(screenshot("dependency"));
		}
		catch(Exception e) {
			test.log(Status.FAIL,"dependency");
			test.addScreenCaptureFromPath(screenshot("dependency"));
		}
		}
	}


