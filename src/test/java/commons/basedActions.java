package commons;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class basedActions {
	public void openURL(WebDriver driver, String URL) {
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public void enterText(WebDriver driver, String xpath, String input) {
		WebElement element =driver.findElement(By.xpath(xpath));
		element.clear();
		element.sendKeys(input);
	}
	
	public void clickBtn(WebDriver driver, String xpath) {
		WebElement element =driver.findElement(By.xpath(xpath));
		element.click();
	}
	
	public void acceptAlert(WebDriver driver) {
		Alert myAlert = driver.switchTo().alert();
		myAlert.accept();
	}
	
	public String getValue(WebDriver driver, String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		return element.getText();
	}
	
	public String getAlertMsg(WebDriver driver) {
		Alert myAlert = driver.switchTo().alert();
		return myAlert.getText();
	}
	
	public void assertValue(WebDriver driver,String returnMsg, String expectedMsg) {
		Assert.assertEquals(returnMsg, expectedMsg);
	}
	
	//Capture each step
	/*public static String captureEachStep(WebDriver driver) throws IOException
    {
    	String dateName = new SimpleDateFormat("yyyyMMDDhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String dest = System.getProperty("user.dir") +"/report/testReport_screenShot"+dateName+".png";
        File destination = new File(dest);
        FileUtils.copyFile(source, destination);        
                     
        return dest;
    }*/
	
	/*Execise defines other general actions*/
	/*Web Browser*/
	
	public void getTitle(WebDriver driver) {
		driver.getTitle();
	}
	
	public String getCurrentURL(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	public void back(WebDriver driver) {
		driver.navigate().back();
	}
	
	public void forward(WebDriver driver) {
		driver.navigate().forward();
	}
	
	public void refresh(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	/*Alert*/
	public void cancelAlert(WebDriver driver) {
		Alert myAlert = driver.switchTo().alert();
		myAlert.dismiss();	
	}
	
	public void sendkeyToAlert(WebDriver driver, String keysToSend) {
		Alert myAlert = driver.switchTo().alert();
		myAlert.sendKeys(keysToSend);
	}
	
	/*Web Element*/
	public void clickToEleByJs(WebDriver driver, String objectToClick) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", objectToClick);
	}
	
	public void clickToEleByAction(WebDriver driver, String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		Actions action = new Actions(driver);
		action.click(element).build().perform();
	}
	
	public void selectItemInHtmlDropDownByIndex(WebDriver driver, String xpath, Integer index) {
		Select dropDown = new Select(driver.findElement(By.xpath(xpath)));
		dropDown.selectByIndex(index);
	}
	
	public void selectItemInHtmlDropDownByValue(WebDriver driver, String xpath, String value) {
		Select dropDown = new Select(driver.findElement(By.xpath(xpath)));
		dropDown.selectByValue(value);
	}
	
	public void selectItemInHtmlDropDownByInvisibleText(WebDriver driver, String xpath, String value) {
		Select dropDown = new Select(driver.findElement(By.xpath(xpath)));
		dropDown.selectByVisibleText(value);
		}
	
	public String getSelectedItemInHtmlDropDown(WebDriver driver, String xpath, String value) {
		Select dropDown = new Select(driver.findElement(By.xpath(xpath)));
		WebElement select = dropDown.getFirstSelectedOption();
		return select.getText();
	}
	
	public void checkTheCheckBox(WebDriver driver, String checkBoxName) {
		//If type = 'checkbox', Ex: <.input type="checkbox" name="vehicle" value="Bike">I have a bike<br />
		List<WebElement> checkbox = driver.findElements(By.name(checkBoxName));
        ((WebElement) checkbox.get(0)).click();
		/*OR by xpath:
		WebElement elementToClick = driver.findElement(By.xpath(xpath));
		elementToClick.click();*/
	}
	
	public void UncheckTheCheckBox(WebDriver driver, String xpath) {
		//If type = 'checkbox'
		WebElement checkBox = driver.findElement(By.xpath(xpath));
		boolean checkStatus;
		checkStatus = checkBox.isSelected();
		if(checkStatus == true) {
			checkBox.click();
		}
		else {
			System.out.println("it has been uncheck already");
		}
	}
	
	public boolean isControlDisplayed(WebDriver driver, String xpath) {
		WebElement checkItem = driver.findElement(By.xpath(xpath));
		return checkItem.isDisplayed();
	}
	
	public boolean isControlSelected(WebDriver driver, String xpath) {
		WebElement checkItem = driver.findElement(By.xpath(xpath));
		return checkItem.isSelected();
	}
	
	public boolean isControlEnabled(WebDriver driver, String xpath) {
		WebElement checkItem = driver.findElement(By.xpath(xpath));
		return checkItem.isEnabled();
	}
	
	/*scrollByJSToBottom ->javascript /Action - NOT YET*/
	/*iframe/tab:  ----*/
	public void switchToIframe(WebDriver driver) {
		Set<String> tabList = driver.getWindowHandles();
 		//System.out.println("tabList value" + tabList);
 		for (String activeTab :tabList) {
 			driver.switchTo().window(activeTab);
 			}
	}
/*	Remaining:
		.switchToMainFrame
		.switchToTabByIndex*/
	
	//-uploadFile -remaining - robot and some others
	public void upFileSendKey(WebDriver driver, String xpathBtn, String uploadPath, String xpathUploadTo,String beginXpathBtn, Integer index) {
		WebElement uploadBtn = driver.findElement(By.xpath(xpathBtn));
		WebElement beginUploadBtn = driver.findElement(By.xpath(beginXpathBtn));
		Select uploadTo = new Select(driver.findElement(By.xpath(xpathUploadTo)));
		uploadBtn.click();
		uploadBtn.sendKeys(uploadPath);
		uploadTo.selectByIndex(index);

	}
}
