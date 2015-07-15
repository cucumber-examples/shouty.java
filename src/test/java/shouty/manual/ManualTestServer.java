package shouty.manual;

import shouty.core.Network;
import shouty.core.Person;
import shouty.web.ShoutyServer;

import java.util.HashMap;
import java.util.Map;

public class ManualTestServer {

    public static void main(String[] args) throws Exception {
        Network network = new Network(100);
        Map<String, Person> people = new HashMap<String, Person>() {{
            put("Sean", new Person(network, 0));
            put("Lucy", new Person(network, 100));
            put("Larry", new Person(network, 150));
        }};
        new ShoutyServer().start(people, 3000);
    }

}
