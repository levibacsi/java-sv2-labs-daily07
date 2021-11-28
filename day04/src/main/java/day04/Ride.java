package day04;

public class Ride {
    private int dayOfWeek;
    private int rideNumberOfDay;
    private int km;

    public Ride(int dayOfWeek, int rideNumberOfDay, int km) {
        this.dayOfWeek = dayOfWeek;
        this.rideNumberOfDay = rideNumberOfDay;
        this.km = km;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public int getRideNumberOfDay() {
        return rideNumberOfDay;
    }

    public int getKm() {
        return km;
    }

    @Override
    public String toString() {
        return "Ride{" +
                "dayOfWeek=" + dayOfWeek +
                ", rideNumberOfDay=" + rideNumberOfDay +
                ", km=" + km +
                '}';
    }
}
