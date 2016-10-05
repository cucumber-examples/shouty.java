package shouty;

import shouty.web.ShoutyWS;
import shouty.web.ShoutyWebService;

import javax.xml.namespace.QName;
import javax.xml.ws.Endpoint;
import javax.xml.ws.Service;
import java.net.URL;
import java.util.List;


public class SoapShouty implements Shouty {
    private final Endpoint endpoint;
    private final ShoutyWS shouty;

    public SoapShouty() throws Exception {
        endpoint = Endpoint.create(new ShoutyWebService());
        endpoint.publish("http://localhost:9999/ws/shouty");

        URL url = new URL("http://localhost:9999/ws/shouty?wsdl");
        QName qname = new QName("http://web.shouty/", "ShoutyWebServiceService");

        Service service =  Service.create(url, qname);
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

    @Override
    public void stop() {
        try {
            endpoint.stop();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
