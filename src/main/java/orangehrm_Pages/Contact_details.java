package orangehrm_Pages;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import Orangehrm_Utils.utils_Method;

public class Contact_details extends utils_Method {
	
	@FindBy(xpath = "//a[text()='Contact Details']")
	WebElement contact;
	
	@FindBy(xpath = "//label[text()='Street 1']//following::input[1]")
	WebElement street1;

	@FindBy(xpath = "//label[text()='Street 2']//following::input[1]")
	WebElement street2;

	@FindBy(xpath = "//label[text()='City']//following::input[1]")
	WebElement city;

	@FindBy(xpath = "//label[text()='Street 1']//following::input[4]")
	WebElement state;

	@FindBy(xpath = "//label[text()='Street 1']//following::input[5]")
	WebElement zip;

	@FindBy(xpath = "//div[@class='oxd-select-text oxd-select-text--active']")
	WebElement select;

	@FindBy(xpath = "//div[@class='oxd-select-text oxd-select-text--focus']//div[contains(text(),'Albania')]")
	WebElement country;

	@FindBy(xpath = "//label[text()='Street 1']//following::input[6]")
	WebElement home_no;

	@FindBy(xpath = "//label[text()='Street 1']//following::input[7]")
	WebElement mobile;

	@FindBy(xpath = "//label[text()='Street 1']//following::input[8]")
	WebElement work_no;

	@FindBy(xpath = "//label[text()='Street 1']//following::input[9]")
	WebElement work_email;

	@FindBy(xpath = "//span[text()='Already exists']")
	WebElement exist;

	@FindBy(xpath = "//input[@class='oxd-input oxd-input--active oxd-input--error'][1]")
	WebElement errormail1;

	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active oxd-input--error'])[2]")
	WebElement errormail2;

	@FindBy(xpath = "//label[text()='Street 1']//following::input[10]")
	WebElement other_email;

	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement checkbox;

	@FindBy(xpath = "//button[text()=' Save ']")
	WebElement save;
	
	

	 public Contact_details() {
		PageFactory.initElements(driver, this);
	}

	public void address(String name,String id) throws Exception {
		try {
		// driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Thread.sleep(5000);
		//Expwait(contact);
		//ap.getAdmin().click();
		list(name,id);
		click_button(contact, "contact");

		Thread.sleep(2000);
		input_text(street1, "north");

		input_text(street2, "south street");
		input_text(city, "wallcity");
		input_text(state, "tamilnadu");
		input_text(zip, "1234");
		select.click();

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_I);
		WebElement trial = driver.findElement(By.xpath("//div[@class='oxd-select-wrapper']//child::div"));
		while (trial.getText().equalsIgnoreCase("India") == false)

		{
			robot.delay(300);
			robot.keyPress(KeyEvent.VK_DOWN);
		}
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		input_text(home_no, "12345");
		input_text(mobile, "98421");
		input_text(work_no, "67890");
		input_text(work_email, "testemp1@gmail.com");	
		input_text(other_email, "testemp2@gmail.com");

		click_button(save, "save");

		test.log(Status.PASS, "details add");
		test.addScreenCaptureFromPath(screenshot("details added"));
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "details add");
			test.addScreenCaptureFromPath(screenshot("details added"));	
		}

	}
}

	