package shouty.web;

import shouty.DomainShouty;
import shouty.ShoutyApi;
import shouty.ShoutyServer;

import javax.xml.ws.Endpoint;

public class ShoutySoapServer implements ShoutyServer {

    private final Endpoint endpoint;

    public ShoutySoapServer(Endpoint endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    public void start() {
    }

    @Override
    public void stop() {
        endpoint.stop();
    }

    // get the wsdl at: http://localhost:9999/ws/shouty?wsdl
    public static void main(String args[]) {
        int port = 9999;
        ShoutyApi shoutyApi = new DomainShouty();
        Endpoint endpoint = Endpoint.publish("http://localhost:" + port + "/ws/shouty", new ShoutyWebService(shoutyApi));
        new ShoutySoapServer(endpoint).start();
    }
}
