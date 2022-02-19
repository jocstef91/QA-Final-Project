package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MealPage extends BasicPage {

	public MealPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
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
	
	public WebElement setQty() {
		return driver.findElement(By.name("product_qty"));
	}

	public WebElement getAddToCart() {
		return driver.findElement(By.xpath("//a[contains(@class,'proceedtoAddInCart')]"));
	}
	
	public WebElement getAddtoFav() {
		return driver.findElement(By.id("item_119"));
	}
}
