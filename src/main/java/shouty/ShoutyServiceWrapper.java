package shouty;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.GenericType;
import java.util.List;

/**
     */
public class ShoutyServiceWrapper {

    private static final String REST_URI
            = "https://virtserver.swaggerhub.com/EmmanuelParaskakis/Shout/1.0.0/shouts";

    private Client client = ClientBuilder.newClient();

    public List<String> getShouts() {
        return client
                .target(REST_URI)
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<String>>(){});
    }
}