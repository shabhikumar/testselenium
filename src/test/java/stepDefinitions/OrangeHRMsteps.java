package stepDefinitions;

import DataProviders.ConfigFileReader;
import Managers.AllDriverManager;
import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRMsteps {

    protected  WebDriver driver;
    ConfigFileReader configFileReader = new ConfigFileReader();
    Hooks hooks = new Hooks();

    @Given("I launch chrome browser")
    public void i_launch_chrome_browser() {
        hooks.setup();
        driver = Hooks.getDriver();
    }

    @When("I open orange hrm home page")
    public void i_open_orange_hrm_home_page() {
        hooks.launchBrowser();
    }
    @Then("I verify that the logo present on page")
    public void i_verify_that_the_logo_present_on_page() {
        String login = driver.findElement(By.xpath("//div[contains(@class,'orangehrm')]//h5")).getText();
        Assert.assertEquals("Login", login);
    }
    @Then("close browser")
    public void close_browser() {
        driver.close();
    }

    @And("I enter username as {string} and password as {string}")
    public void iEnterUsernameAsAndPasswordAs(String uname, String password) {
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(uname);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Then("I verify login should be successful")
    public void iVerifyLoginShouldBeSuccessful() {
        String log = driver.findElement(By.xpath("(//div[contains(@class,'topbar')])[1]//h6")).getText();
        Assert.assertEquals("Dashboard", log);
    }
}
