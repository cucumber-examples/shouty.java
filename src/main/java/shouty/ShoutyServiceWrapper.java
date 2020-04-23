package shouty;

import kong.unirest.*;

import java.util.List;

public class ShoutyServiceWrapper {

    private static final String majorMinorVersion = "1.2";
    private static final String REST_ROOT_URI
            = "https://virtserver.swaggerhub.com/sbc6/Shout/";

    private String REST_URI;

    public void chooseStubbedData(String dataSet) {
        REST_URI = REST_ROOT_URI + majorMinorVersion + dataSet;
    }

    public void setLocation(String person, Location location) {
        HttpResponse response = Unirest.put(REST_URI + "/people/" + person)
                .body(location)
                .asEmpty();

        if (response.getStatus() != 200) {
            throw new RuntimeException("Unexpected return code setting a person's location': " + Integer.toString(response.getStatus()));
        }
    }

    public void shout(Shout shout) {
        HttpResponse response = Unirest.post(REST_URI + "/shouts")
                .body(shout)
                .asEmpty();

        if (response.getStatus() != 201) {
            throw new RuntimeException("Unexpected return code from shouting: " + Integer.toString(response.getStatus()));
        }
    }

    public List<Shout> getShouts() {

        HttpResponse<List<Shout>> response = Unirest.get(REST_URI + "/shouts").asObject(new GenericType<List<Shout>>() {
        });

        if (response.getStatus() != 200) {
            throw new RuntimeException("Unexpected return code retrieving shouts: " + Integer.toString(response.getStatus()));
        }

        return response.getBody();
    }
}
