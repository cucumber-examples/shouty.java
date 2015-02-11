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
    }

    @Gitt("^at (\\w+) ligger på (.*), (.*)$")
    public void at_sted_ligger_på(String stedsNavn, String latS, String lonS) throws Throwable {
        steder.put(stedsNavn, new double[]{
                Double.valueOf(latS),
                Double.valueOf(lonS)});
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
