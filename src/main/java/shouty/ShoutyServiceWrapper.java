package shouty;

import kong.unirest.GenericType;
import kong.unirest.Unirest;

import java.util.List;

public class ShoutyServiceWrapper {

    private static final String REST_URI
            = "https://virtserver.swaggerhub.com/EmmanuelParaskakis/Shout/1.0.0/shouts";

    public List<String> getShouts() {
        return Unirest.get(REST_URI).asObject(new GenericType<List<String>>() {
        }).getBody();
    }
}
