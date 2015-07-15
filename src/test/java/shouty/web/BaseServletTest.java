package shouty.web;

import cucumber.api.java.Before;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.util.Map;

// Base class for conveniently testing a servlet
public abstract class BaseServletTest {
    protected Document page;
    protected MockHttpServletResponse lastResponse;
    private HttpServlet servlet;

    @Before
    public HttpServlet getServlet() {
        if (servlet != null) return servlet;
        return servlet = createServlet();
    }

    protected abstract HttpServlet createServlet();

    protected void get(String pathAndQuery) throws ServletException, IOException {
        MockHttpServletRequest request = createRequest(pathAndQuery);
        request.setMethod("GET");
        doRequest(request);
    }

    protected void post(String pathAndQuery, Map<String, String> params) throws ServletException, IOException {
        MockHttpServletRequest request = createRequest(pathAndQuery);
        request.addParameters(params);
        request.setMethod("POST");
        doRequest(request);
    }

    private void doRequest(HttpServletRequest request) throws ServletException, IOException {
        MockHttpServletResponse response = new MockHttpServletResponse();
        getServlet().service(request, response);
        page = Jsoup.parse(response.getContentAsString());
        lastResponse = response;
    }

    private MockHttpServletRequest createRequest(String pathAndQuery) {
        URI uri = getUri(pathAndQuery);
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setRequestURI(uri.getPath());
        request.setQueryString(uri.getQuery());
        return request;
    }

    private URI getUri(String pathAndQuery) {
        return URI.create("http://example.org" + pathAndQuery);
    }
}