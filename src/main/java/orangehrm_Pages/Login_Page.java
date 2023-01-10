package orangehrm_Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import Orangehrm_Utils.utils_Method;

public class Login_Page extends utils_Method {
	
	@FindBy(name="username")
	WebElement uname;

	@FindBy(name="password")
	WebElement password;

	@FindBy(xpath="//button[@type='submit']")
	WebElement loginbutton;
	
	public Login_Page() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void login() throws Exception {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		try
		{
			
			input_text(uname,username);
			
			input_text(password, pass);
			click_button(loginbutton, "login");
			test.log(Status.PASS, "login successful");
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "login unsuccessful");
		}
	
		
		
	}


	

}
