package actions;

import org.openqa.selenium.WebDriver;

import commons.basedActions;
import interfaces.PageDetailInterface;

public class PageDetailActions extends basedActions {

	WebDriver driverDetail;

	public PageDetailActions(WebDriver driver) {
		driverDetail = driver;
	}

	public String GetUserId() {
		return getValue(driverDetail, PageDetailInterface.DataUserId);
	}

	public String GetPass() {
		return getValue(driverDetail, PageDetailInterface.DataPass);
	}


}
