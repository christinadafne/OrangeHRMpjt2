package orangehrm_Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import Orangehrm_Utils.utils_Method;

public class TaxExemption extends utils_Method {
	
	@FindBy(linkText="Tax Exemptions")
	WebElement taxexem;
	
	@FindBy(xpath="//div[text()='-- Select --']")
	WebElement select;
	
	@FindBy(xpath="//div[@class='oxd-select-text oxd-select-text--focus']//div")
	WebElement status;
	
	@FindBy(xpath="//div[@class='oxd-select-text oxd-select-text--focus']//div")
	WebElement state;
	
	@FindBy(xpath="//div[@class='oxd-select-text oxd-select-text--focus']//div")
	WebElement status1;
	
	@FindBy(xpath="//div[@class='oxd-select-text oxd-select-text--focus']//div")
	WebElement unemp;
	
	@FindBy(xpath="//div[@class='oxd-select-text oxd-select-text--focus']//div")
	WebElement work;
	
	@FindBy(xpath="//button[text()=' Save ']")
	WebElement save;
	
	
	public TaxExemption() {
PageFactory.initElements(driver, this);	}
	
	public void tax(String name,String id) throws Exception {
		try {
		list(name,id);
		click_button(taxexem, "tax exemption");
		select.click();
		dropdown(status, "Married");
		select.click();
		dropdown(state, "Indiana");
		select.click();
		dropdown(status1, "Married");
		select.click();
		dropdown(unemp, "Florida");
		select.click();
		dropdown(work, "California");
		click_button(save,"save");
		test.log(Status.PASS,"Tax Exemption");
		test.addScreenCaptureFromPath(screenshot("TAX EXEMPTIONS"));
		
		}
		catch(Exception e)
		{
			test.log(Status.FAIL,"Tax Exemption");
			test.addScreenCaptureFromPath(screenshot("TAX EXEMPTIONS"));
			
		}
	}

}
