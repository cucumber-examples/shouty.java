package shouty.features;

import cucumber.api.DataTable;
import cucumber.api.Transpose;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import shouty.core.Network;
import shouty.core.Person;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.singletonList;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class Stepdefs {

    private final ShoutSupport shoutSupport;
    private Network network;

    public Stepdefs(WebShoutSupport webShoutSupport, DomainShoutSupport domainShoutSupport) {
        if ("web".equals(System.getProperty("shouty.testDepth"))) {
            this.shoutSupport = webShoutSupport;
        } else {
            this.shoutSupport = domainShoutSupport;
        }
    }

    @Given("^the range is (\\d+)$")
    public void the_range_is(int range) throws Throwable {
        network = new Network(range);
    }

    public static class Whereabouts {
        public String name;
        public int location;
    }

    @Given("^Sean has bought (\\d+) credits$")
    public void sean_has_bought_credits(int credits) throws Throwable {
        shoutSupport.getPeople().get("Sean").setCredits(credits);
    }

    @Given("^the following people:$")
    public void the_following_people(@Transpose List<Whereabouts> whereabouts) throws Throwable {
        for (Whereabouts whereabout : whereabouts) {
            shoutSupport.getPeople().put(whereabout.name, new Person(network, whereabout.location));
        }
    }

    @When("^Sean shouts a message containing the word \"(.*?)\"$")
    public void sean_shouts_a_message_containing_the_word(String word) throws Throwable {
        shoutSupport.seanShout("a message containing the word " + word);
    }

    @When("^Sean shouts (\\d+) messages containing the word \"(.*?)\"$")
    public void sean_shouts_messages_containing_the_word(int num, String word) throws Throwable {
        for (int j = 0; j < num; j++) {
            shoutSupport.seanShout("a message containing the word " + word);
        }
    }

    @When("^Sean shouts a message$")
    public void sean_shouts_a_message() throws Throwable {
        shoutSupport.seanShout("here is a message");
    }

    @When("^Sean shouts a long message$")
    public void sean_shouts_a_long_message() throws Throwable {
        String longMessage = "";
        for (int i = 0; i < 180; i++) longMessage += "x";
        shoutSupport.seanShout(longMessage);
    }

    @When("^Sean shouts an over-long message$")
    public void sean_shouts_an_over_long_message() throws Throwable {
        String longMessage = "";
        for (int i = 0; i < 181; i++) longMessage += "x";
        shoutSupport.seanShout(longMessage);
    }

    @When("^Sean shouts (\\d+) over-long message$")
    public void sean_shouts_over_long_message(int num) throws Throwable {
        for (int j = 0; j < num; j++) {
            String longMessage = "";
            for (int i = 0; i < 181; i++) longMessage += "x";
            shoutSupport.seanShout(longMessage);
        }
    }

    @When("^Sean shouts \"(.*?)\"$")
    public void sean_shouts(String message) throws Throwable {
        shoutSupport.seanShout(message);
    }

    @When("^Sean shouts:$")
    public void sean_shouts_longer_message(String message) throws Throwable {
        shoutSupport.seanShout(message);
    }

    @Then("^Lucy hears Sean's message$")
    public void lucy_hears_Sean_s_message() throws Throwable {
        lucy_hears_all_Sean_s_messages();
    }

    @Then("^Lucy hears all Sean's messages$")
    public void lucy_hears_all_Sean_s_messages() throws Throwable {
        List<String> heardByLucy = shoutSupport.getMessagesHeardBy("Lucy");
        List<String> messagesFromSean = shoutSupport.getMessagesShoutedBy("Sean");

        assertEquals(messagesFromSean, heardByLucy);
    }

    @Then("^Lucy hears the following messages:$")
    public void lucy_hears_the_following_messages(DataTable expectedMessages) throws Throwable {
        List<List<String>> actualMessages = new ArrayList<List<String>>();
        List<String> heard = shoutSupport.getMessagesHeardBy("Lucy");
        for (String message : heard) {
            actualMessages.add(singletonList(message));
        }
        expectedMessages.diff(actualMessages);
    }

    @Then("^(Larry|Lucy) does not hear Sean's message$")
    public void listener_does_not_hear_Sean_s_message(String listenerName) throws Throwable {
        List<String> heardByListener = shoutSupport.getMessagesHeardBy(listenerName);
        List<String> messagesFromSean = shoutSupport.getMessagesShoutedBy("Sean");
        String[] messagesFromSeanArray = messagesFromSean.toArray(new String[messagesFromSean.size()]);
        assertThat(heardByListener, not(hasItems(messagesFromSeanArray)));
    }

    @Then("^nobody hears Sean's message$")
    public void nobody_hears_Sean_s_message() throws Throwable {
        List<String> messagesFromSean = shoutSupport.getMessagesShoutedBy("Sean");
        String[] messagesFromSeanArray = messagesFromSean.toArray(new String[messagesFromSean.size()]);
        for (String name : shoutSupport.getPeople().keySet()) {
            assertThat(shoutSupport.getMessagesHeardBy(name), not(hasItems(messagesFromSeanArray)));
        }
    }

    @Then("^Sean should have (\\d+) credits$")
    public void sean_should_have_credits(int credits) throws Throwable {
        assertEquals(credits, shoutSupport.getPeople().get("Sean").getCredits());
    }
}
