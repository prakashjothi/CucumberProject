package org.stepdefinition;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps {
	
	static WebDriver driver;

	@Given("The user should be in facebook login page")
	public void the_user_should_be_in_facebook_login_page() {
	    // Write code here that turns the phrase above into concrete actions
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    
	}

	@When("The user has to fill username and password")
	public void the_user_has_to_fill_username_and_password(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
		List<List<String>> lists = dataTable.asLists();
		driver.findElement(By.id("email")).sendKeys(lists.get(1).get(0));
		driver.findElement(By.id("pass")).sendKeys(lists.get(1).get(1));
	   
	}

	@When("The user has to click login button")
	public void the_user_has_to_click_login_button() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.name("login")).click();
	    
	}

	@Then("The user should navigate to invalid login page")
	public void the_user_should_navigate_to_invalid_login_page() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		Thread.sleep(2000);
		Assert.assertTrue("Verify username/password", driver.getCurrentUrl().contains("privacy"));
	    
	}


}
