package shouty.web;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import shouty.DomainShouty;
import shouty.ShoutyApi;
import shouty.ShoutyServer;

public class ShoutyWebServer implements ShoutyServer {
    private final Server server;

    public ShoutyWebServer(int port, ShoutyApi shoutyApi) {
        server = new Server(port);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
        context.addServlet(new ServletHolder(new ShoutyServlet(shoutyApi)), "/*");
    }

    @Override
    public void start() {
        try {
            server.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void stop() {
        try {
            server.stop();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception {
        new ShoutyWebServer(9988, new DomainShouty()).start();
    }

}
