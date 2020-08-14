package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignIn_PF {
	

	@FindBy(id="com.casparhealth.android.patient:id/email_text")
	WebElement click_CasparID;
	
	@FindBy(id="com.casparhealth.android.patient:id/email_text")
	WebElement clear_CasparID;
	
	@FindBy(id="com.casparhealth.android.patient:id/email_text")
	WebElement txt_CasparID;
	

	
	@FindBy(id="com.casparhealth.android.patient:id/password_text")
	WebElement click_password;
	
	@FindBy(id="com.casparhealth.android.patient:id/password_text")
	WebElement clear_password;
	
	@FindBy(id="com.casparhealth.android.patient:id/password_text")
	WebElement txt_password;

	
	
	@FindBy(id="com.casparhealth.android.patient:id/login_button")
	WebElement btn_SignIn;


	WebDriver driver;

	public  SignIn_PF(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	
	public void click_CasparID() {
		click_CasparID.click();
	}
	public void clear_CasparID() {
		clear_CasparID.clear();
	}
	public void enterCasparID(String CasparID) {
		txt_CasparID.sendKeys(CasparID);
	}

	
	
	public void click_password() {
		click_password.click();
	}
	public void clear_password() {
		clear_password.clear();
	}
	public void enterPassword(String password) {
		txt_password.sendKeys(password);
	}
	
	
	public void clickOnSignIn() {
		btn_SignIn.click();
	}

/*
  Page Object Model (POM) is a design pattern, popularly used in test automation that 
  creates Object Repository for web UI elements. The advantage of the model is that it
   reduces code duplication and improves test maintenance
 */
}
