package shouty.web;

import shouty.DomainShouty;
import shouty.Shouty;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.util.List;

@WebService(endpointInterface = "shouty.web.ShoutyWS")
public class ShoutyWebService implements ShoutyWS {
    private final Shouty shouty = new DomainShouty();

    @Override
    @WebMethod
    public void setLocation(String personName, int locationInMetres) {
        shouty.setLocation(personName, locationInMetres);
    }

    @Override
    @WebMethod
    public void shout(String personName, String message) {
        shouty.shout(personName, message);
    }

    @Override
    @WebMethod
    public List<String> getMessagesHeardBy(String personName) {
        return shouty.getMessagesHeardBy(personName);
    }

    // get the wsdl at: http://localhost:9999/ws/shouty?wsdl
    public static void main (String args[]){
        Endpoint.publish("http://localhost:9999/ws/shouty", new ShoutyWebService());
    }
}

