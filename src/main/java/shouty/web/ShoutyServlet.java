package shouty.web;

import shouty.DomainShouty;
import shouty.Shouty;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.joining;

public class ShoutyServlet extends HttpServlet {
    public static final Pattern LOCATION_PATTERN = Pattern.compile("/people/([^/]+)/location");
    public static final Pattern PERSON_PATTERN = Pattern.compile("/people/([^/]+)");
    public static final Pattern SHOUTS_PATTERN = Pattern.compile("/people/([^/]+)/shouts");

    private final Shouty shouty = new DomainShouty();

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Matcher matcher = LOCATION_PATTERN.matcher(request.getPathInfo());

        if (matcher.matches()) {
            String personName = matcher.group(1);
            int location = Integer.parseInt(request.getReader().readLine());

            shouty.setLocation(personName, location);
            response.setStatus(HttpServletResponse.SC_OK); // 200
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND); // 404
            response.getWriter().format("Not found: %s", request.getPathInfo());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Matcher matcher = PERSON_PATTERN.matcher(request.getPathInfo());

        if (matcher.matches()) {
            String personName = matcher.group(1);
            List<String> messages = shouty.getMessagesHeardBy(personName);

            response.setContentType("text/html");
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().print(
                    "<ul class='messages'>" +
                    messages.stream().map(message -> "<li>" + message + "</li>").collect(joining()) +
                    "</ul>" +
                    "<form method='post' action='/people/" + personName + "/shouts'>" +
                    "<input type='text' name='message'>" +
                    "</form>");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Matcher matcher = SHOUTS_PATTERN.matcher(request.getPathInfo());

        if (matcher.matches()) {
            String personName = matcher.group(1);
            String message = request.getParameter("message");

            shouty.shout(personName, message);
            response.setStatus(HttpServletResponse.SC_CREATED); // 201
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND); // 404
            response.getWriter().format("Not found: %s", request.getPathInfo());
        }
    }
}
