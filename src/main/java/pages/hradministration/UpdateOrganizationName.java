package pages.hradministration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ControlActions;

public class UpdateOrganizationName extends ControlActions {
	
	@FindBy(css="input[id='name']")
	private WebElement organizationNameInput;
	
	@FindBy(css="input#numemp")
	private WebElement numberOfEmp;
	
	@FindBy(css="button[type='submit']")
	private WebElement submitbtn;
	
	@FindBy(xpath="//div[@id='companyInfo']//p[1]")
	private WebElement companyName;
	
	
	public UpdateOrganizationName() {
		PageFactory.initElements(driver, this);
	}
	
	public void updateOrganizationName(String name) {
		waitForElementToBeVisible(organizationNameInput);
		organizationNameInput.clear();
		organizationNameInput.sendKeys(name);
		
	}
	
	private void sendKeys(String name) {
		// TODO Auto-generated method stub
		
	}

	public boolean  validateEmpField() {
		return numberOfEmp.isEnabled();	
	}
	
	public void saveInfo() {
		submitbtn.click();
	}
	
	public String validateOrganizationName(){
		waitForElementToBeVisible(companyName);
		String cmpName=companyName.getText();
		String[] arr=cmpName.split(" ");
		return arr[2];
	}
}
