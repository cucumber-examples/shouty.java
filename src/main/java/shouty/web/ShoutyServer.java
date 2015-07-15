package shouty.web;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import shouty.core.Person;

import java.util.Map;

public class ShoutyServer {
    private Server server;

    public void start(Map<String, Person> people, int port) throws Exception {
        ServletHandler handler = new ServletHandler();
        ShoutyServlet shoutyServlet = new ShoutyServlet(people);
        handler.addServletWithMapping(new ServletHolder(shoutyServlet), "/*");
        server = new Server(port);
        server.setHandler(handler);
        server.start();
    }

    public void stop() throws Exception {
        server.stop();
        server.join();
    }
}
