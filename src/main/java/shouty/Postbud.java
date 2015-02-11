package shouty;

import java.util.ArrayList;
import java.util.List;

public class Postbud {
    private List<Person> abonnenter = new ArrayList<Person>();

    public void distribuer(Person avsender, String beskjed) {
        for (Person abonnent : abonnenter) {
            if (erInneforRekkevidde(avsender, abonnent)) {
                abonnent.hør(beskjed);
            }
        }
    }

    private boolean erInneforRekkevidde(Person avsender, Person mottaker) {
        return distFrom(
                avsender.getLat(),
                avsender.getLon(),
                mottaker.getLat(),
                mottaker.getLon()
        ) <= 1;
    }

    public void abonner(Person abonnent) {
        abonnenter.add(abonnent);
    }

    private double distFrom(double lat1, double lng1, double lat2, double lng2) {
        double earthRadius = 6371; //kilometers
        double dLat = Math.toRadians(lat2 - lat1);
        double dLng = Math.toRadians(lng2 - lng1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLng / 2) * Math.sin(dLng / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double dist = earthRadius * c;

        return dist;
    }
}
