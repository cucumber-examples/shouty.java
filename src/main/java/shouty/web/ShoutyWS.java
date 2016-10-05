package shouty.web;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface ShoutyWS {
    @WebMethod
    void setLocation(String personName, int locationInMetres);

    @WebMethod
    void shout(String personName, String message);

    @WebMethod
    List<String> getMessagesHeardBy(String personName);
}
