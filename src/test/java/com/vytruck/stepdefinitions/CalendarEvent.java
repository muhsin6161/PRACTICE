package com.vytruck.stepdefinitions;

import com.vytruck.pages.BasePage;
import com.vytruck.pages.CalenderEventPage;
import com.vytruck.pages.LoginPage;
import com.vytruck.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class CalendarEvent {
    CalenderEventPage calendarEventsPage=new CalenderEventPage();
    @Then("navigate to {string} then {string}")
    public void navigate_to_then(String string, String string2) {
        LoginPage loginPage=new LoginPage();
        BasePage.waitUntilLoaderMaskDisappear();
        loginPage.navigateTo(string,string2);

        System.out.println(loginPage.getPageTitle());
    }

    @Then("user verifies that column names are displayed")
    public void user_verifies_that_column_names_are_displayed(List<String> dataTable) {
        Assert.assertEquals(dataTable,calendarEventsPage.getColumnames());
        System.out.println(calendarEventsPage.getColumnames());
    }


}
