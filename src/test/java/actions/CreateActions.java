package actions;

import org.openqa.selenium.WebDriver;

import commons.ManageDriver;
import commons.basedActions;
import interfaces.CreateInterface;

public class CreateActions extends basedActions {

	WebDriver driverCreate;

	public CreateActions(WebDriver driver) {
		driverCreate = driver;
	}

	public void OpenPage() {
		openURL(driverCreate, CreateInterface.URL);
	}

	
	public void EnterEmailID(String input) {
		enterText(driverCreate, CreateInterface.EmailID, input);
	}
	
	public void EnterPass(String input) {
		enterText(driverCreate, CreateInterface.Password, input);
	}

	public PageDetailActions ClickSubmitBtn() {
		clickBtn(driverCreate, CreateInterface.SubmitBtn);
		return ManageDriver.managePageDetail(driverCreate);
	}
	
	

	
	

}
