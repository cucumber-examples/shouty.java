package io.cucumber.shouty.ws;

import io.cucumber.shouty.ShoutyApi;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface ShoutyWs extends ShoutyApi {
    @Override
    @WebMethod
    void setLocation(String personName, int locationInMetres);

    @Override
    @WebMethod
    void shout(String personName, String message);

    @Override
    @WebMethod
    List<String> getMessagesHeardBy(String personName);
}
