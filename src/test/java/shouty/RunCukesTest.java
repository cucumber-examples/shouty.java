package shouty;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, plugin = {"pretty", "html:target/cucumber", "rerun:target/rerun.txt", "json:target/cucumber.json"}, snippets = SnippetType.CAMELCASE)
public class RunCukesTest {
  // this is the adapter/bridge code
  // between cucumber jvm and junit
  // you do not need to edit this
}
