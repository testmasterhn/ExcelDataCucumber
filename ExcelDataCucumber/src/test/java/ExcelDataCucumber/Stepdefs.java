package ExcelDataCucumber;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pageobjects.LoginPage;
import cucumber.api.java.en.Then;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import common.DataHelper;

public class Stepdefs {
	WebDriver driver;
	LoginPage loginPage;
	DataHelper dataHelper;
	List<HashMap<String, String>> data;
	public Stepdefs() {
		this.driver = Hooks.driver;
		loginPage = new LoginPage(this.driver);
		this.dataHelper = new DataHelper(System.getProperty("user.dir")+ "\\src\\test\\resources\\Data.xlsx", "sheet1");
		this.data = this.dataHelper.data();
	}
	@Given("^I am staying login page$")
	public void i_am_staying_login_page() throws Exception {
	    loginPage.OpenPage();
	}

	@When("^I input data from excel file on (\\d+)$")
	public void i_input_data_from_excel_file_on(int rowIndex) throws Exception {
	    loginPage.txtUsername.sendKeys(this.data.get(rowIndex-1).get("email"));
	    loginPage.txtPassword.sendKeys(this.data.get(rowIndex-1).get("password"));
	    loginPage.btnLogin.click();
	}

	@Then("^I should see the corresponding message from each (\\d+)$")
	public void i_should_see_the_corresponding_message_from_each(int rowIndex) throws Exception {
	    String tooltip = loginPage.txtUsername.getAttribute("data-original-title");
	    Assert.assertEquals(tooltip, this.data.get(rowIndex-1).get("message"));
	}
}