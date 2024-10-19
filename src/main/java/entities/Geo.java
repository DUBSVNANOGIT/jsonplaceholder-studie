package entities;

public class Geo {
    private double lat;
    private double lnt;

    public Geo(double lat, double lnt) {
        this.lat = lat;
        this.lnt = lnt;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLnt() {
        return lnt;
    }

    public void setLnt(double lnt) {
        this.lnt = lnt;
    }
}
