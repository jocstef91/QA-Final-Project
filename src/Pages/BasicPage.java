package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasicPage {

	protected WebDriver driver;
	protected JavascriptExecutor js;
	protected WebDriverWait wait;
	
	public BasicPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
		
		this.driver=driver;
		this.wait=wait;
		this.js=js;
		
	}
	
	
	
	public abstract WebElement getLocation();
	
	public abstract List<WebElement> getMenuBar();
	
}
