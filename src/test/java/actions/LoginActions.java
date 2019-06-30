package actions;

import org.openqa.selenium.WebDriver;

import commons.ManageDriver;
import commons.basedActions;
import interfaces.LoginInterface;


public class LoginActions extends basedActions {
	WebDriver driverlocal;
	public LoginActions(WebDriver driver) {
		driverlocal = driver;
	}
	
	public void gotoURL (String url) {
		openURL(driverlocal, url);
	}
	
	
	public void enterUID (String input) {
		enterText(driverlocal, LoginInterface.email, input);
	}
	
	public void escap () {
		clickBtn(driverlocal, LoginInterface.generateString);
	}
	
	public void enterPassWord (String input) {
		enterText(driverlocal, LoginInterface.pwd, input);
	}
	
	
	public HomeActions clickLogin () {
		clickBtn(driverlocal, LoginInterface.loginBtn);
		return ManageDriver.GoToHomepage(driverlocal);
	}
	
	public void verifyError(String expect) {
		isControlDisplayed(driverlocal, String.format(LoginInterface.errorXpath, expect));
	}
}
