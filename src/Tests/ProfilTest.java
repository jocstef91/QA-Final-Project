package Tests;

import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfilTest extends BasicTest {
	
	String firstname = "Janko";
	String lastname = "Jankovic";
	String address = "23 blvd";
	String phone = "+15550123";
	String zip = "18000";
	String country = "United States";
	String state = "Iowa";
	String city = "Ames";
	
	

	@Test (priority = 1)
	public void editProfil() throws InterruptedException {
		
		driver.get(baseUrl+"/guest-user/login-form");
		popup.getCloseBtn().click();
		login.fillLoginData(username, password);
		super.mesage=notif.loginMessage();
		Assert.assertTrue(super.mesage.contains("Login Successfull"),"Login Unsuccessfull");
		profil.getprofileBtn().click();
		profil.fillProfile(firstname, lastname, address, phone, zip, country, state, city);
		super.mesage=notif.loginMessage();
		Assert.assertTrue(super.mesage.contains("Setup Successful"), "Setup Unsuccessfull");
		auth.getAuth(1);
		super.mesage=notif.loginMessage();
		Assert.assertTrue(super.mesage.contains("Logout Successfull!"), "Logout Unsuccessfull!");
		
	}
	
	@Test (priority = 2)
	public void changeProfilPicture() throws IOException {
		driver.get(baseUrl+"/guest-user/login-form");
		popup.getCloseBtn().click();
		login.fillLoginData(username, password);
		super.mesage=notif.loginMessage();
		Assert.assertTrue(super.mesage.contains("Login Successfull"),"Login Unsuccessfull");
		profil.getprofileBtn().click();
		String imgPath = new File("img/jokic.jpg").getCanonicalPath();
		profil.profilePicture(imgPath);
		super.mesage=notif.loginMessage();
		Assert.assertTrue(super.mesage.contains("Profile Image Uploaded Successfully"),"Profile Image Is not Uploaded");
		notif.whaitMsgToDisapear();
		profil.DeleteImgBtn();
		super.mesage=notif.loginMessage();
		Assert.assertTrue(super.mesage.contains("Profile Image Deleted Successfully"),"Profile Image Is not Deleted");
		notif.whaitMsgToDisapear();
		auth.getAuth(1);
		super.mesage=notif.loginMessage();
		Assert.assertTrue(super.mesage.contains("Logout Successfull!"),"Logout Unsuccessfull!");
		
	}
	
	
	

}
 