package io.cucumber.shouty.ws;

import io.cucumber.shouty.ShoutyApi;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "io.cucumber.shouty.ws.ShoutyWs")
public class Shouty implements ShoutyApi {
    private final ShoutyApi shoutyApi;

    public Shouty(ShoutyApi shoutyApi) {
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

