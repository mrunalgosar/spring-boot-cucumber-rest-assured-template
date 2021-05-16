package com.automation.cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "classpath:features",
        glue = "com.automation.cucumber"
)
public class CucumberTestSuiteIT extends AbstractTestNGCucumberTests {

    @DataProvider(parallel = true)
    public Object[][] tests() {
        return super.scenarios();
    }
}
