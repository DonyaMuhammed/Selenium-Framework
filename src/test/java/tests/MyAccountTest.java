package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegistrationPage;

public class MyAccountTest extends TestBase
{
	HomePage homeObject ; 
	UserRegistrationPage registerObject ; 
	LoginPage loginObject ; 
	MyAccountPage myAccountObject ; 
	String oldPassword = "12345678" ; 
	String newPassword = "123456" ; 
	String firstName = "Donya" ; 
	String lastName = "Mohammed" ; 
	String email = "test4h343@gmail.com" ; 
	

	@Test(priority=1)
	public void UserCanRegisterSuccssfully()
	{
		homeObject = new HomePage(driver); 
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver); 
		registerObject.userRegistration(firstName, lastName, email, oldPassword);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	}
	
	@Test(priority=2)
	public void RegisteredUserCanChangePassword() 
	{
		myAccountObject = new MyAccountPage(driver) ; 
		registerObject.openMyAccountPage();
		myAccountObject.openChangePasswordPage();
		myAccountObject.ChangePassword(oldPassword, newPassword);
		Assert.assertTrue(myAccountObject.resultLbl.getText().contains("Password was changed"));
		myAccountObject.closeSuccessBar();
	}
	

}
