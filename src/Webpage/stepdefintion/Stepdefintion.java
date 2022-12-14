package Webpage.stepdefintion;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.Cartpage;
import pageobject.Checkoutpage;
import pageobject.Confirmationpage;
import pageobject.Loginpage;
import pageobject.Productcatalog;

public class Stepdefintion {
	WebDriver driver;

	@Given("^I logged with useremail (.+) and password (.+)$")
	public void I_logged_with_useremail_and_password(String email, String password) throws IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\r.karunya\\Downloads\\ChromeDriver\\Chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();

		Loginpage Login = new Loginpage(driver);
		Login.goTo();
		Login.LoginApplication();
	}

	@When("I added the product to cart")
	public void I_added_the_product_to_cart() throws IOException, InterruptedException {
		Productcatalog product = new Productcatalog(driver);
		product.addItems();
		Cartpage cart = new Cartpage(driver);
		cart.Cartpage();
		cart.verifyproduct();

	}

	@And("products are checkout")
	public void products_are_checkout() throws InterruptedException, IOException {
		Checkoutpage check = new Checkoutpage(driver);
		check.checkoutpage();
	}

	@Then("confirmation page will be displayed")
	public void confirmation_page_will_be_displayed() {
		Confirmationpage confirm = new Confirmationpage(driver);
		confirm.verifyConfirmationMessage();
	}
}