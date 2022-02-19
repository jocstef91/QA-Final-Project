package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotificationSistemPage extends BasicPage{

	
	
	@Override
	public WebElement getLocation() {
		
		return driver.findElement(By.className("location-selector"));
		
	}

	@Override
	public List<WebElement> getMenuBar() {
		return driver.findElements(By.className("navs--main"));
	}
	
	public NotificationSistemPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
		super(driver,wait,js);
	}
	
	private WebElement getMessage() {
		return driver.findElement(By.xpath("//*[contains(@class, 'alert--success') or contains(@class, 'alert--danger')][contains(@style,'display: block')]"));
		
	}
	
	public String loginMessage() {
		
		return getMessage().getText();
	}
	
	public void whaitMsgToDisapear() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.attributeToBe(By.xpath("//*[contains(@class, 'system_message')]"), "style", "display: none;"));
		
		
	}
	
}
