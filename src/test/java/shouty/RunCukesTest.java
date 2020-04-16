package shouty;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "message:https://s73ktzssf4.execute-api.us-east-2.amazonaws.com/default/messages/alksjdhflskjdflksjdflkj",
        }
)
public class RunCukesTest {
}
