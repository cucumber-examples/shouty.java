package shouty;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private final Postbud postbud;

    public Person(Postbud postbud) {
        this.postbud = postbud;
    }

    public void erPå(double[] geoLoc) {

    }

    public void roper(String beskjed) {
        postbud.distribuer(beskjed);
    }

    public List<String> mottatteMeldinger() {
        return new ArrayList<String>();
    }
}
