package shouty.web;

import shouty.ShoutyApi;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface ShoutyWS extends ShoutyApi {
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
