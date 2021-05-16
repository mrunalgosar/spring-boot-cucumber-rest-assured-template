package com.automation.cucumber;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

@SpringBootTest(classes = CucumberSpringBootTestConfiguration.class)
@CucumberContextConfiguration
@ComponentScan({"com.automation.cucumber"})
public class CucumberSpringBootTestConfiguration {
}
