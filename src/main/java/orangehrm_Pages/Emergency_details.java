package orangehrm_Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import Orangehrm_Utils.utils_Method;

public class Emergency_details extends utils_Method{
	
@FindBy(linkText="Emergency Contacts")
WebElement emergencyDetails;

@FindBy(xpath="//i[@class='oxd-icon bi-plus oxd-button-icon']")
WebElement add;

@FindBy(xpath="//div[@class='oxd-grid-item oxd-grid-item--gutters'][1]//input")
WebElement name;

@FindBy(xpath="(//div[@class='oxd-grid-item oxd-grid-item--gutters'])[2]//input")
WebElement relationship;

@FindBy(xpath="(//div[@class='oxd-grid-item oxd-grid-item--gutters'])[3]//input")
WebElement home;

@FindBy(xpath="(//div[@class='oxd-grid-item oxd-grid-item--gutters'])[4]//input")
WebElement mobile;

@FindBy(xpath="(//div[@class='oxd-grid-item oxd-grid-item--gutters'])[5]//input")
WebElement work;

@FindBy(xpath="//button[@type='submit']")
WebElement save;

public Emergency_details() {
PageFactory.initElements(driver, this);
}

public void emergency(String name1,String id) throws Exception {
	try {
	list(name1,id);
click_button(emergencyDetails, "emergency");
click_button(add, "+ add");
input_text(name, "tata");
input_text(relationship, "father");
input_text(home, "65432");
input_text(mobile, "98765432");
input_text(work, "12345");
click_button(save, "save");
test.log(Status.PASS, "Emergency");
test.addScreenCaptureFromPath(screenshot("emergency"));
	}
	catch(Exception e)
	{
		test.log(Status.FAIL, "Emergency");
		test.addScreenCaptureFromPath(screenshot("emergency"));
	}
}
}
