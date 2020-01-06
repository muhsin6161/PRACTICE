package com.vytruck.stepdefinitions;

import com.vytruck.pages.BasePage;
import com.vytruck.pages.LoginPage;
import com.vytruck.utilities.ConfigurationReader;
import com.vytruck.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;


public class LoginstepDefinition {
   LoginPage loginPage=new LoginPage();
    @Given("Go to login page")
    public void go_to_login_page() {
        String url= ConfigurationReader.getProperty("url");
        Driver.get().get(url);
    }

    @Then("Enter valid username  and password")
    public void enter_valid_username_and_password() {
        String username=ConfigurationReader.getProperty("user_name");
        String password=ConfigurationReader.getProperty("password");
        loginPage.login(username,password);
    }

    @Then("verify pagetitle is {string} displayed")
    public void verify_pagetitle_is_displayed(String string) {
        BasePage.waitUntilLoaderMaskDisappear();
        Assert.assertEquals(string,loginPage.getPageTitle());

    }

}
