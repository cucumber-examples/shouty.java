package shouty.web;

import org.junit.Before;
import org.junit.Test;
import shouty.core.Person;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ShoutyServletTest extends BaseServletTest {
    private final HashMap<String, Person> people = new HashMap<String, Person>(){{
        put("Sean", mock(Person.class));
    }};

    @Test
    public void getShouldRespondWithHomepageForKnownUser() throws Exception {
        get("/?name=Sean");
        assertEquals(200, lastResponse.getStatus());
    }

    @Test
    public void getShouldRespondWith401WhenUserNotRecognised() throws Exception {
        get("/?name=Unknown");
        assertEquals(401, lastResponse.getStatus());
        assertThat(lastResponse.getErrorMessage(), containsString("Unauthorized"));
    }

    @Test
    public void getRendersAFormForPostingMessagesOnTheHomepage() throws Exception {
        get("/?name=Sean");
        assertNotNull(page.select("form [name=message]"));
        assertNotNull(page.select("form [type=submit]"));
    }

    @Test
    public void getDisplaysMessagesHeardByUser() throws Exception {
        List<String> messages = Arrays.asList("one", "two");
        Person lucy = mock(Person.class);
        when(lucy.getMessagesHeard()).thenReturn(messages);
        people.put("Lucy", lucy);
        get("/?name=Lucy");
        assertEquals("one", page.select(".message").get(0).text());
        assertEquals("two", page.select(".message").get(1).text());
    }

    @Test
    public void postShoutsMessageFromTheGivenUser() throws Exception {
        Person sean = people.get("Sean");
        Map<String, String> params = new HashMap<>();
        params.put("message", "Test message");
        post("/shout?name=Sean", params);
        verify(sean).shout("Test message");
    }

    @Test
    public void postRedirectsBackToHomePageKeepingUserLoggedIn() throws Exception {
        Map<String, String> params = new HashMap<>();
        params.put("message", "Test message");
        post("/shout?name=Sean", params);
        assertEquals(302, lastResponse.getStatus());
        assertEquals("/?name=Sean", lastResponse.getRedirectedUrl());
    }

    @Override
    protected ShoutyServlet createServlet() {
        return new ShoutyServlet(people);
    }
}