package steps;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.cucumber.listener.Reporter;

import actions.HomeActions;
import actions.LoginActions;
import commons.ManageDriver;
import commons.basedTest;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login extends basedTest {
	//WebDriver driver;
	LoginActions login;
	HomeActions home;
	@Given("^I access page \"([^\"]*)\"$")
	public void i_access_page(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		login = ManageDriver.GoToLogin(driver);
		login.gotoURL(arg1);
	}

	@When("^I fill in username as \"([^\"]*)\"$")
	public void i_fill_in_username_as(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		/*System.out.println(arg1);
		WebElement usernameInput = driver.findElement(By.xpath("//input[@name='uid']"));
		usernameInput.sendKeys(arg1);*/
		
		login.enterUID(arg1);
		login.escap();
		
		//driver.findElement(By.xpath("//span[contains(text(),'Steps To Generate Access')]")).click();
	}

	@When("^I fill in password as \"([^\"]*)\"$")
	public void i_fill_in_password_as(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		/*System.out.println(arg1);
		WebElement passInput = driver.findElement(By.xpath("//input[@name='password']"));
		passInput.sendKeys(arg1);*/
		
		login.enterPassWord(arg1);
		login.escap();
		//driver.findElement(By.xpath("//span[contains(text(),'Steps To Generate Access')]")).click();
		Reporter.addScreenCaptureFromPath( TakeScreenShot(driver));
	}

	@When("^I click on login button$")
	public void i_click_on_login_button() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		//driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
		home=login.clickLogin();
	}

	@Then("^I can see homepage$")
	public void i_can_see_homepage() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		home.verifylogin();
	}

	@Then("^I can see alert message as \"([^\"]*)\"$")
	public void i_can_see_alert_message_as(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("====="+arg1);
	//	driver.findElement(By.xpath("//label[contains(text(),'"+arg1+ "')]"));
	//	Assert.assertTrue(driver.findElement(By.xpath("//label[contains(text(),'"+arg1+ "')]")).isDisplayed());
		login.verifyError(arg1);
	}
	
	
}
