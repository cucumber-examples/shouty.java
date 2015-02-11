package shouty;

import java.util.ArrayList;
import java.util.List;

public class Postbud {
    private List<Person> abonnenter = new ArrayList<Person>();

    public void distribuer(String beskjed) {
        for (Person abonnent : abonnenter) {
            abonnent.hør(beskjed);
        }
    }

    public void abonner(Person abonnent) {
        abonnenter.add(abonnent);
    }
}
