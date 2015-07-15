package shouty.web;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import shouty.core.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class ShoutyServlet extends HttpServlet {
    private final MustacheFactory mf = new DefaultMustacheFactory();
    private final Mustache indexTemplate = mf.compile("templates/index.mustache");
    private Map<String, Person> people;

    public ShoutyServlet(Map<String, Person> people) {
        this.people = people;
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        if (!authenticated(req)) {
            sendAuthenticationError(req, res);
            return;
        }

        Map<String,Object> context = new HashMap<>();
        context.put("personName", getName(req));
        context.put("messagesHeard", getUser(req).getMessagesHeard());
        indexTemplate.execute(res.getWriter(), context).flush();
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        if (!authenticated(req)) {
            sendAuthenticationError(req, res);
            return;
        }

        String message = req.getParameter("message");
        getUser(req).shout(message);
        res.sendRedirect("/?name=Sean");
    }

    private Person getUser(HttpServletRequest req) throws UnsupportedEncodingException {
        return people.get(getName(req));
    }

    private void sendAuthenticationError(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized: " + getName(req));
    }

    private boolean authenticated(HttpServletRequest req) throws IOException {
        return people.containsKey(getName(req));
    }

    private String getName(HttpServletRequest req) throws UnsupportedEncodingException {
        Map<String, String> queryParams = QueryString.toMap(req.getQueryString());
        return queryParams.get("name");
    }
}
