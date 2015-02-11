package shouty;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private final Postbud postbud;
    private List<String> mottatteMeldinger = new ArrayList<String>();

    public Person(Postbud postbud) {
        this.postbud = postbud;
        postbud.abonner(this);
    }

    public void erPå(double[] geoLoc) {

    }

    public void roper(String beskjed) {
        postbud.distribuer(this, beskjed);
    }

    public List<String> mottatteMeldinger() {
        return mottatteMeldinger;
    }

    public void hør(String beskjed) {
        mottatteMeldinger.add(beskjed);
    }
}
