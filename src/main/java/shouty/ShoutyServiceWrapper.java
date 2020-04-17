package shouty;

import kong.unirest.GenericType;
import kong.unirest.Unirest;

import java.util.List;

public class ShoutyServiceWrapper {

    private static final String REST_ROOT_URI
            = "https://virtserver.swaggerhub.com/smartbear/Shout/"; // 1.0.0/shouts";

    private String REST_URI;

    public List<Shout> getShouts() {
        return Unirest.get(REST_URI + "/shouts").asObject(new GenericType<List<Shout>>() {
        }).getBody();
    }

    public void setAPI(String api) {
        REST_URI = REST_ROOT_URI + api;
    }
}
