package shouty;

import kong.unirest.GenericType;
import kong.unirest.Unirest;

import java.util.List;

public class ShoutyServiceWrapper {

    private static final String REST_ROOT_URI
            = "https://virtserver.swaggerhub.com/smartbear/Shout/1.3.";

    private String REST_URI;

    public void chooseStubbedData(String dataSet) {
        REST_URI = REST_ROOT_URI + dataSet;
    }

    public void setLocation(PersonLocation personLocation) {
//        Unirest.post(REST_URI + "/shouts")
//                .body(personLocation)
//                .asEmpty();
    }

    public void shout(Shout shout) {
//        Unirest.post(REST_URI + "/shouts")
//                .body(shout)
//                .asEmpty();
    }

    public List<Shout> getShouts() {
        return Unirest.get(REST_URI + "/shouts").asObject(new GenericType<List<Shout>>() {
        }).getBody();
    }
}
