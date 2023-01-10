package orangehrm_Testcases;

import org.testng.ITestResult;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import orangehrm_BaseMethods.BaseMethods;
import orangehrm_Pages.AdminPage;
import orangehrm_Pages.Contact_details;
import orangehrm_Pages.Dependency;
import orangehrm_Pages.Emergency_details;
import orangehrm_Pages.Emplist_menu;
import orangehrm_Pages.JobActivate;
import orangehrm_Pages.Jobdetails;
import orangehrm_Pages.Jobterminate;
import orangehrm_Pages.Login_Page;
import orangehrm_Pages.PIM_addemp;
import orangehrm_Pages.Personal_details;
import orangehrm_Pages.Salary;
import orangehrm_Pages.TaxExemption;

public class OrangeHrm_testcases extends BaseMethods {
	@Test
	public void Admin() throws Exception
	{
		test=extent.createTest("TC_PIM_01");
		ap=new AdminPage();
		ap.search();
		extent.flush();
		
	}
	@Test
	public void usermgmt() throws Exception
	{
		test=extent.createTest("TC_PIM_02");
		ap=new AdminPage();
		ap.usermanagement();
		extent.flush();
	}
	
	@Test
	public void addemp() throws Exception
	{
		test=extent.createTest("TC_PIM_03");
		pm=new PIM_addemp();
		pm.addemp("freddyjohn","1985");
		extent.flush();
		
	}
	@Test(dependsOnMethods = {"addemp"})
	public void PIM_menu() throws Exception
	{
	test=extent.createTest("TC_PIM_04");
	em=new Emplist_menu();
	em.personal("freddyjohn","1985");
	extent.flush();
	
	}
	@Test(dependsOnMethods = {"addemp"})
	public void details() throws Exception
	{
	test=extent.createTest("TC_PIM_05");
		 pd=new Personal_details();
		 pd.details("freddyjohn","1985");
		 extent.flush();
		
	}
	
	@Test(dependsOnMethods = {"addemp"})
	public void contact() throws Exception
	{
		test=extent.createTest("TC_PIM_06");
		Contact_details cd=new Contact_details();
		cd.address("freddyjohn","1985");
		 extent.flush();
	}
	
	@Test(dependsOnMethods = {"addemp"})
	public void emergency() throws Exception
	{
		test=extent.createTest("TC_PIM_07");
	Emergency_details ed=new Emergency_details();
	ed.emergency("freddyjohn","1985");
	 extent.flush();
		
	}
	
	@Test(dependsOnMethods = {"addemp"})
	public void depends() throws Exception
	{
		
		test=extent.createTest("TC_PIM_8");
		
		Dependency dd=new Dependency();
		dd.depends("freddyjohn","1985");
		 extent.flush();
	}
	
	@Test(dependsOnMethods = {"addemp"})
	public void job() throws Exception
	{
		test=extent.createTest("TC_PIM_09");
		Jobdetails jb=new Jobdetails();
		jb.job_details("freddyjohn","1985");
		 extent.flush();
		
	}
	@Test(dependsOnMethods = {"addemp","job"})
	public void jobterm() throws Exception
	{
		test=extent.createTest("TC_PIM_10");
		Jobterminate ju=new Jobterminate();
		ju.termination("freddyjohn","1985");
		 extent.flush();
		
		
	}
	@Test(dependsOnMethods = {"addemp","jobterm"})
	public void jobactivate() throws Exception
	{
		test=extent.createTest("TC_PIM_11");
		JobActivate ja=new JobActivate();
		ja.act_emp("freddyjohn","1985");
		 extent.flush();
	}
	
	@Test(dependsOnMethods = {"addemp"})
	public void salary() throws Exception
	{
		test=extent.createTest("TC_PIM_12");
		Salary sal=new Salary();
		sal.pimsalary("freddyjohn","1985");
		 extent.flush();
	}
	
	@Test(dependsOnMethods = {"addemp"})
	public void TaxExemp() throws Exception
	{
		test=extent.createTest("TC_PIM_13");
		TaxExemption te= new TaxExemption();
		te.tax("freddyjohn","1985");
		 extent.flush();
	}
	
}


