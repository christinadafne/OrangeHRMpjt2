package orangehrm_Pages;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import Orangehrm_Utils.utils_Method;

public class Personal_details extends utils_Method {

	@FindBy(xpath = "//form[@class='oxd-form']//following::div[@class='--name-grouped-field']//div//input[@name='middleName']")
	WebElement middlename;

	@FindBy(xpath = "//label[text()='Nickname']//parent::div//following-sibling::div//input")
	WebElement nickname;

	@FindBy(xpath = "//label[text()='Employee Id']//parent::div//following-sibling::div//input")
	WebElement eid;

	@FindBy(xpath = "//label[text()='Other Id']//parent::div//following-sibling::div//input")
	WebElement oid;

	@FindBy(xpath = "(//label[@class='oxd-label'])[4]//parent::div//following-sibling::div//input")
	WebElement license;

	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active' and @placeholder='yyyy-mm-dd'])[1]")
	WebElement lic_expdate;

	@FindBy(xpath = "//label[text()='SSN Number']//parent::div//following-sibling::div/input")
	WebElement ssn;

	@FindBy(xpath = "//label[text()='SIN Number']//parent::div//following-sibling::div/input")
	WebElement sin;

	@FindBy(xpath = "//div[@class='oxd-select-text oxd-select-text--active']//div[text()='-- Select --'][1]")
	WebElement nationality;

	@FindBy(xpath = "//label[text()='Nationality']//parent::div//following::div[@class='oxd-select-text-input'][1]")
	WebElement options;

	@FindBy(xpath = "//div[@class='oxd-select-text oxd-select-text--active']//div[text()='-- Select --'][1]")
	WebElement maritalstatus;

	@FindBy(xpath = "//label[text()='Marital Status']//parent::div//following::div[@class='oxd-select-text-input'][1]")
	WebElement options1;

	@FindBy(xpath = "//label//input[@value='2']")
	WebElement female;

	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active' and @placeholder='yyyy-mm-dd'])[2]")
	WebElement dob;

	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[10]")
	WebElement military;

	@FindBy(xpath = "//div[@class='oxd-select-text oxd-select-text--active']//div[text()='-- Select --'][1]")
	WebElement bloodtype;

	@FindBy(xpath = "//label[text()='Blood Type']//parent::div//following::div[@class='oxd-select-text-input'][1]")
	WebElement options2;

	@FindBy(xpath = "//button[@type='submit' ]")
	WebElement save;

	@FindBy(linkText = "Personal Details")
	WebElement Personal;

	public Personal_details() {
		PageFactory.initElements(driver, this);
	}

	public void details(String name, String id) throws Exception {
		try {
		list(name, id);
		Thread.sleep(2000);
		
		input_text(middlename, "ammu");
		input_text(nickname, "tios");
		// input_text(eid, "112");

		input_text(oid, "989");

		input_text(license, "1117");

		input_text(lic_expdate, "2024-02-17");

		input_text(ssn, "1212");

		input_text(sin, "3132");

		click_button(nationality, "nationality");
		Robot robot = new Robot();
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_I);
		robot.keyRelease(KeyEvent.VK_I);
		dropdown(options,"Indian");
		
		click_button(maritalstatus, "marital status");
		// Thread.sleep(2000);
		Robot robot1 = new Robot();
		robot.keyPress(KeyEvent.VK_M);
		robot.keyRelease(KeyEvent.VK_M);
		dropdown(options1, "Married");
		

		input_text(dob, "1989-02-17");
		Actions act = new Actions(driver);
		act.moveToElement(female).click().build().perform();

		input_text(military, "military");
		act.click(save).build().perform();

		click_button(bloodtype, "Blood type");
		// Thread.sleep(2000);
		Robot robot3 = new Robot();
		robot3.keyPress(KeyEvent.VK_B);
		robot3.keyRelease(KeyEvent.VK_B);
		dropdown(options2, "B+");
		Thread.sleep(2000);

		click_button(Personal, "personal page");
		test.log(Status.PASS, "add details");
		test.addScreenCaptureFromPath(screenshot("add details"));
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "add details");
			test.addScreenCaptureFromPath(screenshot("add details"));
		}
	}

}
