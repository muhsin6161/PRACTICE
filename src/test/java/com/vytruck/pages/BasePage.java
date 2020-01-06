package com.vytruck.pages;

import com.vytruck.utilities.BrowserUtils;
import com.vytruck.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    @FindBy(css = "div[class='loader-mask shown']")
    public WebElement loaderMask;
    @FindBy(css = "[class=\"oro-subtitle\"]") //this line will initialize web element
    public WebElement pagetitle;

public BasePage(){
    PageFactory.initElements(Driver.get(),this);
}

public String getPageTitle(){
    BrowserUtils.wait(5);
    return pagetitle.getText();

}
public static void waitUntilLoaderMaskDisappear(){
    WebDriverWait wait=new WebDriverWait(Driver.get(),30);
    wait.until(ExpectedConditions.invisibilityOfElementLocated((By.cssSelector("div[class='loader-mask shown']"))));

}
    public void navigateTo(String moduleName, String subModuleName) {
        Actions actions = new Actions(Driver.get());
        String moduleLocator = "//*[normalize-space()='" + moduleName + "' and @class='title title-level-1']";
        String subModuleLocator = "//*[normalize-space()='" + subModuleName + "' and @class='title title-level-2']";

        WebDriverWait wait = new WebDriverWait(Driver.get(), 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(moduleLocator)));

        WebElement module = Driver.get().findElement(By.xpath(moduleLocator));
        wait.until(ExpectedConditions.visibilityOf(module));
        wait.until(ExpectedConditions.elementToBeClickable(module));

        waitUntilLoaderMaskDisappear();

        BrowserUtils.clickWithWait(module); //if click is not working well
        WebElement subModule = Driver.get().findElement(By.xpath(subModuleLocator));
        if (!subModule.isDisplayed()) {
            actions.doubleClick(module).doubleClick().build().perform();
            try {
                wait.until(ExpectedConditions.visibilityOf(subModule));
            } catch (Exception ex) {
                ex.printStackTrace();
                BrowserUtils.clickWithJS(module);
            }
        }
        BrowserUtils.clickWithWait(subModule); //if click is not working well
        //it waits until page is loaded and ajax calls are done
        BrowserUtils.waitForPageToLoad(10);
    }
}
