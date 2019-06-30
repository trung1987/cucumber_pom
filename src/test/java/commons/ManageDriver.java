//T18

package commons;

import org.openqa.selenium.WebDriver;

import actions.CreateActions;
import actions.LoginActions;
import actions.PageDetailActions;
import actions.HomeActions;


public class ManageDriver {
	
	
	public static LoginActions login;
	public static HomeActions home;
	public static CreateActions Create;
	public static PageDetailActions PageDetail;
	
	public static LoginActions GoToLogin (WebDriver driver) {
		if (login == null) {
			login = new LoginActions(driver);
		}
		return login;
	}
	
	public static HomeActions GoToHomepage (WebDriver driver) {
		if (home == null) {
			home = new HomeActions(driver);
		}
		return home;
	}

	public static CreateActions manageCreatePage(WebDriver driver) {
		if (Create == null) {
			Create = new CreateActions(driver);
		}
		return Create;

	}

	public static PageDetailActions managePageDetail(WebDriver driver) {
		if (PageDetail == null) {
			PageDetail = new PageDetailActions(driver);
		}
		return PageDetail;

	}
}
