package orangehrm_Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import Orangehrm_Utils.utils_Method;

public class Salary extends utils_Method {

	@FindBy(linkText = "Salary")
	WebElement salar;

	@FindBy(xpath = "(//button[text()=' Add '])[1]")
	WebElement add;

	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
	WebElement comp;

	@FindBy(xpath = "(//div[@class='oxd-select-text oxd-select-text--active'])[1]")
	WebElement paygrade;

	@FindBy(xpath = "//div[@class='oxd-select-text oxd-select-text--focus']//div")
	WebElement Grade2;

	@FindBy(xpath = "(//div[@class='oxd-select-text oxd-select-text--active'])[2]")
	WebElement payfreq;

	@FindBy(xpath = "//div[@class='oxd-select-text oxd-select-text--focus']//div")
	WebElement Monthly;

	@FindBy(xpath = "(//div[@class='oxd-select-text oxd-select-text--active'])[3]")
	WebElement currency;

	@FindBy(xpath = "//div[@class='oxd-select-text oxd-select-text--focus']//div")
	WebElement usa;

	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[3]")
	WebElement amount;
	
	@FindBy(xpath="//span[@class='oxd-switch-input oxd-switch-input--active --label-right']")
	WebElement toggle;
	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[4]")
	WebElement account;

	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[5]")
	WebElement routing;

	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[6]")
	WebElement amount1;
	
	@FindBy(xpath = "(//div[@class='oxd-select-text oxd-select-text--active'])[4]")
	WebElement acnttype;

	@FindBy(xpath = "//div[@class='oxd-select-text oxd-select-text--focus']//div")
	WebElement Savings;
	
	@FindBy(xpath="//button[text()=' Save ']")
WebElement save;
	public Salary() {
	
		PageFactory.initElements(driver, this);
	}

	public void pimsalary(String name,String id) throws Exception {
		try {
		list(name,id);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("scroll(0,250);");
		click_button(salar, "salary");
		click_button(add, "+ add");
		input_text(comp, "CTC");
		
		click_button(paygrade, "paygrade");
		dropdown(Grade2, "Grade 2");
		click_button(payfreq, "payfrequency");
		dropdown(Monthly, "Monthly");
		click_button(currency, "currency");
		Robot rob = new Robot();
		rob.keyPress(KeyEvent.VK_U);
		rob.keyRelease(KeyEvent.VK_U);
		dropdown(usa, "United States Dollar");
		
		input_text(amount, "3000");
		click_button(toggle, "toggle");
		input_text(account, "12345");
		click_button(acnttype, "Account type");
		dropdown(Savings,"Savings");
		input_text(routing, "98765");
		input_text(amount1, "3000");
		click_button(save, "save");
		
		test.log(Status.PASS, "Salary");
		test.addScreenCaptureFromPath(screenshot("SALARY"));
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "Salary");
			test.addScreenCaptureFromPath(screenshot("SALARY"));
		}
}
}
