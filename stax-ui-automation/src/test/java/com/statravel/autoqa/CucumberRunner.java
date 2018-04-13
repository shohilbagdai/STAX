package com.statravel.autoqa;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * 
 * @author STA Development Team
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/feature", plugin = { "json:target/cucumber.json", "html:target/reports" })
public class CucumberRunner {

}
