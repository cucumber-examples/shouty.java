package io.cucumber.shouty;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = false, plugin = {"pretty", "html:target/cucumber", "rerun:target/rerun.txt"})
public class RunCukesTest {
}
