package com.vytruck.pages;

import com.vytruck.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{
    @FindBy(id = "prependedInput") //this line will initialize web element
    public WebElement userNameInput;

    @FindBy(id = "prependedInput2")//without findby, web element will be null
    public WebElement passwordInput;

    @FindBy(id = "_submit")
    public WebElement loginButton;

    @FindBy(css = "[class='alert alert-error']")
    public WebElement warningMessage;

public LoginPage(){
    PageFactory.initElements(Driver.get(),this);
}

public void login(String username,String password){
    userNameInput.sendKeys(username);
    passwordInput.sendKeys(password, Keys.ENTER);

}




}
