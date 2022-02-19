package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasicPage {
	
	public LoginPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
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
	
	public WebElement username() {
	
		return driver.findElement(By.name("username"));
	}
	
	public WebElement password() {
		
		return driver.findElement(By.name("password"));
	}
	
	public WebElement loginSubmit() {
		
		return driver.findElement(By.name("btn_submit"));
	}
	
	public void fillLoginData(String username, String password) {
		
		username().clear();
		password().clear();
		username().sendKeys(username);
		password().sendKeys(password);
		
	}

}
