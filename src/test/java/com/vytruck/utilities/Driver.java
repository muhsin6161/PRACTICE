package com.vytruck.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Driver {

    private static  WebDriver driver;

private Driver(){

}
public static WebDriver get(){
   String browser=ConfigurationReader.getProperty("browser");
    if(driver==null & browser.equals("chrome")){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
    }
else if(driver==null & browser.equals("firefox")){
    WebDriverManager.firefoxdriver().setup();
    driver=new FirefoxDriver();
    }
return driver;
}




}
