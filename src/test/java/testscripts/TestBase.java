package testscripts;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import base.ControlActions;
import pages.LoginPage;

public class TestBase {

	@BeforeMethod
	public void setup() {
		System.out.println("Step - Launch orange HRM URL");
		ControlActions.start();
		System.out.println("Step - User Login with valid credential");
		LoginPage loginPage = new LoginPage();
		loginPage.doLogin("Admin", "gpK@DR39oP");
	}
	
	@AfterMethod
	public void tearDown(ITestResult itestResult) {
		if(!itestResult.isSuccess())
			ControlActions.getScreenshots(itestResult.getTestClass().getName()+"_"+itestResult.getName());
		
		ControlActions.closeBrowser();
	}
}
