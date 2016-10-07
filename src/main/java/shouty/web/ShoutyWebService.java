package shouty.web;

import shouty.ShoutyApi;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "shouty.web.ShoutyWS")
public class ShoutyWebService implements ShoutyApi {
    private final ShoutyApi shoutyApi;

    public ShoutyWebService(ShoutyApi shoutyApi) {
        this.shoutyApi = shoutyApi;
    }

    @Override
    @WebMethod
    public void setLocation(String personName, int locationInMetres) {
        shoutyApi.setLocation(personName, locationInMetres);
    }

    @Override
    @WebMethod
    public void shout(String personName, String message) {
        shoutyApi.shout(personName, message);
    }

    @Override
    @WebMethod
    public List<String> getMessagesHeardBy(String personName) {
        return shoutyApi.getMessagesHeardBy(personName);
    }

}

