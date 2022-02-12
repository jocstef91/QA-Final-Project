package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BasicPage {

	protected WebDriver driver;
	
	public BasicPage(WebDriver driver) {
		
		this.driver=driver;
		
	}
	
	public abstract WebElement getLocation();
	
	public abstract List<WebElement> getMenuBar();
	
}
