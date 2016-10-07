package shouty;

import shouty.web.ShoutyWS;
import shouty.web.ShoutyWebService;

import javax.xml.namespace.QName;
import javax.xml.ws.Endpoint;
import javax.xml.ws.Service;
import java.net.URL;
import java.util.List;


public class SoapShouty implements ShoutyApi {
    private final ShoutyWS shouty;

    public SoapShouty(String baseUrl) throws Exception {
        URL url = new URL(baseUrl + "?wsdl");
        QName qname = new QName("http://web.shouty/", "ShoutyWebServiceService");

        Service service = Service.create(url, qname);
        shouty = service.getPort(ShoutyWS.class);
    }

    @Override
    public void setLocation(String personName, int locationInMetres) {
        shouty.setLocation(personName, locationInMetres);
    }

    @Override
    public void shout(String shouterName, String message) {
        shouty.shout(shouterName, message);
    }

    @Override
    public List<String> getMessagesHeardBy(String personName) {
        return shouty.getMessagesHeardBy(personName);
    }
}
