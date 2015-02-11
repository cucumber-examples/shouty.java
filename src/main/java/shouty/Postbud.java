package shouty;

import java.util.List;

public class Postbud {
    private List<Person> abonnenter;

    public void distribuer(String beskjed) {

    }

    public void abonner(Person abonnent) {
        abonnenter.add(abonnent);
    }
}
