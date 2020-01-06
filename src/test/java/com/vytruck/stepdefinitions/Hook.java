package com.vytruck.stepdefinitions;

import com.vytruck.utilities.Driver;
import org.junit.After;
import org.junit.Before;

public class Hook {
@Before
public void setupp(){
    System.out.println("##############################");
    System.out.println("Test setup!");
    Driver.get().manage().window().maximize();


}
@After
public void closing(){
    System.out.println("##############################");
    Driver.get().quit();

}
}
