package shouty.web;

import shouty.DomainShouty;
import shouty.Shouty;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShoutyServlet extends HttpServlet {

    public static final Pattern MOVE_PATTERN = Pattern.compile("/people/([^/]+)/move");

    private final Shouty shouty = new DomainShouty();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_OK);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String locationString = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8")).readLine();
        int location = Integer.parseInt(locationString);

        String path = request.getPathInfo();
        Matcher matcher = MOVE_PATTERN.matcher(path);
        if (matcher.matches()) {
            String personName = matcher.group(1);
            System.out.println("personName = " + personName);
            shouty.setLocation(personName, location);

            response.setStatus(HttpServletResponse.SC_CREATED); // 201
        }
    }
}