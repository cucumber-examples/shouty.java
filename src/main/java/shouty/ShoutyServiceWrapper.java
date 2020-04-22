package shouty;

import kong.unirest.*;

import java.util.List;

public class ShoutyServiceWrapper {

    private static final String majorMinorVersion = "1.1";
    private static final String REST_ROOT_URI
            = "https://virtserver.swaggerhub.com/sbc6/Shout/";

    private String REST_URI;

    public void chooseStubbedData(String dataSet) {
        REST_URI = REST_ROOT_URI + majorMinorVersion + dataSet;
    }

    public void setLocation(PersonLocation personLocation) {
        Unirest.post(REST_URI + "/location")
                .body(personLocation)
                .asEmpty();
    }

    public void shout(Shout shout) {
        Unirest.post(REST_URI + "/shouts")
                .body(shout)
                .asEmpty();
    }

    public List<Shout> getShouts() {

        HttpResponse<List<Shout>> response = Unirest.get(REST_URI + "/shouts").asObject(new GenericType<List<Shout>>() {
        });

        if (response.getParsingError().isPresent()) {
            UnirestParsingException ex = response.getParsingError().get();
            System.out.println(ex.getOriginalBody()); // Has the original body as a string.
            System.out.println(ex.getMessage()); // Will have the parsing exception.
            System.out.println(ex.getCause().getMessage()); // of course will have the original parsing exception itself.
        }
        return response.getBody();
    }
}
