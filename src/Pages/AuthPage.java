package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthPage extends BasicPage {

	public AuthPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
		super(driver, wait, js);
		
	}
	
	@Override
	public WebElement getLocation() {
		
		return driver.findElement(By.className("location-selector"));
		
	}

	@Override
	public List<WebElement> getMenuBar() {
		return driver.findElements(By.className("navs--main"));
	}
	
	private WebElement getUserBtn(){
		return driver.findElement(By.xpath("//a[contains(@class,'after-arrow user-trigger-js')]"));
	}
	
	private List<WebElement> getUserBtnList(){
		return driver.findElements(By.xpath("//*[contains(@class,'my-account-dropdown')]//a"));
	}
	
	public void getAuth(int auth) {
		getUserBtn().click();
		getUserBtnList().get(auth).click();
	}
	

}
