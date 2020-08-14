package StepDefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.*;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

import PageFactory.MyTraining_PF;
import PageFactory.SignIn_PF;


public class TestStep {

		WebDriver driver = null;
		SignIn_PF SignIn;
		MyTraining_PF Training;


		public static void main(String args[])
		{
		}

		@Given("Application is installed and launched")
		public void application_is_installed_and_launched() {

			AndroidDriver driver=null;
			DesiredCapabilities cap = new DesiredCapabilities();
			String udid = "RF8MC0P6C2B";
			File app = new File(System.getProperty("user.dir")+"/Resources/CasparHealth_android_patient.apk");

			cap.setJavascriptEnabled(true);
			cap.setCapability("deviceName", "Galaxy S10+");
			cap.setCapability("udid", udid);
			cap.setCapability("app", app);
			try {
				driver=new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);

				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}


		@And("The User is on the SignIn page")
		public void the_user_is_on_the_sign_in_page() {
			/* Home Page Verification */
			if(driver.findElement(By.id("com.casparhealth.android.patient:id/title")).isDisplayed())
			{
				System.out.println("Welcome to  is displayed ");
			}
		}


		@When("The User fills {string} and {string}")
		public void WhenTheUserFillsZUMAnd(String CasparID, String password) {
			// Used POM (Page Object Model) for this part : SignIn_PF class Created

			SignIn = new SignIn_PF(driver);

			SignIn.click_CasparID();
			SignIn.clear_CasparID();
			SignIn.enterCasparID(CasparID);

			SignIn.click_password();
			SignIn.clear_password();
			SignIn.enterPassword(password);

		}


		@And("The User clicks on SignIn button")
		public void the_user_clicks_on_sign_in_button() {	
			// Used POM (Page Object Model) for this part : SignIn_PF class Created
			SignIn = new SignIn_PF(driver);

			SignIn.clickOnSignIn();

			//checking SignIN process
			if
			(driver.findElement(By.id("com.casparhealth.android.patient:id/textinput_error")).isDisplayed()) {
				Assert.fail("Email or password is incorrect.");
			}
			else 
			{
				Assert.assertEquals(true, driver.findElement(By.id("com.casparhealth.android.patient:id/title_my_training_text")).isDisplayed(),"somthing went wrrong"); 				
			}
		}




		@Then("The User is navigated to the My Training tab")
		public void the_user_is_navigated_to_the_my_training_tab() {
			System.out.println("action_today_activities");
		}


		@And("The User clicks on the Go button on the My Training section")
		public void the_user_clicks_on_the_go_button_on_the_my_training_section() {
			// Used POM (Page Object Model) for this part : MyTraining_PF class Created
			Training = new MyTraining_PF(driver);

			Training.clickOnGo();
		}


		@Then("The app should display the number of Exercises, number of Minutes and the You Will Need section")
		public void the_app_should_display_the_number_of_exercises_number_of_minutes_and_the_you_will_need_section() {

		}


		@And("The User clicks on the I am Ready button on the My Training page")
		public void the_user_clicks_on_the_i_am_ready_button_on_the_my_training_page() {
			// Used POM (Page Object Model) for this part : MyTraining_PF class Created
			Training = new MyTraining_PF(driver);
			Training.clickOnIamReady();
		}


		@Then("The app should display the Video training, Sets, Sec, Tools, Instruction and Settings")
		public void the_app_should_display_the_video_training_sets_sec_tools_instruction_and_settings() {

		}


		@And("The User clicks on the Start button on the My Training page")
		public void the_user_clicks_on_the_start_button_on_the_my_training_page() {
			// Used POM (Page Object Model) for this part : MyTraining_PF class Created
			Training = new MyTraining_PF(driver);
			Training.clickOnStart();
		}


		@Then("The app should count the numbers from {int} to {int}")
		public void the_app_should_count_the_numbers_from_to(Integer int1, Integer int2) {

		}


		@And("The app should start the duration of exercise")
		public void the_app_should_start_the_duration_of_exercise() {

		}


		@Then("The app should display the Well done! page when the app finishes any step")
		public void the_app_should_display_the_well_done_page_when_the_app_finishes_any_step() throws InterruptedException {


			try{
				(new WebDriverWait(driver, 180))
				.until(ExpectedConditions.presenceOfElementLocated(By.id("com.casparhealth.android.patient:id/caption")));
			}
			catch(TimeoutException exception) {
				Assert.fail("xxxxxxx Failed:  Well done! Not found xxxxxxx");
			}


			String expectedTitle="Well done!";
			String actualTitle=driver.findElement(By.id("com.casparhealth.android.patient:id/caption")).getText();
			Assert.assertEquals(expectedTitle,actualTitle,"xxxxxxx- Failed: Title didn't match -xxxxxx");


			Thread.sleep(4000);
			driver.quit();
		}

	}