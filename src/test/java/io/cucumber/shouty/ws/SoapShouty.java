package io.cucumber.shouty.ws;

import io.cucumber.shouty.ShoutyApi;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;
import java.util.List;


public class SoapShouty implements ShoutyApi {
    private final ShoutyWs shoutyWs;

    public SoapShouty(String baseUrl) throws Exception {
        URL url = new URL(baseUrl + "?wsdl");
        QName qname = new QName("http://ws.shouty.cucumber.io/", "ShoutyService");

        Service service = Service.create(url, qname);
        shoutyWs = service.getPort(ShoutyWs.class);
    }

    @Override
    public void setLocation(String personName, int locationInMetres) {
        shoutyWs.setLocation(personName, locationInMetres);
    }

    @Override
    public void shout(String shouterName, String message) {
        shoutyWs.shout(shouterName, message);
    }

    @Override
    public List<String> getMessagesHeardBy(String personName) {
        return shoutyWs.getMessagesHeardBy(personName);
    }
}
