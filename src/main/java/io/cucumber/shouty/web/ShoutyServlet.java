package io.cucumber.shouty.web;

import io.cucumber.shouty.DomainShouty;
import io.cucumber.shouty.Env;
import io.cucumber.shouty.ShoutyApi;
import org.jtwig.web.servlet.JtwigRenderer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShoutyServlet extends HttpServlet {

    private static final String prefix = Env.getenv("PREFIX", "");
    private static final Pattern PERSON_PAGE_PATTERN = Pattern.compile("/people/([^/]+)");
    private static final Pattern MOVE_PATTERN = Pattern.compile("/people/([^/]+)/move");
    private static final Pattern CREATE_SHOUT_PATTERN = Pattern.compile("/people/([^/]+)/shouts");

    private final JtwigRenderer renderer = JtwigRenderer.defaultRenderer();
    private final ShoutyApi shoutyApi;

    public ShoutyServlet() {
        this(new DomainShouty());
    }

    public ShoutyServlet(ShoutyApi shoutyApi) {
        this.shoutyApi = shoutyApi;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Matcher matcher = PERSON_PAGE_PATTERN.matcher(request.getPathInfo());
        if (matcher.matches()) {
            String personName = matcher.group(1);

            renderer.dispatcherFor("classpath:/person.twig.html")
                    .with("personName", personName)
                    .with("messages", shoutyApi.getMessagesHeardBy(personName))
                    .with("location", shoutyApi.getLocation(personName))
                    .with("prefix", prefix)
                    .render(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Matcher moveMatcher = MOVE_PATTERN.matcher(request.getPathInfo());
        Matcher createShoutMatcher = CREATE_SHOUT_PATTERN.matcher(request.getPathInfo());

        if (moveMatcher.matches()) {
            String personName = moveMatcher.group(1);
            String locationString = request.getParameter(prefix + "location");
            int location = Integer.parseInt(locationString);
            shoutyApi.setLocation(personName, location);
            response.sendRedirect(request.getHeader("referer"));
        } else if (createShoutMatcher.matches()) {
            String personName = createShoutMatcher.group(1);
            String message = request.getParameter(prefix + "message");
            shoutyApi.shout(personName, message);
            response.sendRedirect(request.getHeader("referer"));
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND); // 404
            response.getWriter().format("Not found: %s", request.getPathInfo());
        }
    }
}