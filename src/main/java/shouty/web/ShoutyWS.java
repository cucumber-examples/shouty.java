package shouty.web;

import shouty.DomainShouty;
import shouty.Shouty;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.util.ArrayList;
import java.util.List;

@WebService
public class ShoutyWS {
    private final Shouty shouty = new DomainShouty();
    private String message = new String("ShoutyWS, ");

    @WebMethod
    public void setLocation(String personName, int locationInMetres) {
        shouty.setLocation(personName, locationInMetres);
    }

    @WebMethod
    public void shout(String personName, String message) {
        shouty.shout(personName, message);
    }

    @WebMethod
    public List<String> getMessagesHeard(String personName) {
        return shouty.getMessagesHeardBy(personName);
    }

    // get the wsdl at: http://localhost:9999/ws/shouty?wsdl
    public static void main (String args[]){
        Endpoint.publish("http://localhost:9999/ws/shouty", new ShoutyWS());
    }
}

