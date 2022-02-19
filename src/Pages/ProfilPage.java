package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class ProfilPage extends BasicPage {
	
	private Actions action;

	public ProfilPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
		super(driver, wait, js);
		this.action = new Actions(driver);
		
	}
	
	@Override
	public WebElement getLocation() {
		
		return driver.findElement(By.className("location-selector"));
		
	}

	@Override
	public List<WebElement> getMenuBar() {
		return driver.findElements(By.className("navs--main"));
	}
	
	public WebElement getprofileBtn() {
		return driver.findElement(By.xpath("//*[@id='fixed__panel']/ul/li[2]/a"));
	}
	
	private WebElement getuserFirstName() {
		return driver.findElement(By.name("user_first_name"));
	}
	
	private WebElement getuserLastName() {
		return driver.findElement(By.name("user_last_name"));
	}
	
	private WebElement getuserAddres() {
		return driver.findElement(By.name("user_address"));
	}
	
	
	private WebElement getuserPhone() {
		return driver.findElement(By.name("user_phone"));
	}
	
	private WebElement getuserZip() {
		return driver.findElement(By.name("user_zip"));
	}
	
	private void getuserCountry(String country) {
		WebElement elemCountry = driver.findElement(By.id("user_country_id"));
		Select mySelect1 = new Select(elemCountry);
		mySelect1.selectByVisibleText(country);
	}
	
	private void getuserState(String state) {
		WebElement elemState = driver.findElement(By.id("user_state_id"));
		Select mySelect2 = new Select(elemState);
		mySelect2.selectByVisibleText(state);
	}
	
	private void getuserCity(String city) {
		WebElement elemCity = driver.findElement(By.id("user_city"));
		Select mySelect3 = new Select(elemCity);
		mySelect3.selectByVisibleText(city);
	}

	private WebElement profileSbmBtn() {
		return driver.findElement(By.xpath("//*[@id='profileInfoFrm']//input[@name='btn_submit']"));
	}
	
	public void fillProfile(String firstname,String lastname, String address, String phone, String zip, String country, String state, String city) throws InterruptedException  {
		getuserFirstName().clear();
		getuserLastName().clear();
		getuserAddres().clear();
		getuserPhone().clear();
		getuserZip().clear();
		
		
		getuserFirstName().sendKeys(firstname);
		getuserLastName().sendKeys(lastname);
		getuserAddres().sendKeys(address);
		getuserPhone().sendKeys(phone);
		getuserZip().sendKeys(zip);
		
		
		getuserCountry(country);
		Thread.sleep(1000);
		getuserState(state);
		Thread.sleep(1000);
		getuserCity(city);
		Thread.sleep(1000);
		profileSbmBtn().click();
		
		
	}
	
	public void getProfileHover() {
		
		WebElement element = driver.findElement(By.className("avatar"));

		action.moveToElement(element);
	}
	
	public void getUploadImgBtn() {
		WebElement img = driver.findElement(By.xpath("//*[@id=\"profileInfo\"]/div/div[1]/div/a"));
		js.executeScript("arguments[0].click();", img);
		
	}
	
	public WebElement getFile() {
		return driver.findElement(By.xpath("//input[@type=\"file\"]"));
	}
	
	public void profilePicture(String imgurl){
		//getprofileBtn();
		getUploadImgBtn();
		getFile().sendKeys(imgurl);
		
		Robot robot = null;
		try {
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_ESCAPE);
		    robot.keyRelease(KeyEvent.VK_ESCAPE);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    
	}
	
	public void getDeleteImgBtn() {
		getprofileBtn();
		WebElement imgDel = driver.findElement(By.xpath("//a[@title='Remove']"));
		js.executeScript("arguments[0].click();", imgDel);
		
	}
}
