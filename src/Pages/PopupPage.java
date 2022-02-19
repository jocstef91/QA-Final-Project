package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PopupPage extends BasicPage {

	
	
	public PopupPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
		super(driver,wait,js);
		
	}
	
	@Override
	public WebElement getLocation() {
		
		return driver.findElement(By.className("location-selector"));
		
	}

	@Override
	public List<WebElement> getMenuBar() {
		return driver.findElements(By.className("navs--main"));
	}
	
	public WebElement getCloseBtn() {
		
		return driver.findElement(By.xpath("//a[contains(@class,'close-btn close-btn-white')]"));
		
	}
	
	private WebElement getKeyword() {
		
		return driver.findElement(By.id("locality_keyword"));
		
	}
	
	public String getLocationItem(String locationName) {
		
		return wait.until
				(ExpectedConditions.presenceOfElementLocated(By.xpath
						("//li/a[contains(text(), \"" + locationName + "\")]/.."))).getAttribute("data-value");
		
	}
	
	private WebElement getLocationInput() {
		
		return driver.findElement(By.id("location_id"));
		
	}
	
//	public WebElement getLocationInput() {
//		WebElement locationInput = wait.until
//				(ExpectedConditions.presenceOfElementLocated(By.xpath
//						("//*[@id='location_id']")));
//		return locationInput;
//	}
	
	private WebElement getSubmitBtn() {
		
		return driver.findElement(By.name("btn_submit"));
		
	}
	
	private void openLocation() {
		
		getLocation().click();
		
	}
	

	
	public void onClickLocation(String locationName) throws InterruptedException  {
		
		getKeyword().click();
		
		
		
		
		WebElement path = getLocationInput();
		Thread.sleep(3000);
		
		
		String value =  getLocationItem(locationName);
		
		
		System.out.println(value);
		js.executeScript("arguments[0].value=arguments[1];", path, value);
		
		Thread.sleep(3000);
		js.executeScript("arguments[0].click();", getSubmitBtn());
		
	}

	
	

}
