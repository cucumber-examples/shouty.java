package shouty;

import cucumber.api.PendingException;
import cucumber.api.java.no.Gitt;
import cucumber.api.java.no.Når;
import cucumber.api.java.no.Så;

public class RopSteps {
    @Gitt("^at Sonja er på Slottet$")
    public void at_Sonja_er_på_Slottet() throws Throwable {
        Person sonja = new Person();
        double[] slottet = {59.917043, 10.727377};
        sonja.erPå(slottet);
    }

    @Gitt("^Harald er på Munch-muséet$")
    public void harald_er_på_Munch_muséet() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Når("^Sonja roper \"(.*?)\"$")
    public void sonja_roper(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Så("^hører ikke Harald meldingen$")
    public void hører_ikke_Harald_meldingen() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
