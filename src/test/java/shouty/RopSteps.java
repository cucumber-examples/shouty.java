package shouty;

import cucumber.api.java.Before;
import cucumber.api.java.no.Gitt;
import cucumber.api.java.no.Når;
import cucumber.api.java.no.Så;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

public class RopSteps {

    private Postbud postbud;
    private Map<String, Person> personer = new HashMap<String, Person>();
    private Map<String, double[]> steder = new HashMap<String, double[]>();

    @Before
    public void lagPostbudOgPersonerOgSteder() {
        postbud = new Postbud();
        personer.put("Sonja", new Person(postbud));
        personer.put("Harald", new Person(postbud));

        steder.put("Slottet", new double[]{59.917043, 10.727377});
        steder.put("Munch-muséet", new double[]{59.916951, 10.77498});
        steder.put("Egertorget", new double[]{59.9128017,10.7418443});
    }

    @Gitt("^at (.*) er på (.*)$")
    public void at_person_er_på_sted(String personNavn, String stedsNavn) throws Throwable {
        Person person = personer.get(personNavn);
        double[] geoLoc = steder.get(stedsNavn);
        person.erPå(geoLoc);
    }

    @Når("^(.*) roper \"(.*?)\"$")
    public void sonja_roper(String personNavn, String beskjed) throws Throwable {
        personer.get(personNavn).roper(beskjed);
    }

    @Så("^hører ikke (\\w+) meldingen \"(.*?)\"$")
    public void hører_ikke_Harald_meldingen(String personNavn, String forventetMelding) throws Throwable {
        Person person = personer.get(personNavn);

        List<String> forventeteMeldinger = asList(forventetMelding);
        assertNotEquals(forventeteMeldinger, person.mottatteMeldinger());
    }

    @Så("^hører (\\w+) meldingen \"(.*?)\"$")
    public void hører_Harald_meldingen(String personNavn, String forventetMelding) throws Throwable {
        Person person = personer.get(personNavn);

        List<String> forventeteMeldinger = asList(forventetMelding);
        assertEquals(forventeteMeldinger, person.mottatteMeldinger());
    }
}
