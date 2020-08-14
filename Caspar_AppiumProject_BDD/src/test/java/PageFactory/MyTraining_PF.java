package PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyTraining_PF {
	
	@FindBy(id="com.casparhealth.android.patient:id/my_training_arrow")
	WebElement btn_Go ;

	@FindBy(id="com.casparhealth.android.patient:id/ready_button")
	WebElement btn_IamReady ;

	@FindBy(id="com.casparhealth.android.patient:id/start_button")
	WebElement btn_Start ;


	WebDriver driver;

	public MyTraining_PF(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}



	public void clickOnGo() {
		btn_Go.click();
	}

	public void clickOnIamReady() {
		btn_IamReady.click();
	}
	
	public void clickOnStart() {
		btn_Start.click();
	}
	
	/*
	  Page Object Model (POM) is a design pattern, popularly used in test automation that 
	 creates Object Repository for web UI elements. The advantage of the model is that it
	 reduces code duplication and improves test maintenance 
	 */
}
