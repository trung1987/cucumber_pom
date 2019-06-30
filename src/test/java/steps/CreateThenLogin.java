package steps;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import actions.CreateActions;
import actions.HomeActions;
import actions.LoginActions;
import actions.PageDetailActions;
import commons.DataCommons;
import commons.ManageDriver;
import commons.basedTest;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateThenLogin extends basedTest {
	// ==========================================================================
	LoginActions login;
	HomeActions home;
	PageDetailActions pageDetail;
	CreateActions createAct;
	
	@When("^I fill in emaiID as random email$")
	public void i_fill_in_emaiID_as_random_email() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		createAct = ManageDriver.manageCreatePage(driver);
		Random ran = new Random();
		DataCommons.emailRandom = "test" + ran.nextInt() + "@gmail.com";
		
		createAct.EnterEmailID(DataCommons.emailRandom);
	}

	@Then("^I can see UserID and Passwrod$")
	public void i_can_see_UserID_and_Passwrod() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		DataCommons.userID = driver.findElement(By.xpath("//td[contains(text(),'ID')]/following-sibling::td"))
				.getText();
		DataCommons.password = driver.findElement(By.xpath("//td[contains(text(),'Password')]/following-sibling::td"))
				.getText();
	}

	@When("^I fill in username as default username$")
	public void i_fill_in_username_as_default_username() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		/*WebElement usernameInput = driver.findElement(By.xpath("//input[@name='uid']"));
		usernameInput.sendKeys(DataCommons.userID);*/
		login = ManageDriver.GoToLogin(driver);
		login.enterUID(DataCommons.userID);

	}

	@When("^I fill in password as default password$")
	public void i_fill_in_password_as_default_password() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		/*WebElement usernameInput = driver.findElement(By.xpath("//input[@name='password']"));
		usernameInput.sendKeys(DataCommons.password);*/
		login.enterPassWord(DataCommons.password);
	}

}
