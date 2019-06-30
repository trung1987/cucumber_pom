package actions;

import org.openqa.selenium.WebDriver;

import commons.basedActions;


public class HomeActions extends basedActions {
	WebDriver driverlocal;
	
	public HomeActions (WebDriver driver)
	{
		driverlocal= driver;
	}
	
	public void verifylogin()
	{
		System.out.println("verify");
	}
	
	
	
}
