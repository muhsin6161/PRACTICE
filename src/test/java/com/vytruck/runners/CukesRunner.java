package com.vytruck.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
             glue="com/vytruck/stepdefinitions/",
        dryRun = false,
        tags = "@AA"

)

public class CukesRunner {

}
