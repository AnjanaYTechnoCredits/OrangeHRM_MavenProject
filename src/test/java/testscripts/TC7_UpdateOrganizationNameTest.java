package testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.hradministration.UpdateOrganizationName;

public class TC7_UpdateOrganizationNameTest extends TestBase {
	
	@Test
	public void UpdateCompanyName() {
		System.out.println("Step:Click on HR Administration tab");
		System.out.println("Step:Mouse Hover on Oraganization tab and click on General Informatiom tab");
		new DashboardPage()
		.clickOnDashboardLeftMenu("HR Administration")
		.navigate_to("Organization-> General Information ");
		
		UpdateOrganizationName updateOrganizationName = new UpdateOrganizationName();
		
		
		System.out.println("Step:User Change Organization name to anything");
		updateOrganizationName.updateOrganizationName("Anything");
		
		System.out.println("Step:verify the number of employee field is disabled");
		boolean flag=updateOrganizationName.validateEmpField();
		Assert.assertFalse(flag);
		
		System.out.println("Step:User save the information");
		updateOrganizationName.saveInfo();
		
		System.out.println("Step:User mouse Hover on user profile and click on setting icon");
		DashboardPage dashboardPage=new DashboardPage();
		dashboardPage.isUserProfileDisplayed();
		dashboardPage.mouseHoverOnUserProfile();
		dashboardPage.clickOnSettingButton();
		
		System.out.println("Step:User click on about section");
		dashboardPage.clickOnUserMenuAboutLink();
		
		System.out.println("Step:Verify that updated Organization Name displayed is Anything");
		String companyName=updateOrganizationName.validateOrganizationName();
		Assert.assertEquals(companyName, "Anything");
		
	}
}
