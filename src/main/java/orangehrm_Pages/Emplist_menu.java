package orangehrm_Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import Orangehrm_Utils.utils_Method;

public class Emplist_menu extends utils_Method{
	
	@FindBys(@FindBy(xpath="//div[@class='orangehrm-tabs']//div//a"))
	List<WebElement> menus;
	
	public Emplist_menu() {
		PageFactory.initElements(driver, this);
	}
			
			
		public void personal(String name,String id)	throws Exception {
		try {
			list(name,id);
		for(int i=0;i<menus.size();i++)
		{
			WebElement menu_list=menus.get(i);
		String listmenu=menus.get(i).getText();
		displayed(menu_list, listmenu);
		test.log(Status.PASS, "Employee List");
		test.addScreenCaptureFromPath(screenshot("employeelist"));
		}
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "Employee List");
			test.addScreenCaptureFromPath(screenshot("employeelist"));
		}
	}
	}

