package com.vytruck.pages;

import com.vytruck.utilities.BrowserUtils;
import com.vytruck.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CalenderEventPage extends BasePage{

    @FindBy(xpath = "//thead/tr/th")
    public List<WebElement> columnNames;


public CalenderEventPage(){
    PageFactory.initElements(Driver.get(),this);
}
public  List<String> getColumnames(){
    return BrowserUtils.getlistofString(columnNames);
}


}
