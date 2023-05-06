package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePage {

	WebDriver driver=null;
	
	
	@Given("Web Browser is open")
	public void web_browser_is_open() {
		System.setProperty("webdriver.chrome.driver", "D:/eclipse-workspace/AutomationTest/src/test/resources/Drivers/chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		 chromeOptions.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(chromeOptions);
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

		driver.manage().window().maximize();
		System.out.println("Chrome driver launched successfully");
	}

	@And("User is on google search page")
	public void user_is_on_google_search_page() {
		driver.get("https://www.google.com/");
		System.out.println("User has been navigated to Google search page");
	    
	}

	@When("User enters a search text as J.P Morgan")
	public void user_enters_a_search_text_as_j_p_morgan() {
	   driver.findElement(By.name("q")).sendKeys("J. P. Morgan");
	}
	
	@And("Hits Enter")
	public void click_on_search_button() {
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		System.out.println("Search button is successfully clicked");
	}


	@Then("User is navigated to results page")
	public void user_is_navigated_to_result_page() {
		driver.getPageSource().contains("J.P. Morgan | Official Website");
		System.out.println("User has been navigated to result page successfully");
	}

	@And("User click on first link displayed from results")
	public void user_click_on_first_link_displayed_from_results() {
		driver.findElement(By.xpath("//h3[text()=\"J.P. Morgan | Official Website\"]/parent::a")).click();
		System.out.println("User is able to click on 1st link from results");
	}

	@Then("User navigated to J.P morgan Home Page and J.P morgan Logo is displayed")
	public void user_navigated_to_j_p_morgan_home_page_and_j_p_morgan_logo_is_displayed() {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		Boolean result=driver.findElement(By.xpath("//div[contains(@class,'logo-desktop')]//a/img[@class=\"first-logo\"]")).isDisplayed();
		if(result==true) {
			System.out.println("User has been navigated to J.P morgan home page and logo is displaying successfully");
		}
		else
		{
			System.out.println("Logo is not displaying");
		}
		
	}


}
