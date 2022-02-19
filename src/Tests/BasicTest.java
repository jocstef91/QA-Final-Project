package Tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Pages.AuthPage;
import Pages.BasicPage;
import Pages.CartSummaryPage;
import Pages.LoginPage;
import Pages.MealPage;
import Pages.NotificationSistemPage;
import Pages.PopupPage;
import Pages.ProfilPage;

public abstract class BasicTest {
	
	protected String mesage;
	protected String username;
	protected String password;
	protected String baseUrl;
	protected WebDriver driver;
	protected WebDriverWait wait;
	protected JavascriptExecutor js;
	protected BasicPage basic;
	protected PopupPage popup;
	protected LoginPage login;
	protected NotificationSistemPage notif;
	protected ProfilPage profil;
	protected AuthPage auth;
	protected MealPage meal;
	protected CartSummaryPage cart;
	
	
	
	public BasicTest() {
		this.mesage=mesage;
		this.username="customer@dummyid.com";
		this.password="12345678a";
		this.baseUrl="http://demo.yo-meals.com/";
		
	}



	@BeforeMethod
	public void beforeMethod() throws IOException {
		System.setProperty("webdriver.chrome.driver", 
				"driver-lib\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		js = (JavascriptExecutor) driver;
		
		
		popup = new PopupPage(driver, wait, js);
		login = new LoginPage(driver, wait, js);
		notif = new NotificationSistemPage(driver, wait, js);
		profil = new ProfilPage(driver, wait, js);
		auth = new AuthPage(driver, wait, js);
		meal = new MealPage(driver, wait, js);
		cart = new CartSummaryPage(driver, wait, js);
		
		driver.manage().window().maximize();
		
	}
	
	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
