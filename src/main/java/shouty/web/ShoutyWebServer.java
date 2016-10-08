package shouty.web;

import org.eclipse.jetty.http.spi.DelegatingThreadPool;
import org.eclipse.jetty.http.spi.JettyHttpServerProvider;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import shouty.DomainShouty;
import shouty.ShoutyServer;

import javax.xml.ws.Endpoint;

public class ShoutyWebServer implements ShoutyServer {
    private final Server server;
    private final int port;
    private final ShoutyWebService webService;
    private final ServletContextHandler servletContextHandler;

    public ShoutyWebServer(int port) {
        this.port = port;

        DomainShouty shoutyApi = new DomainShouty();
        webService = new ShoutyWebService(shoutyApi);

        servletContextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        servletContextHandler.setContextPath("/");
        servletContextHandler.addServlet(new ServletHolder(new ShoutyServlet(shoutyApi)), "/*");

        server = createServer(port);
    }

    public String getWsUrl() {
        return getUrl() + "/ws";
    }

    public String getUrl() {
        return getenv("URL", "http://localhost:" + port);
    }

    private Server createServer(int port) {
        System.setProperty("com.sun.net.httpserver.HttpServerProvider", JettyHttpServerProvider.class.getName());
        Server server = new Server(new DelegatingThreadPool(new QueuedThreadPool()));
        JettyHttpServerProvider.setServer(server);

        ServerConnector connector = new ServerConnector(server);
        connector.setPort(port);
        server.addConnector(connector);
        ContextHandlerCollection contexts = new ContextHandlerCollection();
        contexts.setHandlers(new Handler[]{servletContextHandler});
        server.setHandler(contexts);

        return server;
    }

    @Override
    public void start() {
        try {
            Endpoint.publish(getWsUrl(), webService);
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

    private static String getenv(String name, String defaultValue) {
        String value = System.getenv(name);
        return value != null ? value : defaultValue;
    }

    public static void main(String[] args) throws Exception {
        ShoutyWebServer shoutyServer = new ShoutyWebServer(Integer.valueOf(getenv("PORT", "8090")));
        System.out.println("Starting server...");
        shoutyServer.start();
        System.out.println("Started on " + shoutyServer.getWsUrl());
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                System.out.println("Stopping server...");
                shoutyServer.stop();
                System.out.println("Stopped");
            }
        });
    }
}
