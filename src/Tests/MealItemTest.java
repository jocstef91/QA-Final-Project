package Tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MealItemTest extends BasicTest {

	@Test (priority = 1)
	public void addMeal() throws InterruptedException {
		driver.get(baseUrl+"meal/lobster-shrimp-chicken-quesadilla-combo");
		popup.getCloseBtn().click();
		
		meal.setQty().sendKeys(Keys.chord(Keys.CONTROL, "a"));
		meal.setQty().sendKeys("12");
		meal.getAddToCart().click();
		super.mesage=notif.loginMessage();
		String lines[] = mesage.split("\\r?\\n");
		Assert.assertTrue(lines[0].contains("The Following Errors Occurred:"),"Error Ocured");
		Assert.assertTrue(lines[1].contains("Please Select Location"),"Error Ocured");
		notif.whaitMsgToDisapear();
		meal.getLocation().click();
		popup.onClickLocation("City Center - Albany");
		Thread.sleep(2000);
		meal.setQty().sendKeys(Keys.chord(Keys.CONTROL, "a"));
		meal.setQty().sendKeys("12");
		meal.getAddToCart().click();
		super.mesage=notif.loginMessage();
		Assert.assertTrue(super.mesage.contains("Meal Added To Cart"),"Meal Isnt Added To Cart");
		
	}
	@Test (priority = 2)
	public void favouriteMeal() throws InterruptedException {
		driver.get(baseUrl+"meal/lobster-shrimp-chicken-quesadilla-combo");
		popup.getCloseBtn().click();
		meal.getAddtoFav().click();
		super.mesage=notif.loginMessage();
		Assert.assertTrue(super.mesage.contains("Please login first!"),"You are logged in!");
		notif.whaitMsgToDisapear();
		driver.get(baseUrl+"guest-user/login-form");
		login.fillLoginData(username, password);
		driver.get(baseUrl+"meal/lobster-shrimp-chicken-quesadilla-combo");
		Thread.sleep(2000);
		meal.getAddtoFav().click();
		Thread.sleep(3000);
		
		super.mesage=notif.loginMessage();
		Assert.assertTrue(super.mesage.contains("Product has been added to your favorites."),
				"Product has not been added to favorites.");
		
		
	}
	@Test (priority = 3)
	public void clearMeal() throws IOException, InterruptedException {
		File file = new File("data/Data.xlsx"); 
		FileInputStream fis = new FileInputStream(file); 
		XSSFWorkbook wb = new XSSFWorkbook(fis); 
		XSSFSheet sheet = wb.getSheet("Meals");
		
		driver.get(baseUrl+"meals");
		popup.onClickLocation("City Center - Albany");
		
		Thread.sleep(2000);
		for (int i = 1; i < 6; i++) {
			String site=sheet.getRow(i).getCell(0).getStringCellValue(); 
			driver.get(site); 
			Thread.sleep(2000);
			meal.setQty().sendKeys(Keys.chord(Keys.CONTROL, "a"));
			meal.setQty().sendKeys("2");
			meal.getAddToCart().click();
			
			super.mesage=notif.loginMessage();
			sa.assertTrue(super.mesage.contains("Meal Added To Cart"),
					"Meal Isnt Added To Cart.");
			notif.whaitMsgToDisapear();
		}
		cart.clearAll();
		super.mesage=notif.loginMessage();
		Assert.assertTrue(super.mesage.contains("All meals removed from Cart successfully"),"Cart is not empty");
		notif.whaitMsgToDisapear();
		sa.assertAll();
	}
}
