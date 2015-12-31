package shouty.web;

import shouty.DomainShouty;
import shouty.Shouty;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShoutyServlet extends HttpServlet {

    public static final Pattern PERSON_PAGE_PATTERN = Pattern.compile("/people/([^/]+)");
    public static final Pattern MOVE_PATTERN = Pattern.compile("/people/([^/]+)/move");
    public static final Pattern SHOUTS_PATTERN = Pattern.compile("/people/([^/]+)/shouts");

    private final Shouty shouty = new DomainShouty();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Matcher matcher = PERSON_PAGE_PATTERN.matcher(request.getPathInfo());
        if (matcher.matches()) {
            String personName = matcher.group(1);

            response.setContentType("text/html");
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().format("" +
                    "<form method=post action=/people/%s/shouts>\n" +
                    "  <input type=text name=message id=message>\n" +
                    "</form>", personName);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Matcher matcher = MOVE_PATTERN.matcher(request.getPathInfo());
        if (matcher.matches()) {
            String personName = matcher.group(1);
            String locationString = request.getReader().readLine();
            int location = Integer.parseInt(locationString);
            shouty.setLocation(personName, location);
            response.setStatus(HttpServletResponse.SC_CREATED); // 201
        } else {
            matcher = SHOUTS_PATTERN.matcher(request.getPathInfo());
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
}