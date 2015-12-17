package shouty;

public class Location {
    private final int lat;
    private final int lng;

    public Location(int lat, int lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public boolean withinRangeOf(Location location) {
        int dlat = this.lat - location.lat;
        int dlng = this.lng - location.lng;
        return Math.sqrt(dlat * dlat + dlng * dlng) < 1;
    }
}
